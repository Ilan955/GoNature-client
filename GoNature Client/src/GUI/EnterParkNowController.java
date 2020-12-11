package GUI;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

import Entities.Park;
import Entities.Traveller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EnterParkNowController {
	private Traveller traveller;
	private Park park;

	@FXML
	private Button btnNext;

	@FXML
	private Button btnPrevious;

	@FXML
	private Label IDlbl;

	@FXML
	private Label PriceLbl;

	@FXML
	private Label WantedParkLbl;

	@FXML
	private Label DateLbl;

	@FXML
	private Label TimeLbl;

	@FXML
	private TextField NumOfVisiotrstxt;

	@FXML
	private Button btnCalculatePrice;

	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("EnterParkNow.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Enter without order");
		primaryStage.setScene(scene);
		primaryStage.show();
		

	}

	public void loadTraveller(Traveller t, Park p) {
		this.park = p;
		this.traveller = t;
		LocalDate myDate = LocalDate.now();
		LocalTime myTime = LocalTime.now();
		 this.IDlbl.setText(traveller.getId());
		 this.WantedParkLbl.setText(park.getParkName());
		this.DateLbl.setText(myDate.toString());
		this.TimeLbl.setText(myDate.toString());
	}

	@FXML
	void WhenClickCalculatePriceBtn(ActionEvent event) {

	}

	@FXML
	void WhenClickNextBtn(ActionEvent event) {

	}

	@FXML
	void WhenClickPreviusBtn(ActionEvent event) throws IOException {
		Stage stage = (Stage) btnPrevious.getScene().getWindow();
		stage.close();
		FXMLLoader loader = new FXMLLoader();
		Stage primaryStage = new Stage();
		Pane root = loader.load(getClass().getResource("/GUI/WelcomeTraveller.fxml").openStream());
		Scene scene = new Scene(root);
		primaryStage.setTitle("Welcome Traveller");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
