package main.svc;

import static main.db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import main.dao.*;
import vo.*;	

public class MainSvc {
	public ArrayList<ProductInfo> getProductList() {
	// 검색된 상품 목록을 ArrayList<ProductInfo>에 담아 리턴하는 메소드
		ArrayList<ProductInfo> productList = new ArrayList<ProductInfo>();
		Connection conn = getConnection();					
		MainDao mainDao = MainDao.getInstance();		
		mainDao.setConnection(conn);					
		productList = mainDao.getProductList();
		close(conn);
		
		return productList;
	}
	
	public ArrayList<ChallengeInfo> getChallengeList() {
	// 검색된 도전펀딩 목록을 ArrayList<ChallengeInfo>에 담아 리턴하는 메소드
		ArrayList<ChallengeInfo> challengeList = new ArrayList<ChallengeInfo>();
		Connection conn = getConnection();					
		MainDao mainDao = MainDao.getInstance();		
		mainDao.setConnection(conn);					
		challengeList = mainDao.getChallengeList();
		close(conn);
		
		return challengeList;
	}
	
	public ArrayList<FundingInfo> getFundingList() {
	// 검색된 상품 목록을 ArrayList<FundingInfo>에 담아 리턴하는 메소드
		ArrayList<FundingInfo> fundingList = new ArrayList<FundingInfo>();
		Connection conn = getConnection();					
		MainDao mainDao = MainDao.getInstance();		
		mainDao.setConnection(conn);					
		fundingList = mainDao.getFundingList();
		close(conn);
		
		return fundingList;
	}
	
}
