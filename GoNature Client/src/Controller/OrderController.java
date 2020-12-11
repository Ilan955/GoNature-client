package Controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import Client.ClientUI;
import Entities.Order;
import Entities.Traveller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class OrderController {
public Traveller t ;
//!!!! WHAT NEED TO BE !!!!
//Traveller t = ClientUI.userController.traveller
public Order order;
private int already=0;
private boolean waitre=false;
ArrayList<String> mess= new ArrayList<String>();
private int orderNum=0;
private String currentEmail;
private String currentPhone;
public float currentPrice;

/*
 * This method will check with the db if there is a place in the park for this time and date got
 * if so, will create new order, and save it later in the DB.
 * 
 */
public Order canMakeOrder(String estimatedTimeInPark, String dateOfVisit, String wantedPark, String type,int numOfVisitors,Stage stage) throws IOException{
	StringBuffer sb = new StringBuffer();
	sb.append("canMakeOrder");
	sb.append(" ");
	sb.append(estimatedTimeInPark);
	sb.append(" ");
	sb.append(dateOfVisit);
	sb.append(" ");
	sb.append(wantedPark);
	sb.append(" ");
	sb.append(type);
	sb.append(" ");
	sb.append(numOfVisitors);
	String res = sb.toString();
	System.out.println(res);
	order=new Order(orderNum++, estimatedTimeInPark, dateOfVisit, wantedPark,numOfVisitors, (float)50);
	//waitre=true;
	//ClientUI.chat.accept(res);
	//wait for message back, if there is available place in the park for the current time.
	//while(waitre) {}
	//if already will be one its mean that there is already someone in the park  for this time of date.
	if(already == 1)
	{
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/GUI/CancellOrder.fxml").openStream());
		Scene scene = new Scene(root);
		stage.setTitle("Unapproved Order");
		stage.setScene(scene);
		stage.show();
	}
	/*
	 * There is available place in the park for the visitor
	 * We can insert the data to the DB (data=order)
	 * We can move the traveller to the next page, where it's show the confirm 
	 */
	else {
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/GUI/Confirmation.fxml").openStream());
		Scene scene = new Scene(root);
		stage.setTitle("Unapproved Order");
		stage.setScene(scene);
		stage.show();
	}
		
	return null;
}

public void setEmailAndPhone(String email,String phone) {
	setEmail(email);
	setPhone(phone);
}

//This method will check if there is already a member for the current time and date, if so, will show a error message on the screen
public void gotMessage(String[] msg) {
	
	String cases= msg[0];
	
	switch(cases) {
	case "canMakeOrder":
		already= Integer.parseInt(msg[1]);
		waitre = false;
		break;
		
	}
	
}

public void setPhone(String phone) {
	this.currentPhone= phone;
}
public void setEmail(String email) {
	this.currentEmail=email;
}
public String getPhone() {
	return currentPhone;
}
public String getEmail() {
	return currentEmail;
}

}
