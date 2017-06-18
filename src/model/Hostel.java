package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Hostel")
public class Hostel {

	@Id
	private int id;
	private String apply;
	private String passWord;
	private boolean isAccepted;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getApply() {
		return apply;
	}
	public void setApply(String apply) {
		this.apply = apply;
	}
	public boolean isAccepted() {
		return isAccepted;
	}
	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
}
