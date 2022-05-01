package main.java.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import main.java.controller.charts.PlotBarChartController;
import main.java.controller.charts.PlotScatterChartController;
import main.java.controller.charts.PlotTimelineChartController;
import main.java.dao.Connector;
import main.java.dao.CountryDAO;
import main.java.dao.CountryDAOFactory;
import main.java.dao.IndicatorDAO;
import main.java.dao.IndicatorDAOFactory;
import main.java.dao.Names;
import main.java.dao.ValueFromCountryAndIndicatorDAO;
import main.java.dao.ValueFromCountryAndIndicatorDAOFactory;

public class Controller implements Initializable {
	
	List<String> selected_countries = new ArrayList<String>();
	List<String> selected_indicators = new ArrayList<String>();
	List<Integer> years = new ArrayList<Integer>();
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
    private Button submitButton;
   

	@FXML
	void Select1(ActionEvent event) {
		String s = countryComb.getSelectionModel().getSelectedItem().toString();
		selected_countries.add(s);
	}
	
	@FXML
	void Select2(ActionEvent event) {
		String s = indicatorComb.getSelectionModel().getSelectedItem().toString();
		selected_indicators.add(s);
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
	void Submit(ActionEvent event) throws IOException {  
		// actions that succeed after pressing the submit button.
		closeWindow(event);
		
		Parent root = FXMLLoader.load(getClass().getResource("..//view//FXMLBarChart.fxml"));
	
		
		// ----------------- Testing -----------------
		
		createYearsList();
		
		ValueFromCountryAndIndicatorDAO obj2 = ValueFromCountryAndIndicatorDAOFactory.getValueFromCountryAndIndicatorDAO("mysql");
		CountryDAO obj3 = CountryDAOFactory.getCountryDAO("mysql");
		IndicatorDAO obj4 = IndicatorDAOFactory.getIndicatorDAO("mysql");
		
		Map<List<String>, Long> mapForChart;
		List<Integer> cids = obj3.readCountryIdFromName(selected_countries);
		List<Integer> iids = obj4.readIndicatorIdFromName(selected_indicators);
		
		
		mapForChart = obj2.readValueFromCountryAndIndicator(cids, iids, years);
		
		
		PlotScatterChartController obj = new PlotScatterChartController(mapForChart, Integer.parseInt(this.yearformat), 
				Integer.parseInt(this.startingyear), Integer.parseInt(this.endingyear));
		obj.plotChart();
		System.gc();
		
		
		// ----------------- Testing -----------------
	
		
	}
	
	void closeWindow(ActionEvent event) {
		Node source = (Node) event.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
	}
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Names names_object = new Names();
		
		ObservableList<String> countryListForCombo = FXCollections.observableArrayList(names_object.getCountries());
		countryComb.setItems(countryListForCombo);

		
		names_object.getNY_indic().addAll(names_object.getSE_indic());	// merge NY and SE indicator families' lists.
		
		ObservableList<String> indicatorListForCombo = FXCollections.observableArrayList(names_object.getNY_indic());
		indicatorComb.setItems(indicatorListForCombo);
		
		ObservableList<String> yearFormatListForCombo = FXCollections.observableArrayList(names_object.getYearSpan());
		yearformatComb.setItems(yearFormatListForCombo);
		
		ObservableList<String> yearsListForCombo = FXCollections.observableArrayList(names_object.getYears());
		startingyearComb.setItems(yearsListForCombo);
		endingyearComb.setItems(yearsListForCombo);
		
	}
	
	
	
	public void createYearsList() {
		int yearformat = Integer.parseInt(this.yearformat);
		int startingyear = Integer.parseInt(this.startingyear);
		int endingyear = Integer.parseInt(this.endingyear);
		int i;
		
		isAcceptableForm(yearformat, startingyear, endingyear);
		
		for (i = startingyear; i < endingyear + 1; i ++)
			this.years.add(i);
	}
	
	public void isAcceptableForm(int yearformat, int startingyear, int endingyear) {
		if (endingyear - startingyear < 0) {
			System.out.println("Aborting.");
			System.out.println("Ending year must be greater than starting year.");
			System.exit(-1);
		}
	}
	
	
	public List<String> getSelected_indicators() {
		return selected_indicators;
	}

	public void setSelected_indicators(List<String> selected_indicators) {
		this.selected_indicators = selected_indicators;
	}


	
	
	
	

}