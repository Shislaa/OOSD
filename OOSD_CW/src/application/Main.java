package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// [[ Initialize Login pane ]]
			Parent pane = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(pane);
			primaryStage.setTitle("UWE Accomodation System");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Human HM = new Human();
		Lease test = new Lease();
		test.getStudent().getID();
		launch(args);
		// hey this is for testing
	}
}
