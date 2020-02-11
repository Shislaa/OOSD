package application;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Event_Controller {

	static private 	ObservableList<Hall> HallList = FXCollections.observableArrayList();
	static private 	String[] HallTitle;
	static private  String[] RoomTitle;

	@FXML
	private TextField Username;
	@FXML
	private TextField Password;
	@FXML
	private Button Login;
	@FXML
	private Label Statuslbl;
	@FXML
	private ImageView UWELogo;
	@FXML
	private TableView InfoTable;

	// [[Login controller]]

	public void LoginEvent(ActionEvent event) throws CsvValidationException, IOException {
		if(Username.getText().equals("admin") && Password.getText().equals("admin")) {
			HallData();
			RoomData();
			System.out.println("Login Success");
			// [[ Hide login window when login success]]
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			try {
				Pane root = loader.load(getClass().getResource("GeneralView.fxml").openStream());
				Scene scene = new Scene(root);

				// Hall Name Column
				TableColumn<Room, String> hallName = new TableColumn<>(HallTitle[0]);
				hallName.setMinWidth(200);
				hallName.setCellValueFactory(new PropertyValueFactory<>("HallName"));


				primaryStage.setTitle("UWE Accomodation System");
				primaryStage.setScene(scene);
				primaryStage.show();


			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		else {
			System.out.println("Login Failed");
			Statuslbl.setText("Wrong username or password");
		}
	}
	public void LogoutEvent(ActionEvent event) {
		((Node)event.getSource()).getScene().getWindow().hide();
	}

	public static void HallData() throws NumberFormatException, CsvValidationException, IOException{
		try {

			CSVReader reader = new CSVReader(new FileReader("Hall.csv"));
			int counter = 0;
			while(reader.peek() != null){
				if (counter == 0){
					HallTitle = reader.readNext();
				}
				else {
					String[] temp = reader.readNext();
					Hall hall = new Hall();
					HallList.add(hall);
					hall.setName(temp[0]);
					hall.setAddress(temp[1]);
					hall.setNumroom(Integer.valueOf(temp[2]));
					hall.setTelenum(temp[3]);
					hall.Warden.setID(temp[4]);
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
					room.setHallName(temp[0]);
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
