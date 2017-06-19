import java.util.Random;

import dao.BaseDao;
import daoImpl.BaseDaoImpl;
import model.Card;
import model.Hostel;
import model.Room;

public class GenerateData {

	public BaseDao baseDao = new BaseDaoImpl();
	public String[] area = {"南京","无锡","徐州","常州","苏州",
			"南通","连云港","淮安","盐城","扬州","镇江","泰州","宿迁"};
	public String[] roomType = {"单人房","双人房","三人房"};
    public void generateCard(){
		int id = 1000000;
		for (int i =1;i<=1000;i++){
			id++;
			Card card  = new Card();
			card.setId(Integer.toString(id));
			card.setPassWord(Integer.toString(i%4)+1);
			if (i%2==0){
				card.setGender(true);
			}
			else{
				card.setGender(false);
			}
			card.setArea(area[i%12]);
			baseDao.persist(card);
		}
	}
    
    
	public void generateHostel(){
		int id = 2000000;
		for (int i=1;i<=1000;i++){
			id++;
			Hostel hostel = new Hostel();
			hostel.setId(id);
			hostel.setPassWord(Integer.toString(id%4)+1);
			hostel.setArea(area[i%12]);
			baseDao.persist(hostel);
		}
	}
	
	
    public void generateRoom(){
    	int hostelId = 2000000;
		for (int i=1;i<=1000;i++){
			hostelId++;
			for (int j=1;j<=100;j++){
				Room room = new Room();
				room.setHostelID(Integer.toString(hostelId));
				room.setIsApproved(true);
				room.setRoomType(roomType[j%3]);
				room.setPrice(Math.random()*100+100);
				baseDao.persist(room);
			}
		}
	}
    
	public void generateAccommodation(){
		
	}
	
	


	
	public static void main(String[] arg){
		GenerateData ge = new GenerateData();
		ge.generateCard();
		ge.generateHostel();
		ge.generateRoom();
	}
}
