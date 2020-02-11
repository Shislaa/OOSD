package application;


public class Room {
	String cleaningStatus;
	String occupancyStatus;
	int rentrate;
	int area;
	String roomnumber;
	String HallName;
	String HallAddress;
	Lease roomlease = new Lease();
	public String getCleaningStatus() {
		return cleaningStatus;
	}
	public void setCleaningStatus(String cleaningStatus) {
		this.cleaningStatus = cleaningStatus;
	}
	public String getOccupancyStatus() {
		return occupancyStatus;
	}
	public void setOccupancyStatus(String occupancyStatus) {
		this.occupancyStatus = occupancyStatus;
	}
	public int getRentrate() {
		return rentrate;
	}
	public void setRentrate(int rentrate) {
		this.rentrate = rentrate;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public String getRoomnumber() {
		return roomnumber;
	}
	public void setRoomnumber(String roomnumber) {
		this.roomnumber = roomnumber;
	}
	public String getHallName() {
		return HallName;
	}
	public void setHallName(String hallName) {
		HallName = hallName;
	}
	public String getHallAddress() {
		return HallAddress;
	}
	public void setHallAddress(String hallAddress) {
		HallAddress = hallAddress;
	}
	public Lease getRoomlease() {
		return roomlease;
	}
	public void setRoomlease(Lease roomlease) {
		this.roomlease = roomlease;
	}


}

