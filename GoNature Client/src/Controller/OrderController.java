package Controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import Client.ClientUI;
import Entities.Order;
import Entities.Traveller;
import GUI.Data;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class OrderController {
public Traveller t ;
//!!!! WHAT NEED TO BE !!!!
//Traveller t = ClientUI.userController.traveller
public Order order;
public boolean valid=false;
ArrayList<String> mess= new ArrayList<String>();
private String currentEmail;
private String currentPhone;
public float currentPrice;
private Stage stage1;
private ArrayList<String> alternativeDates =new ArrayList<String>();
public ObservableList<Data> ob = FXCollections.observableArrayList();
/*
 * This method will check with the db if there is a place in the park for this time and date got
 * if so, will create new order, and save it later in the DB.
 * will check first if there is an order for the current time 
 * 
 */
public void canMakeOrder(LocalTime time, LocalDate dateOfVisit, String wantedPark, String type,int numOfVisitors,Stage stage) throws IOException{
	
	order=new Order(5, time, dateOfVisit, wantedPark,numOfVisitors, (float)50);
	LocalTime openingTime = LocalTime.of(8,0); 
	LocalTime closingTime = LocalTime.of(23,30);
	LocalTime turn=LocalTime.of(11, 00);
	/*
	 * check what are the boundary's
	 * this will numbers will help us to know how many park in this times.
	 */
	LocalTime from=null;
	LocalTime to=null;
	LocalTime tmp;
	tmp=time.minusMinutes(30);
	if(tmp.isBefore(turn))
		from=openingTime;
	else {
		for(int i =3;i>=0;i--) {
			tmp=time.minusHours(i);
			if(!(tmp.isBefore(openingTime))) {
				from=tmp;
				break;
			}	
		}
	}
	tmp =time.minusHours(3);
	tmp=tmp.minusMinutes(30);
	if(!(tmp.isBefore(openingTime)))
		from=tmp;
	
		for(int i =3;i>=0;i--) {
			tmp=time.plusHours(i);
			if(tmp.isBefore(closingTime)) {
				to=tmp;
				break;
			}
		}
	tmp=time.plusHours(3);
	tmp=tmp.plusMinutes(30);
	if(tmp.isBefore(closingTime))
		to=tmp;
	
	System.out.println("The interval for "+time.toString());
	System.out.println("\nFrom time: "+ from.toString()+" To Time: "+ to.toString());
	
	/*
	 * Send the date, time number of visitors and wanted park to the db
	 * in the db will return the amount of people in the park for the boudry time set above
	 * in new method in the OrderController will check if :
	 * 		Add new order for the current orders be possible
	 * 		if the amount of visitors in total will be greater then how many visitors can enter
	 * 		will show the unproved order screen
	 */
	
	
	
	String fromB=from.toString();
	String toB=to.toString();
	System.out.println(fromB);
	StringBuffer sb =new StringBuffer();
	sb.append("canMakeOrder");
	sb.append(" ");
	sb.append(from.toString());
	sb.append(":00");
	sb.append(" ");
	sb.append(to.toString());
	sb.append(":00");
	sb.append(" ");
	sb.append(wantedPark);
	sb.append(" ");
	sb.append(dateOfVisit.toString());
	ClientUI.chat.accept(sb.toString());	
}

public boolean getValid() {
	return valid;
}

public void setEmailAndPhone(String email,String phone) {
	setEmail(email);
	setPhone(phone);
}

public void setStage(Stage stage) {
	this.stage1=stage;
	
}

public Stage getStage() {
	return stage1;
}


//This method will be the connector from the data came from the server to this controller
public void gotMessage(String[] msg) throws IOException {
	String cases= msg[0];
	switch(cases) {
	case "canMakeOrder":
		checkIfCanMakeOrder(msg);
		break;	
	
		
	
	}
	
}

/*
 * This method get from the server all the numbers
 * how many can enter
 * how many visitors overall in the gap
 * if adding will make the maxVisit bigger, move to unapproved order
 */

public void checkIfCanMakeOrder(String[] msg) throws IOException {
	
	int currentVisitorsAtBoundry=Integer.parseInt(msg[1]);
	
	int availableVisitors=Integer.parseInt(msg[2]);
	if(currentVisitorsAtBoundry+order.getNumberOfVisitors()>availableVisitors)
		valid=false;		
	else 
		valid=true;
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

public void wantToCancel(Stage stage) throws IOException {
	
	FXMLLoader loader = new FXMLLoader();
	Pane root = loader.load(getClass().getResource("/GUI/SureIfCancel.fxml").openStream());
	Scene scene = new Scene(root);
	stage.setTitle("Cancel order");
	stage.setScene(scene);
	stage.show();
	
}


public void getAlternativeDates(Stage stage) throws IOException {
	Data d;
	for(int i = 1;i<=15;i++) {
		LocalDate date =order.getDateOfVisit();
		LocalDate temp=date.plusDays(i);
		LocalTime time = order.getTimeInPark();
		String park=(order.getWantedPark());
		int numOfVisit= order.getNumberOfVisitors();
		if(true)
		{
			alternativeDates.add(temp.toString());
		}
		
	}
	for (String var:alternativeDates) {
		d=new Data(var,order.getWantedPark(),order.getTimeInPark().toString(),Integer.toString(order.getNumberOfVisitors()),Float.toString(order.getTotalPrice()));
		ob.add(d);
	}
	
	Parent root = FXMLLoader.load(getClass().getResource("/GUI/AlternativeDates.fxml"));
	Scene scene = new Scene(root);
	stage.setTitle("Welcome");
	stage.setScene(scene);
	
	stage.show();
	
	
}



}
