package daoImpl;

import java.util.ArrayList;
import java.util.List;


import dao.BaseDao;
import dao.RoomDao;
import model.Room;

public class RoomDaoImpl implements RoomDao{

	BaseDao baseDao=new BaseDaoImpl();
	
	private static  RoomDaoImpl roomDao = new RoomDaoImpl();
	
	public RoomDaoImpl(){
		
	}
	
	public static RoomDaoImpl getInstance(){
		return roomDao;
	}
	

	@Override
	public void save(Room room) {

		baseDao.persist(room);	
	}
	
	@Override
	public boolean canIn(int roomID) {
		
		Room result = (Room) baseDao.findById(roomID, Room.class);		   
	    if (result.isState()){
	    	return true;
	    }
	    else {
	    	return false;
	    }
	}
	
	public void updateState(int roomID){
		
	    Room  room= find(roomID);
	    
	    if (room.isState()){
	    	room.setState(false);
	    }
	    else {
	    	room.setState(true);
	    }
	    baseDao.update(room);
	    

		
	}

	@Override
	public Room find(int roomID) {
		
		Room result = (Room) baseDao.findById(roomID, Room.class);
		
		return result;
	}
	
	@Override
	public List<Room> getForCEO(){
		
		List<Room> results = baseDao.findAll("Room");
		
	    List<Room> answer = new ArrayList<Room>();
	    
	    for (Room ro:results){
	    	if (!ro.isIsApproved()){
	    		answer.add(ro);
	    	}
	    }
	    
		
		return answer;
	}

	@Override
	public void approve() {
		
		
		List<Room> results = baseDao.findAll("Room");
	     
	    for (Room ro:results){
	    	if (!ro.isIsApproved()){
	    		ro.setIsApproved(true);
	    		baseDao.update(ro);
	    	}
	    }
	    
		System.out.println("房间计划 已审批");
	}

	

}
