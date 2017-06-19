package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Card")
public class Card {

	@Id
	private String id;
	private String bankID;
	private String passWord;
	
    private boolean activateState;
    private int qualification;
    private double consumption;
    private int level;
    private double balance;
    private Date originalDate;
    private Date lastDate;
    private boolean gender;
    private String area;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean getActivateState() {
		return activateState;
	}
	public void setActivateState(boolean activateState) {
		this.activateState = activateState;
	}
	public int getQualification() {
		return qualification;
	}
	public void setQualification(int qualification) {
		this.qualification = qualification;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getOriginalDate() {
		return originalDate;
	}
	public void setOriginalDate(Date originalDate) {
		this.originalDate = originalDate;
	}
	public Date getLastDate() {
		return lastDate;
	}
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
	public String getBankID() {
		return bankID;
	}
	public void setBankID(String bankID) {
		this.bankID = bankID;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public double getConsumption() {
		return consumption;
	}
	public void setConsumption(double consumption) {
		this.consumption = consumption;
	}
	public boolean isMale() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
    


}
