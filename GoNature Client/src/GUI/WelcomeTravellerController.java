package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import Client.ClientUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WelcomeTravellerController implements Initializable {

    @FXML
    private Label userNamelb;

    @FXML
    private Label TypeLBL;
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {	
    	String first = ClientUI.userController.traveller.getFirstName();
    	String last = ClientUI.userController.traveller.getLastName();
    	StringBuffer name = new StringBuffer();
    	name.append(first);
    	name.append(" ");
    	name.append(last);
    	String tName = name.toString();
    //	System.out.println("\n" + tName);
   // 	userNamelb.setText(tName);
    	userNamelb.setText(tName);
    	TypeLBL.setText(ClientUI.userController.traveller.getType());
	}
    

	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("WelcomeTraveller.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Welcome traveller");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
    
    
    @FXML
    void WhenPressEnterWithoutOrderBtn(ActionEvent event) {
    	
    }

    @FXML
    void WhenPressEsitingOrdersBtn(ActionEvent event) {

    }

    @FXML
    void WhenPressLogOutBtn(ActionEvent event) {

    }

    @FXML
    void WhenPressMakeNewOrderBtn(ActionEvent event) {

    }

}


