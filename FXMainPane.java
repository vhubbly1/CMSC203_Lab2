


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	//  declare two HBoxes
	private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Label label;
    private TextField textField;
    private HBox hbox1;
    private HBox hbox2;
	//student Task #4:
	//  declare an instance of DataManager
    private DataManager dataManager;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes
		button1 = new Button("Hello");
        button2 = new Button("Howdy");
        button3 = new Button("Chinese");
        button4 = new Button("Clear");
        button5 = new Button("Exit");
        label = new Label("Feedback:");
        textField = new TextField();
		
		//student Task #4:
		//  instantiate the DataManager instance
		//  set margins and set alignment of the components
        
        dataManager = new DataManager();
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		//  add the buttons to the other HBox
		//  add the HBoxes to this FXMainPanel (a VBox)
        hbox1 = new HBox();
        hbox1.getChildren().addAll(button1, button2, button3);
        HBox.setMargin(button1, new Insets(0, 10, 0, 0));
        HBox.setMargin(button2, new Insets(0, 10, 0, 0));

        hbox2 = new HBox();
        hbox2.getChildren().addAll(button4, button5, label, textField);
        HBox.setMargin(button4, new Insets(0, 10, 0, 0));
        
        hbox1.setAlignment(Pos.CENTER);
        hbox2.setAlignment(Pos.CENTER);

        getChildren().addAll(hbox1, hbox2);
        setSpacing(10);
        setAlignment(Pos.CENTER);
        button1.setOnAction(new ButtonHandler());
        button2.setOnAction(new ButtonHandler());
        button3.setOnAction(new ButtonHandler());
        button4.setOnAction(new ButtonHandler());
        button5.setOnAction(new ButtonHandler());
        
   
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Object source = event.getTarget();
            if (source instanceof Button) {
                Button clickedButton = (Button) source;
                if (clickedButton == button1) {
                    // Button "Hello" clicked
                    String response = dataManager.getHello();
                    textField.setText(response);
                } else if (clickedButton == button2) {
                    // Button "Howdy" clicked
                    String response = dataManager.getHowdy();
                    textField.setText(response);
                } else if (clickedButton == button3) {
                    // Button "Chinese" clicked
                    String response = dataManager.getChinese();
                    textField.setText(response);
                } else if (clickedButton == button4) {
                    // Button "Clear" clicked
                    textField.setText("");
                } else if (clickedButton == button5) {
                    // Button "Exit" clicked
                    Platform.exit();
                    System.exit(0);
                }
            }
        }
	}
}
	
