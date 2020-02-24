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
import javafx.scene.Parent;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Event_Controller {

	private static 	ObservableList<Hall> HallList = FXCollections.observableArrayList();;
	private 	String[] HallTitle;
	private  	String[] RoomTitle;
	private 	ObserveList DisplayList;

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
	@FXML
	private TextField LNumb;
	@FXML
	private TextField SName;
	@FXML
	private TextField SID;
	@FXML
	private MenuButton OStatus;
	@FXML
	private MenuButton CStatus;
	@FXML
	private TextField LDurr;
	@FXML
	private Button EditBttn;
	@FXML
	private Button EditAllButton;
	@FXML
	private MenuItem Oced;
	@FXML
	private MenuItem Unoced;
	@FXML
	private MenuItem Clean;
	@FXML
	private MenuItem Dirty;
	@FXML
	private MenuItem Offline;

	private static int counterHall = 0;
	static boolean IsManager = false;
	static boolean IsWarden = false;
	static int EditAllCounter = 0;


	// [[Login controller]]

	public void LoginEvent(ActionEvent event) throws CsvValidationException, IOException {
		if(Username.getText().equals("admin") && Password.getText().equals("admin")) {
			IsManager = true;
		}
		else if(Username.getText().equals("I_am_Warden") && Password.getText().equals("Yeah_i_is")) {
			IsWarden = true;
		}
		else{
			System.out.println("Login Failed");
			Statuslbl.setText("Wrong username or password");
		}
		if (IsManager || IsWarden){
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
	}
	public void LogoutEvent(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		((Node)event.getSource()).getScene().getWindow().hide();
		Parent pane = FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene scene = new Scene(pane);
		primaryStage.setTitle("UWE Accomodation System");
		primaryStage.setScene(scene);
		primaryStage.show();
		if(IsManager) {
			IsManager = false;
		}
		else {
			IsWarden = false;
		}
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
					if(room.getOccupancyStatus().equals("Occupied")){
						room.setIsOccied(true);
					}
					else{
						room.IsOccied = false;;
					}
					room.setCleaningStatus(temp[4]);
					if(room.getCleaningStatus().equals("Clean")){
						room.setIsClean(true);
						room.setIsDirty(false);
						room.setIsOffline(false);
					}
					else if(room.getCleaningStatus().equals("Dirty")){
						room.setIsDirty(true);
						room.setIsClean(false);
						room.setIsOffline(false);
					}
					else if(room.getCleaningStatus().equals("Offline")){
						room.setIsClean(false);
						room.setIsDirty(false);
						room.setIsOffline(true);
					}
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
	    HallButton.setText(Choice1.getText());
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
	    HallButton.setText(Choice2.getText());
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
	    HallButton.setText(Choice3.getText());
	}

	public void displayShiet(MouseEvent event){
		ObserveList newList = (ObserveList) InfoTable.getSelectionModel().getSelectedItem();
		DisplayList = newList;
		LNumb.setText(newList.getLnum());
		LDurr.setText(newList.getLduration());
		SName.setText(newList.getName());
		SID.setText(newList.getID());
		OStatus.setText(newList.getOccupancyStatus());
		CStatus.setText(newList.getCleaningStatus());
		if(IsManager == true){
			CStatus.setDisable(true);
		}
		else if(IsWarden){
			LNumb.setDisable(true);
			SName.setDisable(true);
			SID.setDisable(true);
			OStatus.setDisable(true);
			LDurr.setDisable(true);
		}

	}

	public void CSController(ActionEvent event){
		Clean.setOnAction(a->{
			CStatus.setText(Clean.getText());
		});
		Dirty.setOnAction(a->{
			CStatus.setText(Dirty.getText());
		});
		Offline.setOnAction(a->{
			CStatus.setText(Offline.getText());
		});
	}

	public void OSController(ActionEvent event){
		Oced.setOnAction(a->{
			OStatus.setText(Oced.getText());
		});
		Unoced.setOnAction(a->{
			OStatus.setText(Unoced.getText());
		});
	}
	public void EditInfo(ActionEvent event) throws NumberFormatException, CsvValidationException, IOException{
		String HalName = DisplayList.getHallName();
		String RoomNumber = DisplayList.getRoomnumber();
		int Hn = 0;
		int Rn = 0;
		for (int i =0; i < HallList.size();i++){
			if(HalName.equals(HallList.get(i).getName())){
				for (int j = 0; j < HallList.get(i).RoomList.size(); j++){
					if(RoomNumber.equals(HallList.get(i).RoomList.get(j).roomnumber)){
						Hn = i;
						Rn = j;
						break;
					}
				}
			}
			break;
		}
		HallList.get(Hn).RoomList.get(Rn).roomlease.setLnum(LNumb.getText());
		HallList.get(Hn).RoomList.get(Rn).roomlease.setLduration(LDurr.getText());;
		HallList.get(Hn).RoomList.get(Rn).roomlease.Student.setName(SName.getText());;
		HallList.get(Hn).RoomList.get(Rn).roomlease.Student.setID(SID.getText());;
		HallList.get(Hn).RoomList.get(Rn).setOccupancyStatus(OStatus.getText());;
		String OStemp = HallList.get(Hn).RoomList.get(Rn).getOccupancyStatus();
		if(OStemp.equals("Occupied")){
			HallList.get(Hn).RoomList.get(Rn).setIsOccied(true);
		}
		else{
			HallList.get(Hn).RoomList.get(Rn).IsOccied = false;;
		}

		HallList.get(Hn).RoomList.get(Rn).setCleaningStatus(CStatus.getText());;
		String CStemp = HallList.get(Hn).RoomList.get(Rn).getCleaningStatus();
		if(CStemp.equals("Clean")){
			HallList.get(Hn).RoomList.get(Rn).setIsClean(true);
			HallList.get(Hn).RoomList.get(Rn).setIsDirty(false);
			HallList.get(Hn).RoomList.get(Rn).setIsOffline(false);
		}
		else if(CStemp.equals("Dirty")){
			HallList.get(Hn).RoomList.get(Rn).setIsDirty(true);
			HallList.get(Hn).RoomList.get(Rn).setIsClean(false);
			HallList.get(Hn).RoomList.get(Rn).setIsOffline(false);
		}
		else if(CStemp.equals("Offline")){
			HallList.get(Hn).RoomList.get(Rn).setIsClean(false);
			HallList.get(Hn).RoomList.get(Rn).setIsDirty(false);
			HallList.get(Hn).RoomList.get(Rn).setIsOffline(true);
		}
		if(HallList.get(Hn).getName().equals("UWEH1")){
			Columns(HallList.get(0).RoomList);
		}
		if(HallList.get(Hn).getName().equals("UWEH2")){
			Columns(HallList.get(1).RoomList);
		}
		if(HallList.get(Hn).getName().equals("UWEH3")){
			Columns(HallList.get(2).RoomList);
		}

	}

	public void ViewAllController(ActionEvent event){
		EditAllCounter++;
		if(EditAllCounter % 2 == 1){
			LNumb.setDisable(false);
			SName.setDisable(false);
			SID.setDisable(false);
			OStatus.setDisable(false);
			LDurr.setDisable(false);
			CStatus.setDisable(false);
		}
		else{
			if(IsManager == true){
				LNumb.setDisable(false);
				SName.setDisable(false);
				SID.setDisable(false);
				OStatus.setDisable(false);
				LDurr.setDisable(false);
				CStatus.setDisable(true);
			}
			else if(IsWarden){
				LNumb.setDisable(true);
				SName.setDisable(true);
				SID.setDisable(true);
				OStatus.setDisable(true);
				LDurr.setDisable(true);
				CStatus.setDisable(false);
			}
		}
	}


}
