package GUI;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import Client.ClientUI;
import Entities.Order;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
public class ExsitingOrdersScreenController  implements Initializable{

	
	

	

	    @FXML
	    private TableView<Data> ExistingOrderTable;

	    @FXML
	    private TableColumn<Data, String> IDLbl;

	    @FXML
	    private TableColumn<Data, String> DateTbl;

	    @FXML
	    private TableColumn<Data, String> ParkLbl;

	    @FXML
	    private TableColumn<Data, String> TimeLbl;
	    @FXML
	    private TableColumn<Data, String> NumOfVisitLbl;

	    @FXML
	    private TableColumn<Data, String> PriceLbl;

	    

	    @FXML
	    void WhenClickBackBtn(ActionEvent event) {

	    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		DateTbl.setCellValueFactory(new PropertyValueFactory<>("Date"));
		IDLbl.setCellValueFactory(new PropertyValueFactory<>("ID"));
		ParkLbl.setCellValueFactory(new PropertyValueFactory<>("Park"));
		TimeLbl.setCellValueFactory(new PropertyValueFactory<>("Time"));
		NumOfVisitLbl.setCellValueFactory(new PropertyValueFactory<>("NumOfVisit"));
		PriceLbl.setCellValueFactory(new PropertyValueFactory<>("Price"));
		ClientUI.orderController.getExsistingOrders();
		ExistingOrderTable.setItems(ClientUI.orderController.ob);
		addButtonToTable();
		
	}
	
	/*
	 * Creating buttons for every cell there will be
	 * adding an option to cancel the order if wanted
	 * if pressed cancel in the correct cell:
	 * 	Create an order in the OrderController Screen
	 * 	Routing the user to sure if cancell order screen
	 * 
	 */
	
	 private void addButtonToTable() {
	        TableColumn<Data, Void> colBtn = new TableColumn("Cancel");

	        Callback<TableColumn<Data, Void>, TableCell<Data, Void>> cellFactory = new Callback<TableColumn<Data, Void>, TableCell<Data, Void>>() {
	            @Override
	            public TableCell<Data, Void> call(final TableColumn<Data, Void> param) {
	                final TableCell<Data, Void> cell = new TableCell<Data, Void>() {

	                    private final Button btn = new Button("Cancel");

	                    {
	                        btn.setOnAction((ActionEvent event) -> {
	                        	
	                            Data data = getTableView().getItems().get(getIndex());
	                            int orderNum=Integer.parseInt(data.getID());
	                            System.out.println(data.getTime());
	                            LocalTime lt=LocalTime.parse(data.getTime());
	                            LocalDate ld = LocalDate.parse(data.getDate());
	                            ClientUI.orderController.isInDb=true;
	                            ClientUI.orderController.order=new Order(orderNum,lt,ld,data.getPark(),Integer.parseInt(data.getNumOfVisit()),Float.parseFloat(data.getPrice()));
	                            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
	                            FXMLLoader loader = new FXMLLoader();
	            	    		Pane root;
								try {
									root = loader.load(getClass().getResource("/GUI/SureIfCancel.fxml").openStream());
									Scene scene = new Scene(root);
		            	    		stage.setTitle("Unapproved Order");
		            	    		stage.setScene(scene);
		            	    		stage.show();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
   
	                        });
	                    }

	                    @Override
	                    public void updateItem(Void item, boolean empty) {
	                        super.updateItem(item, empty);
	                        if (empty) {
	                            setGraphic(null);
	                        } else {
	                            setGraphic(btn);
	                        }
	                    }
	                };
	                return cell;
	            }
	        };

	        colBtn.setCellFactory(cellFactory);

	        ExistingOrderTable.getColumns().add(colBtn);

}
}
