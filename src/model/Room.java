package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Room")
public class Room {

	@Id
	private int id;
	private String hostelID;
	private String roomType;
	private double price;
	private boolean state;
	private boolean IsApproved;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public String getHostelID() {
		return hostelID;
	}
	public void setHostelID(String hostelID) {
		this.hostelID = hostelID;
	}
	public boolean isIsApproved() {
		return IsApproved;
	}
	public void setIsApproved(boolean isApproved) {
		IsApproved = isApproved;
	}
	
}
