


import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class FXDriver extends Application {
	   
	/**
	 * The main method for the GUI example program JavaFX version
	 * @param args not used
	 * @throws IOException
	 */
	public static void main(String[] args) {
		launch(args);   
	}
		   
	@Override
	public void start(Stage stage) throws IOException {
		//student Task #1:
		//  instantiate the FXMainPane, name it root
		//  set the scene to hold root
		//set stage title
		FXMainPane root = new FXMainPane();
		int width = 800;
		int height = 600;
		stage.setScene(new Scene(root, width, height));
		stage.setTitle("Hello World GUI");
		//display the stage
		stage.show();

	}
}
