package library.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import library.jdbc.VO.BookVO;
import library.jdbc.VO.LogVO;
import library.jdbc.VO.RentVO;
import library.jdbc.VO.UserVO;

public class LibraryDAO {
	
	Connection con = null;
	
	public LibraryDAO(Connection con) {
		this.con = con;
	}
	
	
	public UserVO selectOne(String id, String pw) {
		
		UserVO user = null;
		String sql = "SELECT * FROM users WHERE ID = ? AND PW = ? AND isout = 'N' ";
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			user = new UserVO(rs.getInt("num"),rs.getString("name"),rs.getString("ID"),rs.getString("PW"),rs.getString("email"),rs.getDate("indate"),rs.getInt("point"),rs.getString("isout"),rs.getDate("outdate"));
			rs.close();
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		
		return user;
	}


	public ObservableList<RentVO> selectRent(String ID) {
		
		ObservableList<RentVO> list = null;
		String sql = "SELECT * FROM rent WHERE ID = ?";
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ID);
			
			ResultSet rs = pstmt.executeQuery();
			list = FXCollections.observableArrayList();
			while(rs.next())
			{
				list.add(new RentVO(rs.getString("bisbn"),rs.getString("btitle"),rs.getString("ID"),rs.getDate("date"),rs.getString("isreturn_YN")));
			}
			
