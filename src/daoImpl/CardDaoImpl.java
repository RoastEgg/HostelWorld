package daoImpl;

import java.util.ArrayList;
import java.util.List;



import dao.BaseDao;
import dao.CardDao;
import model.Card;

public class CardDaoImpl implements CardDao{

	
	public String[] area={"南京","无锡","徐州","常州","苏州",
			"南通","连云港","淮安","盐城","扬州","镇江","泰州","宿迁"};
		
	BaseDao baseDao=new BaseDaoImpl();
	
	
	private static  CardDaoImpl cardDao = new CardDaoImpl();
	
	public CardDaoImpl(){
		
	}
	
	public static CardDaoImpl getInstance(){
		return cardDao;
	}
	
	@Override
	public void delete(String cardID) {
		

		String hql = "from model.Card as card where card.id like "+cardID;
	    List<Card> result = baseDao.findByHql(hql);

	    for (Card c:result){
	    	baseDao.delete(c);
	    }
	    System.out.println("delete card,ok");
	}
	
	@Override
	public Card find(String cardID) {
		

		String hql = "from model.Card as card where card.id like "+cardID;
	    List<Card> results = baseDao.findByHql(hql);
	    
	    if (results.size()>0){
		    System.out.println("find card,ok");
            return results.get(0);
        }else {
            return null;
        }
		

	}
	
	
	@Override
	public void save(Card card) {
		
		baseDao.persist(card);
		System.out.println("save card,ok");
	}

	@Override
	public boolean check(String cardID, String passWord) {
		
		String hql = "from model.Card as card where card.id like "+cardID+" and card.passWord like "+passWord;
	    List results = baseDao.findByHql(hql);
	    
	    if (results.isEmpty()){
	    	return false;
	    }
	    else {
	    	return true;
	    }
	}

	@Override
	public void recharge(String cardID, double number) {
		
		String hql = "from model.Card as card where card.id like "+cardID;
	    List<Card> results = baseDao.findByHql(hql);
	    
	    if (results.size()>0){
		    Card result = results.get(0);
		    if ( (!result.getActivateState()) && (number>=1000) ){
		    	result.setActivateState(true);
		    }
	     	result.setBalance(result.getBalance()+number);
	     	baseDao.update(result);

			System.out.println("recharge"+cardID+" ,ok");
			
        }else {
        	System.out.println("没有这个会员账号");
        }
	    
	    
	}

	@Override
	public void update(Card card) {
		baseDao.update(card);
		System.out.println("update card,ok");
	}

	@Override
	public ArrayList<Integer> areaOfCard() {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		for (int i=0;i<13;i++){
			String hql = "from model.Card as card where card.area like '"+area[i]+"'";
			List<Card> results = baseDao.findByHql(hql);
		    answer.add(results.size());
//		    System.out.println("size:"+results.size());
		}  
		return answer;
	}

	@Override
	public ArrayList<Integer> genderOfCard() {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		String hql = "from model.Card as card where card.gender like "+"1";
		List<Card> results = baseDao.findByHql(hql);
		answer.add(results.size());
		
		hql = "from model.Card as card where card.gender like "+"0";
		results = baseDao.findByHql(hql);
		answer.add(results.size());

//		    System.out.println("size:"+results.size());
		  
		return answer;
	}

}
