package GUI;

import javafx.beans.property.SimpleStringProperty;

public class Data {
	private SimpleStringProperty Date;
	private SimpleStringProperty Park;
	private SimpleStringProperty Time;
	private SimpleStringProperty numOfVisit;
	private SimpleStringProperty Price;
	public Data(String date, String park, String time,
			String numOfVisit, String price) {
		
		this.Date = new SimpleStringProperty(date);
		this.Park = new SimpleStringProperty(park);
		this.Time = new SimpleStringProperty(time);
		this.numOfVisit = new SimpleStringProperty(numOfVisit);
		this.Price = new SimpleStringProperty(price);
	}
	public void setDate(String date) {
		Date = new SimpleStringProperty(date);
	}
	public void setPark(String park) {
		Park = new SimpleStringProperty(park);
	}
	public void setTime(String time) {
		Time = new SimpleStringProperty(time);
	}
	public void setNumOfVisit(String numOfVisit) {
		this.numOfVisit = new SimpleStringProperty(numOfVisit);
	}
	public void setPrice(String price) {
		new SimpleStringProperty(price);
	}
	public String getDate() {
		return Date.get();
	}
	public String getPark() {
		return Park.get();
	}
	public String getTime() {
		return Time.get();
	}
	public String getNumOfVisit() {
		return numOfVisit.get();
	}
	public String getPrice() {
		return Price.get();
	}
	
}
