package dao;


import java.util.ArrayList;
import java.util.List;

import model.Hostel;

public interface HostelDao {

	public void saveHostel(Hostel hostel);
//	public void savePlan(String HostelId,
//			Date date,String roomType,double price,
//			boolean isAccepted);
	public boolean check(String hostelID,String passWord);
	//public void savePlan(HostelPlan hostelPlan);
	public List<Hostel> getForCEO();
	public void approve();
	public ArrayList<Integer> areaOfHostel();

}
