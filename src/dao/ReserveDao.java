package dao;

import java.util.List;

import model.Reserve;

public interface ReserveDao {

	public void saveReserve(Reserve reserve);
	public Reserve find(int roomID);
	public void delete(int roomID);
	public List<Reserve> getForMember(String cardID);
	public List<Reserve> getForHostel(String HostelID);
	public List<Reserve> getForCEO();
	
}
