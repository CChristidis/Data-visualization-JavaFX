package main.java.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import main.java.dao.Connector;
import main.java.dao.Names;

public class Controller implements Initializable {
	
	List<String> selected_countries = new ArrayList<String>();
	List<String> selected_indicators = new ArrayList<String>();
	String startingyear, endingyear, yearformat;
	
	Connector conn = new Connector();
	
	@FXML
	private ComboBox countryComb;
	@FXML
	private ComboBox indicatorComb;
	@FXML
	private ComboBox startingyearComb;
	@FXML
	private ComboBox endingyearComb;
	@FXML
	private ComboBox yearformatComb;
	
    @FXML
    private Button Submit_butt;
   

	@FXML
	void Select1(ActionEvent event) {
		String s = countryComb.getSelectionModel().getSelectedItem().toString();
		// countryComb.setPromptText("Hey");
		//countryComb.getSelectionModel().getSelectedIndex();
		
		selected_countries.add(s);
		// conn.test(selected_countries);
	}
	
	@FXML
	void Select2(ActionEvent event) {
		String s = indicatorComb.getSelectionModel().getSelectedItem().toString();
		
		// indicatorComb.getSelectionModel().getSelectedIndex();
		
		
		selected_indicators.add(s);
		// conn.test(selected_indicators);
	}
	
	@FXML
	void Select3(ActionEvent event) {
		yearformat = yearformatComb.getSelectionModel().getSelectedItem().toString();
	}

	@FXML
	void Select4(ActionEvent event) {
		startingyear = startingyearComb.getSelectionModel().getSelectedItem().toString();
	}

	@FXML
	void Select5(ActionEvent event) {
		endingyear = endingyearComb.getSelectionModel().getSelectedItem().toString();
	}
	
	
	
	
	
	@FXML
	void Submit(ActionEvent event) throws IOException {  // If submit button is pressed, goto this method.
		closeWindow(event);
		// passDataToDB(selected_countries, selected_indicators);
		Parent root = FXMLLoader.load(getClass().getResource("..//view//newWindow.fxml"));
		Controller2 obj = new Controller2();
		
		obj.test_ind(selected_countries.get(0), selected_indicators.get(0), 2020);
		
		Stage new_window = new Stage();
		new_window.setTitle("New window");
		Scene scene = new Scene(root);
		new_window.setScene(scene);
		new_window.show();
	}
	
	void closeWindow(ActionEvent event) {
		Node source = (Node) event.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
	}
	
	void passDataToDB(List<?> ... listOfLists) {
		for(List<?> lst: listOfLists) {
			for(Object el: lst)
				System.out.println(el);
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Names n = new Names();
		
		ObservableList<String> list1 = FXCollections.observableArrayList(n.getCountries());
		countryComb.setItems(list1);

		
		n.getNY_indic().addAll(n.getSE_indic());
		ObservableList<String> list2 = FXCollections.observableArrayList(n.getNY_indic());
		indicatorComb.setItems(list2);
		
		ObservableList<String> list3 = FXCollections.observableArrayList(n.getYearSpan());
		yearformatComb.setItems(list3);
		
		ObservableList<String> list4 = FXCollections.observableArrayList(n.getYears());
		startingyearComb.setItems(list4);
		endingyearComb.setItems(list4);
		
		
		
	}

}
