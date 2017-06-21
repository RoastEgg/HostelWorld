<%@ page import="net.sf.json.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.CardDao" %>
<%@ page import="daoImpl.CardDaoImpl" %>

<%@ page import="java.text.DecimalFormat"%>
<%
    
    
    CardDao cardDao = new CardDaoImpl();

    ArrayList<Integer> areaDistribution = cardDao.areaOfCard();

	JSONArray arr = new JSONArray();
	for (int i = 0; i < areaDistribution.size(); i++) {
		arr.add(areaDistribution.get(i));
	}

	System.out.println("JSON:"+arr);
	out.print(arr);
%>

