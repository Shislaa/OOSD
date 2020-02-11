package application;

public class Lease {
	static String Lnum;
	static String Lduration;
	static String roomnumber;
	static String Halladdress;
	Human Student = new Human();
	public static String getLduration() {
		return Lduration;
	}
	public static void setLduration(String lduration) {
		Lduration = lduration;
	}
	public static String getRoomnumber() {
		return roomnumber;
	}
	public static void setRoomnumber(String roomnumber) {
		Lease.roomnumber = roomnumber;
	}
	public static String getHalladdress() {
		return Halladdress;
	}
	public static void setHalladdress(String halladdress) {
		Halladdress = halladdress;
	}
	public Human getStudent() {
		return Student;
	}
	public static String getLnum() {
		return Lnum;
	}
	public static void setLnum(String lnum) {
		Lnum = lnum;
	}

}

