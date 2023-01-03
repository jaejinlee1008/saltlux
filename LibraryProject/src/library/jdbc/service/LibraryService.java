package library.jdbc.service;

import java.sql.Connection;
import java.sql.SQLException;

import javafx.collections.ObservableList;
import library.jdbc.VO.BookVO;
import library.jdbc.VO.LogVO;
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

	public ObservableList<RentVO> rentinfo(String ID) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LibraryDAO dao = new LibraryDAO(con);
		ObservableList<RentVO> list =  dao.selectRent(ID);
		
		return list;
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

	public void insertRentInfo(String bisbn,String btitle ,String ID, String c) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			LibraryDAO dao = new LibraryDAO(con);
			int count = dao.insert(bisbn,btitle,ID,c);
			if(count==1)
			{
				con.commit();
			}else
			{
				con.rollback();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public boolean getCanRent(String bisbn) {
		RentVO rent = null;
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LibraryDAO dao = new LibraryDAO(con);
		rent = dao.selectRentedBook(bisbn);
		if(rent==null)
		{
			return true;
		}else
		{
			return false;
		}
		
	}

	public boolean getCanReturn(String bisbn) {
		RentVO rent = null;
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LibraryDAO dao = new LibraryDAO(con);
		rent = dao.selectRentedBook(bisbn);
		if(rent==null)
		{
			return false;
		}else
		{
			return true;
		}
	}

	public void insertRentInfo(String btitle, String bisbn, String iD, String name, String rentORreturn, int point) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			LibraryDAO dao = new LibraryDAO(con);
			int count = dao.insertLog(btitle,bisbn,iD,name,rentORreturn,point);
			if(count==1)
			{
				con.commit();
			}else
			{
				con.rollback();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ObservableList<LogVO> getRentLogList(String ID) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LibraryDAO dao = new LibraryDAO(con);
		ObservableList<LogVO> list =  dao.selectLogAll(ID);
		
		return list;
	}

	public void setreturnlog(LogVO log) {
		
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			LibraryDAO dao = new LibraryDAO(con);
			
			int count = dao.insertreturnLog(log.getBtitle(),log.getBisbn(),log.getID(),log.getName(),"반납",50);
			
			if(count==1)
			{
				con.commit();
			}else
			{
				con.rollback();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public void deletelist(String bisbn, String id) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			LibraryDAO dao = new LibraryDAO(con);
			
			int count = dao.deletelist(bisbn,id);
			if(count==1)
			{
				con.commit();
			}else
			{
				con.rollback();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public boolean getCanSignUP(String name, String id, String pw, String pwcheck, String email) {
		UserVO user = null;
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LibraryDAO dao = new LibraryDAO(con);
		user = dao.selectUserid(id);
		
		
		if((name.length()<=5&&name.length()>=1) && (id.length()>=1 && id.length()<=15) && (pw.equals(pwcheck)) && (user==null) && (pw.length()>=1 && pw.length()<=20) && (pwcheck.length()>=1 && pwcheck.length()<=20) &&(email.length()>=1 && email.length()<=20))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void insertUser(String name, String id, String pw, String email) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			LibraryDAO dao = new LibraryDAO(con);
			int count = dao.insertUser(name,id,pw,email);
			if(count==1)
			{
				con.commit();
			}else
			{
				con.rollback();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ObservableList<RentVO> getNotReturnedList() {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LibraryDAO dao = new LibraryDAO(con);
		ObservableList<RentVO> list =  dao.selectAll();
		
		return list;
	}
}
