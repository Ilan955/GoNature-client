// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

package Client;


import Client.*;
import Entities.Traveller;
import Entities.departmentEmployee;
import common.*;
import src.ocsf.client.AbstractClient;

import java.io.*;

/**
 * This class overrides some of the methods defined in the abstract superclass
 * in order to give more functionality to the client.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 * @version July 2000
 */
public class GoClient extends AbstractClient {
	// Instance variables **********************************************

	/**
	 * The interface type variable. It allows the implementation of the display
	 * method in the client.
	 */
	goIF clientUI;
	public static boolean awaitResponse = false;

	// Constructors ****************************************************

	/**
	 * Constructs an instance of the chat client.
	 *
	 * @param host     The server to connect to.
	 * @param port     The port number to connect on.
	 * @param clientUI The interface type variable.
	 */

	public GoClient(String host, int port, goIF clientUI) throws IOException {
		super(host, port); // Call the superclass constructor
		this.clientUI = clientUI;
		// openConnection();
	}

	// Instance methods ************************************************

	/**
	 * This method handles all data that comes in from the server.
	 *
	 * @param msg The message from the server.
	 */
	public void handleMessageFromServer(Object msg) {
		//System.out.println("--> handleMessageFromServer");
		awaitResponse = false;
		String st;
		st = msg.toString();
	//	System.out.print(st);
		String[] result = st.split(" ");
		String controller = result[0];
		String action = result[1];
		int len = result.length;
		len-=2;
		String[] toSend = new String[len];
		for (int i=0;i<len;i++)
			toSend[i] = result[i+2];
		//System.out.print(result[5]);
		//System.out.print(action);
		  if (controller.equals("UserController"))
		  {
			  ClientUI.userController.gotMessage(action,toSend);
		  }
		  else if (controller.equals("EmployeeController"))
		  {
			  ClientUI.employeeController.gotMessage(action,toSend);
		  }
			//  ClientUI.userController.setChangeScreen(true);
		  //else if(result.length==3)
		 // else
			//  ClientUI.aFrame.GetRepondId(result);
		/*  switch (result[0])
		  {
		  	case "EmployeeController_getEmpByID":
		  		ClientUI.employeeControl1ler.setEmp(result);
		  		break;
		  	case "UserController_DisplayTraveller":
				System.out.println("Got here b");
		  		ClientUI.welcomeController.setStrings(result);
		  		break;
		  } */
	}

	/**
	 * This method handles all data coming from the UI
	 *
	 * @param message The message from the UI.
	 */

	public void handleMessageFromClientUI(String message) {
		try {
			openConnection();// in order to send more than one message
			awaitResponse = true;
			sendToServer(message);
			if(message.equals("exit"))
				quit();
			// wait for response
			else
			while (awaitResponse) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			/*
			 * 
			 * There may be an exception trhown because there is no connection to the server 
			 * This can happen if clicking conectivity when there is no connection
			 * This can happen when click exit whene there is no connecton to the server
			 * This can happen when trying to submit data to the server when there is no connection to the server
			 * 
			 * 
			 */
		} catch (IOException e) {
			if(!(message.equals("exit"))) {
				ClientUI.aFrame.thePortIsLBL.setText("No connection");
				ClientUI.aFrame.thePortIsLBL.setVisible(true);
				clientUI.display("Could not send message to server: Terminating client." + e);
				
			}	
		} 
	}

	/**
	 * This method terminates the client.
	 */
	public void quit() {
		try {
			closeConnection();
		} catch (IOException e) {
		}
		System.exit(0);
	}
}
//End of ChatClient class
