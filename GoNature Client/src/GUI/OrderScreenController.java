package GUI;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Client.ClientUI;
import Entities.Person;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
public class OrderScreenController implements Initializable{


	

	    @FXML
	    private ComboBox WantedParkCB;

	    @FXML
	    private DatePicker DateLbl;

	    @FXML
	    private TextField NumOfVisotrsLbl;

	    @FXML
	    private ComboBox TimeOfVisitCB;

	    @FXML
	    private TextField EmailLbl;

	    @FXML
	    private TextField PhoneNumberLbl;

	    @FXML
	    private Label IdOfViditorLbl;

	    @FXML
	    private Label PriceLbl;
	    Person t;
	    ObservableList<String> listForParks;
	    ObservableList<String> listForTimes;
	    
	    //Set the park names for the combo box to be able to show them on the screen
	    private void setWantedParkCm() {
			ArrayList<String> parks = new ArrayList<String>();	
			parks.add("ParkA");
			parks.add("ParkB");
			parks.add("ParkC");

			listForParks = FXCollections.observableArrayList(parks);
			WantedParkCB.setItems(listForParks);
		}
	    /*
	     * enter to the combo box the times from 8 Am to 12 Pm
	     */
	    private void SetTimeParkCm() {
	    	String half=":30";
	    	String whole=":00";
	    	String t;
	    	int flag=0;
	    	ArrayList<String> Times = new ArrayList<String>();	
	    	
	    	for (int i=8;i<24;i++) {
	    		if(flag==0) {
	    		t= Integer.toString(i)+whole;
	    		Times.add(t);
	    		flag++;
	    		i--;
	    		}
	    		else {
	    			t= Integer.toString(i)+half;
	    			Times.add(t);
		    		flag--;
	    		}		    		
	    	}  
	    	listForTimes = FXCollections.observableArrayList(Times);
    		TimeOfVisitCB.setItems(listForTimes);	
	    }
	    //!!!!!!! NEED TO CHANGE ID BY THE USER CONTROLLER!!!!!
	    public void setIdOfMakingOrder() {
	    	IdOfViditorLbl.setText("31198");
	    }
	    //initialize the parks and the times, and the id of the user who is making the order
	    @Override
		public void initialize(URL arg0, ResourceBundle arg1) {	
			setWantedParkCm();
			SetTimeParkCm();
			setIdOfMakingOrder();
		}
	    
	    
	    public void start(Stage primaryStage) throws Exception {	
			Parent root = FXMLLoader.load(getClass().getResource("NewOrder.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("New Order");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		}

	    @FXML
	    void WhenClickCalculatePriceBtn(ActionEvent event) {

	    }

	    @FXML
	    void WhenClickNextBtn(ActionEvent event) throws IOException {
	    	String timeofVisit=(String)TimeOfVisitCB.getValue();
	    	String date=DateLbl.getValue().toString();
	    	String wanted= (String)WantedParkCB.getValue();
	    	int numOfVisitors= Integer.parseInt(NumOfVisotrsLbl.getText());
	    	Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
	    	
	    	//here we will send the data we got from the page, we need to use "the type"
	    	//!!!!!!! TYPE NEED TO BE CHANGED !!!!!!!!
	    	ClientUI.orderController.setEmailAndPhone(EmailLbl.getText(), PhoneNumberLbl.getText());
	    	ClientUI.orderController.canMakeOrder(timeofVisit, date, wanted, "Member", numOfVisitors,stage);
	    	System.out.println("Time: "+timeofVisit+" date: "+date+" wantedPark: "+wanted+" number of visit: "+numOfVisitors);
	    }

	    @FXML
	    void WhenClickPreviusBtn(ActionEvent event) throws IOException {
	    	Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
	    	Parent root = FXMLLoader.load(getClass().getResource("WelcomeAndLoginScreen.fxml"));
    		Scene scene = new Scene(root);
    		stage.setTitle("Welcome");
    		stage.setScene(scene);
			
    		stage.show();
	    }

	


}
