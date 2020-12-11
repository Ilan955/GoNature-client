package Client;

import javafx.application.Application;

import javafx.stage.Stage;

import GUI.*;


public class ClientUI extends Application {
	public static ClientController chat; // only one instance
	public  static baseGuiController aFrame;
	public static loginClientController cp;
	public static OrderScreenController oc;
	public static EnterParkNowController ep;
	public static WelcomeTravellerController wt;
	public static void main(String args[]) throws Exception {
		launch(args);
	} // end main
	
	public static void set(String ip,int port) {
		 chat= new ClientController(ip, port); 
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
//		aFrame=new baseGuiController();
//		cp = new loginClientController();
//		cp.start(primaryStage);
		ep = new EnterParkNowController();
//		wt=new WelcomeTravellerController();
		ep.start(primaryStage);
	}
	

}
