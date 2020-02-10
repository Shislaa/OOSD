package application;

import java.util.ArrayList;

public class Hall {
	static String name;
	static String address;
	static int numroom;
	static int telenum;
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
	public static int getTelenum() {
		return telenum;
	}
	public static void setTelenum(int telenum) {
		Hall.telenum = telenum;
	}
	
}

