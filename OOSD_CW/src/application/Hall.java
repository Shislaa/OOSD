package application;

import java.util.ArrayList;

public class Hall {
	String name;
	String address;
	int numroom;
	String telenum;
	ArrayList<Room> RoomList = new ArrayList<>();
	Human Warden = new Human();

	public Hall(){

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNumroom() {
		return numroom;
	}

	public void setNumroom(int numroom) {
		this.numroom = numroom;
	}

	public String getTelenum() {
		return telenum;
	}

	public void setTelenum(String telenum) {
		this.telenum = telenum;
	}

	public ArrayList<Room> getRoomList() {
		return RoomList;
	}
	public void setRoomList(ArrayList<Room> roomList) {
		RoomList = roomList;
	}
	public Human getWarden() {
		return Warden;
	}
	public void setWarden(Human warden) {
		Warden = warden;
	}

}

