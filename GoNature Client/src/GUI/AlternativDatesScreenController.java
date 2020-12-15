package GUI;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

import Client.ClientUI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class AlternativDatesScreenController implements Initializable  {
	
		@FXML
	    private DatePicker StartDateLbl;
	
	    @FXML
	    private DatePicker EndDateLbl;
	
	    @FXML
	    private ComboBox FromLbl;
		

	    @FXML
	    private Label UserIdLbl;

	    @FXML
	    private TableView<Data> AlternativeTable;
	    
	    @FXML
	    private TableColumn<Data, String> Date;

	    @FXML
	    private TableColumn<Data, String> Park;

	    @FXML
	    private TableColumn<Data, String> Time;

	    @FXML
	    private TableColumn<Data, String> numOfVisit;

	    @FXML
	    private TableColumn<Data, String> Price;

	    @FXML
	    private TableColumn<Data, String> choseOrder;
	    
	    
	    
	    @FXML
	    void WhenClickBack(ActionEvent event) {

	    }
		
	    
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
			Park.setCellValueFactory(new PropertyValueFactory<>("Park"));
			Time.setCellValueFactory(new PropertyValueFactory<>("Time"));
			numOfVisit.setCellValueFactory(new PropertyValueFactory<>("NumOfVisit"));
			Price.setCellValueFactory(new PropertyValueFactory<>("Price"));
			
			AlternativeTable.setItems(ClientUI.orderController.ob);
		}
		//if don't want to enter the waiting list, clicking back and redirect to the Unapproved order
		@FXML
	    void WhenClickBackBtn(ActionEvent event) throws IOException {
			Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
	    	 FXMLLoader loader = new FXMLLoader();
	    		Pane root = loader.load(getClass().getResource("/GUI/CencellOrder.fxml").openStream());
	    		Scene scene = new Scene(root);
	    		stage.setTitle("Cancel order");
	    		stage.setScene(scene);
	    		stage.show();
	    }

		/*
		 * 1. get the date and time from the input
		 * 2. move the data to a method that in the order controller
		 * 3. send the data to the db and get back all the dates and times in range entered.
		 * 4. initialize counter that will reset every "maxDurationVisit" 
		 * 5. counter will count the amount of visitors in park in every "maxDurationVisit"
		 * 6. when reaching new "maxDurationVisit" check if adding the current order possible
		 * 7. if so, create new Data object with the time and date possible
		 * 8. Save it into an ArrayList
		 * 9. Initialize this screen again, and feed the Table with the array.
		 */
	   

	

}
