package model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="Accommodation")
public class Accommodation {

	@Id
	private int id;
	private String hostelID;
	private int roomID;
	private String personName;
	private boolean IsMember;
	private String cardID;
	private int payType;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getHostelID() {
		return hostelID;
	}
	public void setHostelID(String hostelID) {
		this.hostelID = hostelID;
	}
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public boolean isIsMember() {
		return IsMember;
	}
	public void setIsMember(boolean isMember) {
		IsMember = isMember;
	}
	public String getCardID() {
		return cardID;
	}
	public void setCardID(String cardID) {
		this.cardID = cardID;
	}
	public int getPayType() {
		return payType;
	}
	public void setPayType(int payType) {
		this.payType = payType;
	}
	
}
