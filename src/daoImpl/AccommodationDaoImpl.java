package daoImpl;

import java.util.List;



import dao.AccommodationDao;
import dao.BaseDao;
import model.Accommodation;

public class AccommodationDaoImpl implements AccommodationDao{

	BaseDao baseDao=new BaseDaoImpl();
	
	private static  AccommodationDaoImpl accommodationDao 
	= new AccommodationDaoImpl();
	
	public AccommodationDaoImpl(){
		
	}
	
	public static AccommodationDaoImpl getInstance(){
		return accommodationDao;
	}
	
	@Override
	public void save(Accommodation accommodation) {
		baseDao.persist(accommodation);
		System.out.println("save accommodation info,ok");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Accommodation> getForMember(String cardID) {
	   
	    String hql = "from model.Accommodation as ac where ac.cardID like "+cardID;
		List<Accommodation> results = baseDao.findByHql(hql);
	    
		return results;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Accommodation> getForHostel(String HostelID) {
		 
	    String hql = "from model.Accommodation as ac where ac.hostelID like "+HostelID;
		List<Accommodation> results = baseDao.findByHql(hql);

		return results;
	}

	@Override
	public List<Accommodation> getForCEO() {
	   
	    List<Accommodation> results = baseDao.findAll("Accommodation");

		return results;
	}

	@Override
	public void delete(int roomID) {
		

		String hql = "from model.Accommodation as ac where ac.roomID like "+roomID;
	    List<Accommodation> results = baseDao.findByHql(hql);

	    for (Accommodation a : results){
	    	baseDao.delete(a);
	    }
	    
		System.out.println("delete accommodation,ok");
	}

}
