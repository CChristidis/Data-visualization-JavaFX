package Panes;

import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class PaneCountry extends Application implements Panes {
	Names names = new Names();  // object to obtain indicators or countries names.
	
	Stage window;
    Scene scene;
    ListView<String> listView;
    Button button;
	
    
  
    public List<String> setSelections(){
    	return names.getNY_indic();
    }
  
       
    @Override public void start(Stage stage) {
    	
    	button = new Button ("Submit");
    	
        window = stage;
        window.setTitle("Countries");
        
        
        listView = new ListView<>();
        listView.getItems().addAll(setSelections());
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(listView, button);
        
        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
        
    
    } 
    
   


    
    public static void main(String[] args) {
        launch(args);
    }
    
}
