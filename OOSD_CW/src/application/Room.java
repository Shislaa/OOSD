package application;


public class Room {
	static String clean;
	static String dirty;
	static boolean occupied;
	static String offline;
	static int rentrate;
	static int area;
	static String roomnumber;
	Lease roomlease = new Lease();
	public static String getClean() {
		return clean;
	}
	public static void setClean(String clean) {
		Room.clean = clean;
	}
	public static String getDirty() {
		return dirty;
	}
	public static void setDirty(String dirty) {
		Room.dirty = dirty;
	}
	public static boolean isOccupied() {
		return occupied;
	}
	public static void setOccupied(boolean occupied) {
		Room.occupied = occupied;
	}
	public static String getOffline() {
		return offline;
	}
	public static void setOffline(String offline) {
		Room.offline = offline;
	}
	public static int getRentrate() {
		return rentrate;
	}
	public static void setRentrate(int rentrate) {
		Room.rentrate = rentrate;
	}
	public static int getArea() {
		return area;
	}
	public static void setArea(int area) {
		Room.area = area;
	}
	public static String getRoomnumber() {
		return roomnumber;
	}
	public static void setRoomnumber(String roomnumber) {
		Room.roomnumber = roomnumber;
	}
	public static boolean checkavailability() {
		return true;
	}
	
}

