package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="Profit")
public class Profit {

	@Id
	private int hostelId;
	private Date daeFrom;
	private Date dateTo;
	private double profit;
	public Date getDaeFrom() {
		return daeFrom;
	}
	public void setDaeFrom(Date daeFrom) {
		this.daeFrom = daeFrom;
	}
	public int getHostelId() {
		return hostelId;
	}
	public void setHostelId(int hostelId) {
		this.hostelId = hostelId;
	}
	public Date getDateTo() {
		return dateTo;
	}
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	
}
