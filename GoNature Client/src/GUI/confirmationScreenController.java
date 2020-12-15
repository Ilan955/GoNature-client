package GUI;
import java.net.URL;
import java.util.ResourceBundle;

import Client.ClientUI;
import Entities.Order;
import Entities.Traveller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
public class confirmationScreenController implements Initializable{
	
	    @FXML
	    private Label IdOvTravelerLb;

	    @FXML
	    private Label WantedParkLbl;

	    @FXML
	    private Label DateLbl;

	    @FXML
	    private Label TimeLbl;

	    @FXML
	    private Label EmailLbl;

	    @FXML
	    private Label PhoneLbl;

	    @FXML
	    private Label NumVisitLlbl;

	    @FXML
	    private Label PriceLbl;

	    @FXML
	    void WhenClickDoneBtn(ActionEvent event) {

	    }
	    /*
	     * Setting the values of the confirmation based on what was set in the order and what set for the traveller who made the order
	     */
	    public void setValues() {
	    	Order o =ClientUI.orderController.order;
	    	
	    	WantedParkLbl.setText(o.getWantedPark());
	    	DateLbl.setText(o.getDateOfVisit().toString());
	    	TimeLbl.setText(o.getTimeInPark().toString());
	    	EmailLbl.setText(ClientUI.orderController.getEmail());
	    	PhoneLbl.setText(ClientUI.orderController.getPhone());
	    	NumVisitLlbl.setText(Integer.toString(o.getNumberOfVisitors()));
	    	
	    }
	    
	    
	    /*
	     *Showing the information for the user 
	     *the information includes all the data of the order
	     */
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			setValues();
			
		}

	

}
