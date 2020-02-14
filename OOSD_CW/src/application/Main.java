package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
// [[Initialize variables]]
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
	// [[ MAIN FUNCTION ]]
	public static void main(String[] args) throws IOException, CsvValidationException {
		launch(args);
	}

}



