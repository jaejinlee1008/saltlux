package library.jdbc.service;

import java.sql.Connection;
import java.sql.Date;
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
		
		if(user !=null && user.getID().equals(id) && user.getPW().equals(pw))
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

	public ObservableList<LogVO> insertRentInfo(String btitle, String bisbn, String iD, String name, String rentORreturn, int point) {
		Connection con = null;
		Date date=java.sql.Date.valueOf(java.time.LocalDate.now());
		Date duedate = java.sql.Date.valueOf(java.time.LocalDate.now().plusDays(7));
		ObservableList<LogVO> loglist=null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			LibraryDAO dao = new LibraryDAO(con);
			int count = dao.insertLog(btitle,bisbn,iD,name,date,rentORreturn,point,duedate);
			loglist = dao.selectLogAll(iD);
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
		return loglist;
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
		int point=0;
		Date date = java.sql.Date.valueOf(java.time.LocalDate.now());
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			LibraryDAO dao = new LibraryDAO(con);
			if(date.compareTo(log.getDuedate())>0)
			{
				long diffSec=(date.getTime()-log.getDuedate().getTime())/1000;
				long diffDays = diffSec/(24*60*60);
				int delayday = Long.valueOf(diffDays).intValue();
				point = -(10*delayday);
			}else
			{
				
				point = 50;
			}
			int count = dao.insertreturnLog(log.getBtitle(),log.getBisbn(),log.getID(),log.getName(),"반납",point);
			UserVO user = userinfo(log.getID());
			int num = dao.updateUserPoint(user.getID(),(user.getPoint()+point));
			if(count==1&&num==1)
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
		
		
		if((name.length()<=20&&name.length()>=1) && (id.length()>=1 && id.length()<=15) && (pw.equals(pwcheck)) && (user==null) && (pw.length()>=1 && pw.length()<=20) && (pwcheck.length()>=1 && pwcheck.length()<=20) &&(email.length()>=1 && email.length()<=20))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void insertUser(String name, String id, String pw, String email) {
		Date indate=java.sql.Date.valueOf(java.time.LocalDate.now());
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			LibraryDAO dao = new LibraryDAO(con);
			int count = dao.insertUser(name,id,pw,email,indate);
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

	public boolean updateUserInfo(String oldID, String email) {
		UserVO user = null;
		Connection con = null;
		int count = 0;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LibraryDAO dao = new LibraryDAO(con);
		user = dao.selectUserEmail(email);
		
		
		if((user==null) &&(email.length()>=1 && email.length()<=20))
		{
			count = dao.updateUserInfo(oldID,email);
			if(count==1)
			{
				try {
					con.commit();
					return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}else
			{
				try {
					con.rollback();
					return false;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
			
		}
		else
		{
			return false;
		}
		return false;
	}

	public boolean updatePW(String id, String pw, String pwcheck) {
		UserVO user = null;
		Connection con = null;
		int count = 0;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LibraryDAO dao = new LibraryDAO(con);
		
		
		if((pw.equals(pwcheck))&&(pw.length()>=1 && pw.length()<=20))
		{
			count = dao.updateUserpw(id,pw);
			if(count==1)
			{
				try {
					con.commit();
					return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}else
			{
				try {
					con.rollback();
					return false;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
			
		}
		else
		{
			return false;
		}
		return false;
	}

	public void deleteuser(String oldID) {
		Date outdate=java.sql.Date.valueOf(java.time.LocalDate.now());
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			LibraryDAO dao = new LibraryDAO(con);
			//UserVO user = dao.selectUser(oldID);
			int count =  dao.deleteUser(oldID,outdate);
			if(count==1)
			{
				/*
				 * count = dao.alterAI(user.getNum()); if(count==1) { con.commit(); }else {
				 * con.rollback(); }
				 */
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

	public ObservableList<UserVO> getUserList() {
		ObservableList<UserVO> list=null;
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
			LibraryDAO dao = new LibraryDAO(con);
			list =  dao.selectUserAll();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public ObservableList<BookVO> getDeletedByISBN(String deleteISBN, String input) {
		
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		LibraryDAO dao = new LibraryDAO(con);
		int count = dao.deleteBook(deleteISBN);
		ObservableList<BookVO> list = dao.select(input);
		// Transaction 끝
		// Service의 method 마지막에 이 메소드가 잘 처리되었으면
		// Transaction을 commit하고 아니면 rollback 해야 한다
		if(count==1 && list !=null)
		{
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else
		{
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public boolean updateBook(String selectedbisbn, String newbtitle, String newbauthor, String newbprice) {

		Connection con = null;
		int count = 0;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LibraryDAO dao = new LibraryDAO(con);
		int price = Integer.parseInt(newbprice);
		if((newbtitle.length()>=1 && newbtitle.length()<=200) && (newbauthor.length()>=1&&newbauthor.length()<=100))
		{
			count = dao.updateBook(selectedbisbn,newbtitle,newbauthor,price);
			if(count==1)
			{
				try {
					con.commit();
					return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}else
			{
				try {
					con.rollback();
					return false;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
			
		}
		else
		{
			return false;
		}
		return false;
	}

	public boolean BookInsert(String newbisbn, String newbtitle, String newbauthor, String newbprice) {
		Connection con = null;
		int count = 0;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LibraryDAO dao = new LibraryDAO(con);
		BookVO book = dao.selectBook(newbisbn);
		int price = Integer.parseInt(newbprice);
		if((book==null) &&(newbisbn.length()>=1 && newbisbn.length()<=50) && (newbtitle.length()>=1 && newbtitle.length()<=200) && (newbauthor.length()>=1&&newbauthor.length()<=100))
		{
			count = dao.insertBook(newbisbn,newbtitle,newbauthor,price);
			if(count==1)
			{
				try {
					con.commit();
					return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}else
			{
				try {
					con.rollback();
					return false;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
			
		}
		else
		{
			return false;
		}
		return false;
	}

	public boolean getCanUseId(String id) {
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
		
		
		if((id.length()>=1 && id.length()<=15)  && (user==null) )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
