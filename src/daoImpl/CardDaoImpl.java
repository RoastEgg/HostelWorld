package daoImpl;

import java.util.List;



import dao.BaseDao;
import dao.CardDao;
import model.Card;

public class CardDaoImpl implements CardDao{

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

}
