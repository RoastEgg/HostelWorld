package daoImpl;

import java.util.List;



import dao.BaseDao;
import dao.ReserveDao;
import model.Reserve;

public class ReserveDaoImpl implements ReserveDao{

	BaseDao baseDao=new BaseDaoImpl();
	
	private static ReserveDaoImpl reserveDao = new ReserveDaoImpl();
	
	public ReserveDaoImpl() {

	}

	public static ReserveDaoImpl getInstance() {
		return reserveDao;
	}
	
	
	@Override
	public void saveReserve(Reserve reserve) {
		
		baseDao.persist(reserve);

		System.out.println(
				"reserve info:"+reserve.getHostelID()+reserve.getRoomID());
		
		System.out.println("saveReserve ok");
		
	}

	@Override
	public Reserve find(int roomID) {
		
	    String hql = "from model.Reserve as reserve where reserve.roomID like "+roomID;
		List<Reserve> results = baseDao.findByHql(hql);
	    
		 if (results.size()>0){
			    System.out.println("find reserve,ok");
	            return results.get(0);
	        }else {
	            return null;
	        }
		 
	}
	
	public void delete(int roomID){
		
		String hql = "from model.Reserve as reserve where reserve.roomID like "+roomID;
	    List<Reserve> results = baseDao.findByHql(hql);
	    
	    for (Reserve r : results){
	    	baseDao.delete(r);
	    }
		
		System.out.println("delete reserve,ok");
	}

	@Override
	public List<Reserve> getForMember(String cardID) {
		
		
	    String hql = "from model.Reserve as reserve where reserve.cardID like "+cardID;
		List<Reserve> results = baseDao.findByHql(hql);
	    
		return results;
	}

	@Override
	public List<Reserve> getForHostel(String hostelID) {
		
		
	    String hql = "from model.Reserve as reserve where reserve.hostelID like "+hostelID;
		List<Reserve> results = baseDao.findByHql(hql);
		
		return results;
	}

	@Override
	public List<Reserve> getForCEO() {
		
		List<Reserve> results = baseDao.findAll("Reserve");
		return results;
	}

}
