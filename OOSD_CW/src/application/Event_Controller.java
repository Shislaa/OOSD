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
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Event_Controller {

	private 	ObservableList<Hall> HallList = FXCollections.observableArrayList();;
	private 	String[] HallTitle;
	private  	String[] RoomTitle;

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
	@FXML
	private MenuButton HallButton;
	@FXML
	private MenuItem Choice1;
	@FXML
	private MenuItem Choice2;
	@FXML
	private MenuItem Choice3;
	@FXML
	private TableColumn<ObserveList, String> StuID;
	@FXML
	private TableColumn<ObserveList, String> StuName;
	@FXML
	private TableColumn<ObserveList, String> LDur;
	@FXML
	private TableColumn<ObserveList, String> LNum;
	@FXML
	private TableColumn<ObserveList, Integer> RentRate;
	@FXML
	private TableColumn<ObserveList, Integer> Area;
	@FXML
	private TableColumn<ObserveList, String> CleaningStatus;
	@FXML
	private TableColumn<ObserveList, String> Occupancy;
	@FXML
	private TableColumn<ObserveList, String> RoomNum ;
	@FXML
	private TableColumn<ObserveList, String> hallAdd ;
	@FXML
	private TableColumn<ObserveList, String> hallName;
	@FXML
	private Label HallNum;
	@FXML
	private Label HallAdd;
	@FXML
	private Label NumRoom;
	@FXML
	private Label Telenum;
	@FXML
	private Label WarName;
	private static int counterHall = 0;


	// [[Login controller]]

	public void LoginEvent(ActionEvent event) throws CsvValidationException, IOException {
		if(Username.getText().equals("admin") && Password.getText().equals("admin")) {
			System.out.println("Login Success");
			// [[ Hide login window when login success]]
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			try {
				Pane root = loader.load(getClass().getResource("GeneralView.fxml").openStream());
				Scene scene = new Scene(root);
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

	public void HallData() throws NumberFormatException, CsvValidationException, IOException{
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
	public void RoomData() throws NumberFormatException, CsvValidationException, IOException{
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

	public void Columns(ObservableList<Room> RoomList){
		// Hall Name Column

		hallName.setCellValueFactory(new PropertyValueFactory<>("HallName"));

		//Hall Address Column

		hallAdd.setCellValueFactory(new PropertyValueFactory<>("HallAddress"));

		//Room num Column

		RoomNum.setCellValueFactory(new PropertyValueFactory<>("roomnumber"));

		//Occupancy Column

		Occupancy.setCellValueFactory(new PropertyValueFactory<>("occupancyStatus"));

		//CleaningStatus Column

		CleaningStatus.setCellValueFactory(new PropertyValueFactory<>("cleaningStatus"));

		//Area Column

		Area.setCellValueFactory(new PropertyValueFactory<>("area"));

		//RentRate Column

		RentRate.setCellValueFactory(new PropertyValueFactory<>("rentrate"));

		//LeaseNumber Column

		LNum.setCellValueFactory(new PropertyValueFactory<>("Lnum"));

		//Lease Duration Column

		LDur.setCellValueFactory(new PropertyValueFactory<>("Lduration"));

		//Student Name Column

		StuName.setCellValueFactory(new PropertyValueFactory<>("name"));

		//Student ID Column

		StuID.setCellValueFactory(new PropertyValueFactory<>("ID"));

		InfoTable.setItems(DisplayList(RoomList));
	}

// [[MAKING A LIST FOR THE TABLE]]
	public ObservableList<ObserveList> DisplayList(ObservableList<Room> RoomList){
		ObservableList<ObserveList> Temp = FXCollections.observableArrayList();
		for (int i = 0; i < RoomList.size(); i++){
			ObserveList newList = new ObserveList();
			newList.setHallName(RoomList.get(i).getHallName());
			newList.setHallAddress(RoomList.get(i).getHallAddress());
			newList.setRoomnumber(RoomList.get(i).getRoomnumber());
			newList.setOccupancyStatus(RoomList.get(i).getOccupancyStatus());
			newList.setCleaningStatus(RoomList.get(i).getCleaningStatus());
			newList.setArea(RoomList.get(i).getArea());
			newList.setRentrate(RoomList.get(i).getRentrate());
			newList.setLnum(RoomList.get(i).roomlease.getLnum());
			newList.setLduration(RoomList.get(i).roomlease.getLduration());
			newList.setName(RoomList.get(i).roomlease.Student.name);
			newList.setID(RoomList.get(i).roomlease.Student.ID);
			Temp.add(newList);
		}

		return Temp;
	}

	public void Button1Controller(ActionEvent event) throws NumberFormatException, CsvValidationException, IOException{
		if (counterHall == 0){
			HallData();
			RoomData();
		}
		counterHall++;
		System.out.println("Hall 1 selected");
		HallNum.setText("Hall Name: "+ HallList.get(0).getName());
		HallAdd.setText("Hall Address: "+ HallList.get(0).getAddress());
		NumRoom.setText("Number of Room: " + HallList.get(0).getNumroom());
		Telenum.setText("Telephone: " + HallList.get(0).getTelenum());
		WarName.setText("Warden: " + HallList.get(0).Warden.name);
	    Columns(HallList.get(0).RoomList);
	}

	public void Button2Controller(ActionEvent event) throws NumberFormatException, CsvValidationException, IOException{
		if (counterHall == 0){
			HallData();
			RoomData();
		}
		counterHall++;
		HallNum.setText("Hall Name: "+ HallList.get(1).getName());
		HallAdd.setText("Hall Address: "+ HallList.get(1).getAddress());
		NumRoom.setText("Number of Room: " + HallList.get(1).getNumroom());
		Telenum.setText("Telephone: " + HallList.get(1).getTelenum());
		WarName.setText("Warden: " + HallList.get(1).Warden.name);
		System.out.println("Hall 2 selected");
	    Columns(HallList.get(1).RoomList);
	}

	public void Button3Controller(ActionEvent event) throws NumberFormatException, CsvValidationException, IOException{
		if (counterHall == 0){
			HallData();
			RoomData();
		}
		counterHall++;
		HallNum.setText("Hall Name: "+ HallList.get(2).getName());
		HallAdd.setText("Hall Address: "+ HallList.get(2).getAddress());
		NumRoom.setText("Number of Room: " + HallList.get(2).getNumroom());
		Telenum.setText("Telephone: " + HallList.get(2).getTelenum());
		WarName.setText("Warden: " + HallList.get(2).Warden.name);
		System.out.println("Hall 3 selected");
	    Columns(HallList.get(2).RoomList);
	}
}
