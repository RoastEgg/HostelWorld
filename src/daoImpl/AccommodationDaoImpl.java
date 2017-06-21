package daoImpl;

import java.util.ArrayList;
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

	@Override
	public ArrayList<Double> getSumOfMoney() {
		ArrayList<Double> answer = new ArrayList<Double>();
		double sum =0.0;
		
		for (int i=1;i<=6;i++){
			String s = "2017-0"+i+"%";
			String hql = "from model.Accommodation as ac where ac.date like '"+ s+ "'";
			System.out.println("hql:"+hql);
			List<Accommodation> results = baseDao.findByHql(hql);
	        sum = 0.0;
			for (Accommodation ac:results){
	        	sum+=ac.getMoney();
	        }
	        answer.add(sum);

		}
	    return answer;
	}

	@Override
	public ArrayList<Double> getAverageOfMoney() {
		ArrayList<Double> answer = new ArrayList<Double>();
		double average =0.0;
		
		for (int i=1;i<=6;i++){
			String s = "2017-0"+i+"%";
			String hql = "from model.Accommodation as ac where ac.date like '"+ s+"'";
			List<Accommodation> results = baseDao.findByHql(hql);
			average = 0.0;
			for (Accommodation ac:results){
				average+=ac.getMoney();
	        }
	        answer.add(average/results.size());

		}
	    return answer;
	}

}
