package dao;

import java.util.ArrayList;
import java.util.List;

import model.Accommodation;

public interface AccommodationDao {

	public void save(Accommodation accommodation);
	public void delete(int roomID);
	
	public List<Accommodation> getForMember(String cardID);
	public List<Accommodation> getForHostel(String HostelID);
	public List<Accommodation> getForCEO();
	public ArrayList<Double> getSumOfMoney();
	public ArrayList<Double> getAverageOfMoney();
	
}
