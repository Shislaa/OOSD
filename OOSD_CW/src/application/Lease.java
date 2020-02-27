package application;

public class Lease {
	// [[ INITIALIZE VARIABLE ]]

	String Lnum;
	String Lduration;
	String roomnumber;
	String Halladdress;
	Human Student = new Human();
	// GETTERS AND SETTERS

	public String getLnum() {
		return Lnum;
	}

	public void setLnum(String lnum) {
		Lnum = lnum;
	}

	public String getLduration() {
		return Lduration;
	}

	public void setLduration(String lduration) {
		Lduration = lduration;
	}

	public String getRoomnumber() {
		return roomnumber;
	}

	public void setRoomnumber(String roomnumber) {
		this.roomnumber = roomnumber;
	}

	public String getHalladdress() {
		return Halladdress;
	}

	public void setHalladdress(String halladdress) {
		Halladdress = halladdress;
	}

	public void setStudent(Human student) {
		Student = student;
	}

	public Human getStudent() {
		return Student;
	}
}