			rs.close();
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		
		return list;
	}


	public UserVO selectUser(String ID) {
		
		UserVO user = null;
		String sql = "SELECT * FROM users WHERE ID = ?";
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ID);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			user = new UserVO(rs.getInt("num"),rs.getString("name"),rs.getString("ID"),rs.getString("PW"),rs.getString("email"),rs.getDate("indate"),rs.getInt("point"),rs.getString("isout"),rs.getDate("outdate"));
			
			rs.close();
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		
		return user;
	}
	
	public ObservableList<BookVO> select(String input) {
		
		ObservableList<BookVO> list = null;
		String sql = "SELECT bisbn,btitle, bauthor,bprice FROM book WHERE btitle like ? ORDER BY bprice DESC";
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + input+ "%");
			ResultSet rs = pstmt.executeQuery();
			list = FXCollections.observableArrayList();
			while(rs.next())
			{
				list.add(new BookVO(rs.getString("bisbn"),rs.getString("btitle"),rs.getString("bauthor"),rs.getInt("bprice")));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		
		return list;
	}


	public int insert(String bisbn,String btitle ,String ID, String c) {
		int count=0;
		String sql = "INSERT INTO rent VALUES(?,?,?,?,?)";
		try {
		
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bisbn);
			pstmt.setString(2, btitle);
			pstmt.setString(3, ID);
			pstmt.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
			pstmt.setString(5, c);
			count = pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		return count;
	}


	public RentVO selectRentedBook(String bisbn) {
		RentVO rent = null;
		String sql = "SELECT * FROM rent WHERE bisbn = ? AND isreturn_YN = 'N' ";
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bisbn);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			rent = new RentVO(rs.getString("bisbn"),rs.getString("btitle"),rs.getString("ID"),rs.getDate("date"),rs.getString("isreturn_YN"));
			
			rs.close();
			pstmt.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		
		return rent;
	}


	public int insertLog(String btitle, String bisbn, String iD, String name, Date date ,String rentORreturn, int point, Date duedate) {
		int count=0;
		String sql = "INSERT INTO log (btitle,bisbn,ID,name,date,rentORreturn,point,duedate) VALUES(?,?,?,?,?,?,?,?)";
		try {
		
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, btitle);
			pstmt.setString(2, bisbn);
			pstmt.setString(3, iD);
			pstmt.setString(4, name);
			pstmt.setDate(5, date);
			pstmt.setString(6, rentORreturn);
			pstmt.setInt(7, point);
			pstmt.setDate(8, duedate);
			count = pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		return count;
	}


	public ObservableList<LogVO> selectLogAll(String ID) {
		ObservableList<LogVO> log = null;
		String sql = "SELECT * FROM log WHERE ID = ?";
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ID);
			
			ResultSet rs = pstmt.executeQuery();
			log = FXCollections.observableArrayList();
			while(rs.next())
			{
				log.add(new LogVO(rs.getString("btitle"),rs.getString("bisbn"),rs.getString("ID"),rs.getString("name"),rs.getDate("date"),rs.getString("rentORreturn"),rs.getInt("point"),rs.getDate("duedate")));
			}
			
			rs.close();
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		
		return log;
	}


	public int insertreturnLog(String btitle, String bisbn, String ID, String name,String rentORreturn, int point) {
		
		int count=0;
		String sql = "INSERT INTO log (btitle,bisbn,ID,name,date,rentORreturn,point) VALUES(?,?,?,?,?,?,?)";
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, btitle);
			pstmt.setString(2, bisbn);
			pstmt.setString(3, ID);
			pstmt.setString(4, name);
			pstmt.setDate(5, java.sql.Date.valueOf(java.time.LocalDate.now()));
			pstmt.setString(6, rentORreturn);
			pstmt.setInt(7, point);
			count = pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		return count;
	}


	public int deletelist(String bisbn, String id) {
		int count=0;
		String sql = "DELETE FROM rent WHERE bisbn = ? AND ID = ? ";
		try {
		
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bisbn);
			pstmt.setString(2, id);
			count = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		return count;
		
	}


	public UserVO selectUserid(String id) {
		UserVO user = null;
		String sql = "SELECT * FROM users WHERE ID = ? AND isout = 'N' ";
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			
			
			user = new UserVO(rs.getInt("num"),rs.getString("name"),rs.getString("ID"),rs.getString("PW"),rs.getString("email"),rs.getDate("indate"),rs.getInt("point"),rs.getString("isout"),rs.getDate("outdate"));
			
			rs.close();
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		
		return user;
	}


	public int insertUser(String name, String id, String pw, String email, Date indate) {
		int count=0;
		String sql = "INSERT INTO users (name,ID,PW,email,point,indate) VALUES(?,?,?,?,?,?)";
		try {
		
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			pstmt.setString(4, email);
			pstmt.setInt(5, 0);
			pstmt.setDate(6, indate);
			count = pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		return count;
	}


	public ObservableList<RentVO> selectAll() {
		ObservableList<RentVO> list = null;
		String sql = "SELECT * FROM rent";
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			list = FXCollections.observableArrayList();
			while(rs.next())
			{
				list.add(new RentVO(rs.getString("bisbn"),rs.getString("btitle"),rs.getString("ID"),rs.getDate("date"),rs.getString("isreturn_YN")));
			}
			
			rs.close();
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		
		return list;
	}


	public UserVO selectUserEmail(String email) {
		UserVO user = null;
		String sql = "SELECT * FROM users WHERE email = ? AND isout = 'N' ";
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			
			user = new UserVO(rs.getInt("num"),rs.getString("name"),rs.getString("ID"),rs.getString("PW"),rs.getString("email"),rs.getDate("indate"),rs.getInt("point"),rs.getString("isout"),rs.getDate("outdate"));
			
			rs.close();
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		
		return user;
	}


	public int updateUserInfo(String oldID, String email) {
		int count=0;
		String sql = "UPDATE users SET email = ? WHERE ID = ?";
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, oldID);
			count = pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		
		return count;
	}


	public int updateUserpw(String id, String pw) {
		int count=0;
		String sql = "UPDATE users SET PW = ? WHERE ID = ?";
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, id);
			count = pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		
		return count;
	}


	public int deleteUser(String oldID, Date outdate) {
		int count=0;
		String sql = "UPDATE users SET isout = 'Y', outdate = ? WHERE ID = ? ";
		try {
		
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, outdate);
			pstmt.setString(2, oldID);
			count = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		return count;
	}


	public int updateUserPoint(String id, int point) {
		int count=0;
		String sql = "UPDATE users SET point = ? WHERE ID = ?";
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, point);
			pstmt.setString(2, id);
			count = pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		
		return count;
	}


	public ObservableList<UserVO> selectUserAll() {
		ObservableList<UserVO> list = null;
		String sql = "SELECT * FROM users";
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			
			ResultSet rs = pstmt.executeQuery();
			list = FXCollections.observableArrayList();
			while(rs.next())
			{
				list.add(new UserVO(rs.getInt("num"),rs.getString("name"),rs.getString("ID"),rs.getString("PW"),rs.getString("email"),rs.getDate("indate"),rs.getInt("point"),rs.getString("isout"),rs.getDate("outdate")));
			}
			
			rs.close();
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		
		return list;
	}


	public int deleteBook(String deleteISBN) {
		String deletesql = "DELETE FROM BOOK WHERE bisbn = ?";
		int count = 0;
		try {
			
			PreparedStatement deletepstmt = con.prepareStatement(deletesql);
			deletepstmt.setString(1, deleteISBN);
			count = deletepstmt.executeUpdate();
			
			deletepstmt.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return count;
	}


	public int updateBook(String selectedbisbn, String newbtitle, String newbauthor, int price) {
		String deletesql = "UPDATE book SET btitle = ?, bauthor = ?, bprice = ? WHERE bisbn = ? ";
		int count = 0;
		try {
			
			PreparedStatement deletepstmt = con.prepareStatement(deletesql);
			deletepstmt.setString(1, newbtitle);
			deletepstmt.setString(2, newbauthor);
			deletepstmt.setInt(3, price);
			deletepstmt.setString(4, selectedbisbn);
			count = deletepstmt.executeUpdate();
			
			deletepstmt.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return count;
	}


	public BookVO selectBook(String newbisbn) {
		BookVO book = null;
		String sql = "SELECT * FROM book WHERE bisbn = ? ";
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newbisbn);
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			
			book = new BookVO(rs.getString("bisbn"),rs.getString("btitle"),rs.getString("bauthor"),rs.getInt("bprice"));
			
			rs.close();
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		
		return book;
	}


	public int insertBook(String newbisbn, String newbtitle, String newbauthor, int price) {
		String sql = "INSERT INTO book (bisbn,btitle,bauthor,bprice) VALUES (?,?,?,?)";
		int count = 0;
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newbisbn);
			pstmt.setString(2, newbtitle);
			pstmt.setString(3, newbauthor);
			pstmt.setInt(4, price);
			
			count = pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return count;
	}


	/*
	 * public int alterAI(int num) { String sql =
	 * "ALTER TABLE users auto_increment = ? "; int count = 0; try {
	 * 
	 * PreparedStatement pstmt = con.prepareStatement(sql); pstmt.setInt(1, num);
	 * count = pstmt.executeUpdate();
	 * 
	 * pstmt.close();
	 * 
	 * } catch (SQLException e1) { // TODO Auto-generated catch block
	 * e1.printStackTrace(); } return count; }
	 */


	
}
