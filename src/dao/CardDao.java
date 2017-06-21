package dao;

import java.util.ArrayList;

import model.Card;

public interface CardDao {

	public Card find(String cardID);
	public void save(Card card);
	public boolean check(String cardID,String passWord);
	public void recharge(String cardID,double number);
	public void delete(String cardID);
	public void update(Card card);
	public ArrayList<Integer> areaOfCard();
	public ArrayList<Integer> genderOfCard();
	
//	public void activate(double money);
//	public void qualificationPause();
//	public void qualificationRecovry();
//	public void qualificationStop();
//	public void setLevel(String id);
	
	
}
