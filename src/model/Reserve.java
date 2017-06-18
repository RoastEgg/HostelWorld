package model;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="Reserve")
public class Reserve {

	@Id
	private int id;
	private String cardID;
	private String hostelID;
	private int roomID;
	
	private Date nowDate;
	private Date stayDate;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCardID() {
		return cardID;
	}
	public void setCardID(String cardID) {
		this.cardID = cardID;
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
	public Date getNowDate() {
		return nowDate;
	}
	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}
	public Date getStayDate() {
		return stayDate;
	}
	public void setStayDate(Date stayDate) {
		this.stayDate = stayDate;
	}

	
}
