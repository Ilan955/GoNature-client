
package Client;

import javafx.application.Application;
import javafx.stage.Stage;
import java.util.Vector;


import Controller.EmployeeController;
import Controller.OrderController;
import Controller.UserController;

import Controller.*;

import GUI.*;

public class ClientUI extends Application {
	public static ClientController chat; // only one instance
	public static baseGuiController aFrame;
	public static EntranceParkController entrencePark;
	public static loginClientController cp;
	public static OrderScreenController oc;
	public static EnterParkNowController ep;
	public static WelcomeTravellerController wt;
	public static WelcomeAndLoginController welcomeController;
	public static WelcomeTravellerController welcomeTraveller;
	public static loginClientController LoginClientController;
	public static OrderScreenController orderScreenController;
	public static OrderController orderController;

	public static EmployeeController employeeController;
	public static UserController userController;
	//public static UserController userController;

	// public static UserController userController;
	public static SignUpController signUpController;


	public static void main(String args[]) throws Exception {
		launch(args);
	} // end main


	public static void set(String ip, int port) {
		chat = new ClientController(ip, port);
	}
	@Override 
	public void start(Stage primaryStage) throws Exception {
		cp = new loginClientController();
		entrencePark=new EntranceParkController();
		LoginClientController= new loginClientController();
		orderScreenController = new OrderScreenController();
		orderController=new OrderController();
		signUpController = new SignUpController();
		cp.start(primaryStage);
		

	}

}
