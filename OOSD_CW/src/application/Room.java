package application;


public class Room {
	// [[ INITIALIZE VARIABLE ]]
	String cleaningStatus;
	String occupancyStatus;
	boolean IsClean;
	boolean IsDirty;
	boolean IsOffline;
	boolean IsOccied;
	int rentrate;
	int area;
	String roomnumber;
	String HallName;
	String HallAddress;
	Lease roomlease = new Lease();
	// GETTERS AND SETTERS

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
	public boolean isIsClean() {
		return IsClean;
	}
	public void setIsClean(boolean isClean) {
		IsClean = isClean;
	}
	public boolean isIsDirty() {
		return IsDirty;
	}
	public void setIsDirty(boolean isDirty) {
		IsDirty = isDirty;
	}
	public boolean isIsOffline() {
		return IsOffline;
	}
	public void setIsOffline(boolean isOffline) {
		IsOffline = isOffline;
	}
	public boolean IsOccied() {
		return IsOccied;
	}
	public void setIsOccied(boolean occied) {
		IsOccied = occied;
	}


}

