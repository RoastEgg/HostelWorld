import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import dao.AccommodationDao;
import dao.BaseDao;
import dao.CardDao;
import daoImpl.BaseDaoImpl;
import daoImpl.CardDaoImpl;
import model.Accommodation;
import model.Card;
import model.Hostel;
import model.Room;

public class GenerateData {

	public BaseDao baseDao = new BaseDaoImpl();
	public String[] area={"南京","无锡","徐州","常州","苏州",
			"南通","连云港","淮安","盐城","扬州","镇江","泰州","宿迁"};
	public int areaIndex =13;
	
//	public String[] area = {"NanJing","WuXi","XuZhou","ChangZhou","SuZhou",
//			"NanTong","LianYunGang","HuaiAn","YanCheng","YanghZhou",
//			"ZhenJiang","TaiZhou","SuQian"};
	public String[] roomType = {"one","two","three"};
	
	
    public void generateCard(){
		int id = 1000000;
		for (int i =1;i<=1000;i++){
			id++;
			Card card  = new Card();
			card.setId(Integer.toString(id));
			card.setPassWord(Integer.toString(i%4+1));
			if ((int)((Math.random()*10))%2==0){
				card.setGender(true);
			}
			else{
				card.setGender(false);
			}
			card.setArea(area[(int)((Math.random()*areaIndex))]);
			card.setAge((int)(Math.random()*100));
			baseDao.persist(card);
		}
	}
    
    
	public void generateHostel(){
		int id = 2000000;
		for (int i=1;i<=100;i++){
			id++;
			Hostel hostel = new Hostel();
			hostel.setId(id);
			hostel.setPassWord(Integer.toString(id%4+1));
			hostel.setArea(area[(int)((Math.random()*areaIndex))]);
			hostel.setAccepted(true);
			baseDao.persist(hostel);
		}
	}
	
	
    public void generateRoom(){
    	int hostelId = 2000000;
		for (int i=1;i<=100;i++){
			hostelId++;
			for (int j=1;j<=100;j++){
				Room room = new Room();
				room.setHostelID(Integer.toString(hostelId));
				room.setIsApproved(true);
				room.setRoomType(roomType[j%3]);
				room.setPrice((int)(Math.random()*100+100));
				room.setIsApproved(true);
				baseDao.persist(room);
			}
		}
	}
    
	public void generateAccommodation() throws ParseException{
		int cardID   = 1000000;
		int hostelId = 2000000;
		int roomId = 0;
		for (int i=1;i<100;i++){
			hostelId++;
			for (int j=1;j<100;j++){
				
				String beginDate = "2017-01-01";
				String endDate   = "2017-06-30";
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  

				Date start = format.parse(beginDate);//构造开始日期  

				Date end = format.parse(endDate);//构造结束日期  
				
				long answer = start.getTime() + 
						(long) (Math.random() * (end.getTime() - start.getTime()));
				
				
				roomId = (i-1)*100+j;
				
				
				Accommodation ac = new Accommodation();
				ac.setCardID(Integer.toString(
						cardID+(int)(Math.random()*1000)
						));
				ac.setHostelID(Integer.toString(hostelId));
				ac.setRoomID(roomId);
				ac.setMoney((int)(Math.random()*100+100));
				ac.setDate(format.format( new Date (answer) ));
				baseDao.persist(ac);
			}
		}
		
		
	}
	
	


	
	public static void main(String[] arg) throws ParseException{
	    
			GenerateData ge = new GenerateData();
	//	ge.generateCard();
	//	ge.generateHostel();
	//	ge.generateRoom();
		ge.generateAccommodation();
//		CardDao card = new CardDaoImpl();
//	    card.areaOfCard();
	}
}
