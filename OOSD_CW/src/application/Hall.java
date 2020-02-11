package application;

import java.util.ArrayList;

public class Hall {
	static String name;
	static String address;
	static int numroom;
	static String telenum;
	ArrayList<Room> RoomList = new ArrayList<>();
	Human Warden = new Human();
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		Hall.name = name;
	}
	public static String getAddress() {
		return address;
	}
	public static void setAddress(String address) {
		Hall.address = address;
	}
	public static int getNumroom() {
		return numroom;
	}
	public static void setNumroom(int numroom) {
		Hall.numroom = numroom;
	}
	public static String getTelenum() {
		return telenum;
	}
	public static void setTelenum(String telenum) {
		Hall.telenum = telenum;
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

