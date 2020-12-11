package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WelcomeTravellerController {

    @FXML
    private Label userNamelb;

    @FXML
    private Label TypeLBL;

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


