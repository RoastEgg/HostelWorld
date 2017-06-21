package daoImpl;

import java.util.ArrayList;
import java.util.List;


import dao.BaseDao;
import dao.HostelDao;
import model.Card;
import model.Hostel;
public class HostelDaoImpl implements HostelDao{

	public String[] area={"南京","无锡","徐州","常州","苏州",
			"南通","连云港","淮安","盐城","扬州","镇江","泰州","宿迁"};
	
	
	BaseDao baseDao=new BaseDaoImpl();
	
	private static HostelDaoImpl hostelDao = new HostelDaoImpl();
	
	public HostelDaoImpl() {

	}

	public static HostelDaoImpl getInstance() {
		return hostelDao;
	}
	
	
	@Override
	public void saveHostel(Hostel hostel) {
	 	baseDao.persist(hostel);

		System.out.println("hostel info:"+hostel.getId()+hostel.getApply());
		
		System.out.println("saveHostel ok");
		
	}
	
	@Override
	public boolean check(String hostelID, String passWord) {
		
		String hql = "from model.Hostel as hostel where hostel.id like "+hostelID+" and hostel.passWord like "+passWord;
		List<Hostel> results = baseDao.findByHql(hql);	    
		
		if (results.size()>0){
		    Hostel result = results.get(0);
		    if (result!=null&&result.isAccepted()){
		    	System.out.println("用户名密码正确");
				return true;
			}
			else {
		    	System.out.println("用户名密码错误");
				return false;
			}
        }else {
	    	System.out.println("用户名密码错误");
            return false;
        }
		
		
	}

	@Override
	public List<Hostel> getForCEO() {
		
		List<Hostel> results = baseDao.findAll("Hostel");
	    List<Hostel> answer = new ArrayList<Hostel>();
	    for (Hostel ho:results){
	    	if (!ho.isAccepted()){
	    		answer.add(ho);
	    	}
	    }
		
		return answer;
	}

	@Override
	public void approve() {
		
		
		List<Hostel> results = baseDao.findAll("Hostel");

		for (Hostel ho:results){
			ho.setAccepted(true);
			baseDao.update(ho);
	    }
		
		System.out.println("开店申请 已审批");
		
	}

	@Override
	public ArrayList<Integer> areaOfHostel() {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		for (int i=0;i<13;i++){
			String hql = "from model.Hostel as hostel where hostel.area like '"+area[i]+"'";
			List<Card> results = baseDao.findByHql(hql);
//			System.out.println("size:"+results.size());
		    answer.add(results.size());
//		    System.out.println("size:"+results.size());
		}  
		return answer;
	}
}