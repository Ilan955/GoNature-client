
package Client;

import javafx.application.Application;

import javafx.stage.Stage;



import java.util.Vector;

import Controller.EmployeeController;
import Controller.OrderController;
import Controller.UserController;
import GUI.*;


public class ClientUI extends Application {
	public static ClientController chat; // only one instance
	public  static baseGuiController aFrame;

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

	public static void main(String args[]) throws Exception {
		launch(args);
	} // end main
	
	public static void set(String ip,int port) {
		 chat= new ClientController("localhost", 5555); 
	}
	@Override 
	public void start(Stage primaryStage) throws Exception {
		aFrame=new baseGuiController();
		cp = new loginClientController();
		cp.start(primaryStage);
		set("localhost",5555);
		//ep = new EnterParkNowController();
//		wt=new WelcomeTravellerController();
		//ep.start(primaryStage);
		//employeeController = new EmployeeController();
	//	orderController= new OrderController();
		//orderScreenController = new OrderScreenController();
	//	orderScreenController.start(primaryStage);
	//	wt = new WelcomeTravellerController();
		userController = new UserController();
		employeeController = new EmployeeController();
		welcomeTraveller= new WelcomeTravellerController();
		welcomeController = new WelcomeAndLoginController();
		welcomeController.start(primaryStage);
		
		
	}


}
