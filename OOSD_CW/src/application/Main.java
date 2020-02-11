package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
			int t = 0;
			while(scan.hasNext()) {
				if (t > 0) {
				Hall hall = new Hall();
				scan.useDelimiter(",");
				System.out.println("Name: " + scan.next());
				System.out.println("Address: "+scan.next());
				System.out.println("Number of room: "+scan.next());
				System.out.println("Hall Phone Number: "+scan.next());
				System.out.println("Warden ID: "+scan.next());
//				hall.setName(scan.next());
//				hall.setAddress(scan.next());
//				//hall.setNumroom(scan.nextInt());
//				hall.setTelenum(scan.next());
//				hall.Warden.setID(scan.next());
//				halllist.add(hall);
				}
				if(t == 0) {
					scan.nextLine();
				}
				t++;
			}
			//System.out.println(halllist);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//launch(args);
		// hey this is for testing
	}
}
