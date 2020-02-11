package application;


public class Room {
	static String cleaningStatus;
	static String occupancyStatus;
	static int rentrate;
	static int area;
	static String roomnumber;
	static String HallName;
	static String HallAddress;
	Lease roomlease = new Lease();
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
	public static String getHallName() {
		return HallName;
	}
	public static void setHallName(String hallName) {
		HallName = hallName;
	}
	public static String getHallAddress() {
		return HallAddress;
	}
	public static void setHallAddress(String hallAddress) {
		HallAddress = hallAddress;
	}
	public static String getOccupancyStatus() {
		return occupancyStatus;
	}
	public static void setOccupancyStatus(String occupancyStatus) {
		Room.occupancyStatus = occupancyStatus;
	}
	public static String getCleaningStatus() {
		return cleaningStatus;
	}
	public static void setCleaningStatus(String cleaningStatus) {
		Room.cleaningStatus = cleaningStatus;
	}

}

