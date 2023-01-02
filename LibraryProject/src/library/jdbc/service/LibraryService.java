package library.jdbc.service;

import java.sql.Connection;
import java.sql.SQLException;

import javafx.collections.ObservableList;
import library.jdbc.VO.BookVO;
import library.jdbc.VO.RentVO;
import library.jdbc.VO.UserVO;
import library.jdbc.dao.DBCPConnectionPool;
import library.jdbc.dao.LibraryDAO;


public class LibraryService {
	
	public boolean userInfoCheck(String id, String pw) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LibraryDAO dao = new LibraryDAO(con);
		UserVO user =  dao.selectOne(id, pw);
		
		if(user.getID().equals(id) && user.getPW().equals(pw))
		{
			return true;
		}else
		{
			return false;
		}
	}

	public RentVO rentinfo(String ID) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LibraryDAO dao = new LibraryDAO(con);
		RentVO rent =  dao.selectRent(ID);
		
		return rent;
	}

	public UserVO userinfo(String ID) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LibraryDAO dao = new LibraryDAO(con);
		UserVO user =  dao.selectUser(ID);
		
		return user;
	}
	
	public ObservableList<BookVO> getSelectedBykeyword(String input) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LibraryDAO dao = new LibraryDAO(con);
		ObservableList<BookVO> list =  dao.select(input);
		
		return list;
	}
}
