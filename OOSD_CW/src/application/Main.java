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
	static private 	ArrayList<Hall> HallList = new ArrayList<>();
	static private 	String[] HallTitle;
	static private  String[] RoomTitle;

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
		HallData();
		RoomData();
		
		
		//launch(args);
	}

	// [[ Adding Hall data from file ]]
	public static void HallData() throws NumberFormatException, CsvValidationException, IOException{
		try {

			CSVReader reader = new CSVReader(new FileReader("Hall.csv"));
			int counter = 0;
			while(reader.peek() != null){
				if (counter == 0){
					HallTitle = reader.readNext();
				}
				else {
					HallList.add(new Hall());
					String[] temp = reader.readNext();
					HallList.get(counter - 1).setName(temp[0]);
					HallList.get(counter - 1).setAddress(temp[1]);
					HallList.get(counter - 1).setNumroom(Integer.valueOf(temp[2]));
					HallList.get(counter - 1).setTelenum(temp[3]);
					HallList.get(counter - 1).Warden.setID(temp[4]);
					System.out.println(HallList.get(0).getName());
				}
				counter++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// [[Adding Room data from file]]
	public static void RoomData() throws NumberFormatException, CsvValidationException, IOException{
		try {

			CSVReader reader = new CSVReader(new FileReader("Room.csv"));
			int counter = 0;
			while(reader.peek() != null){
				if (counter == 0){
					RoomTitle = reader.readNext();
				}
				else {
					Room room = new Room();
					String[] temp = reader.readNext();
					room.setHallAddress(temp[0]);
					room.setHallAddress(temp[1]);
					room.setRoomnumber(temp[2]);
					room.setOccupancyStatus(temp[3]);
					room.setCleaningStatus(temp[4]);
					room.setArea(Integer.valueOf(temp[5]));
					room.setRentrate(Integer.valueOf(temp[6]));
					room.roomlease.setLnum(temp[7]);
					room.roomlease.setLduration(temp[8]);
					room.roomlease.Student.setName(temp[9]);
					room.roomlease.Student.setID(temp[10]);

					for(int i = 0; i < HallList.size();i++){
						if (HallList.get(i).getName().equals(room.getHallName())){
							HallList.get(i).RoomList.add(room);
							break;
						}
					}
				}
				counter++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}



