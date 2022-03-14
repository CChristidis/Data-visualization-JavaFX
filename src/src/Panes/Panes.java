package Panes;

import java.util.ArrayList;
import java.util.List;

import javafx.stage.Stage;

public interface Panes {
	abstract public void start(Stage stage);
	public List<String> setSelections();
	
	// abstarct public void initPane();
}
