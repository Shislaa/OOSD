package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.opencsv.CSVReader;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
// [[Initialize variables]]
	static private File HallFile = new File("Hall.csv");
	
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
		try {
			Scanner scan = new Scanner(HallFile);
			ArrayList<Hall> halllist = new ArrayList<>();
			CSVReader reader = new CSVReader(new FileReader("Hall.csv"));
			//System.out.println(halllist);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//launch(args);
		// hey this is for testing
	}
}
