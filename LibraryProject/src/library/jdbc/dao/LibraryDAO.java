package library.jdbc.dao;

import java.sql.Connection;
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
		String sql = "SELECT * FROM users WHERE ID = ? AND PW = ? ";
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			user = new UserVO(rs.getString("name"),rs.getString("ID"),rs.getString("PW"),rs.getString("email"),rs.getInt("point"));
			
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
			user = new UserVO(rs.getString("name"),rs.getString("ID"),rs.getString("PW"),rs.getString("email"),rs.getInt("point"));
			
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


	public int insertLog(String btitle, String bisbn, String iD, String name, String rentORreturn, int point) {
		int count=0;
		String sql = "INSERT INTO log (btitle,bisbn,ID,name,date,rentORreturn,point) VALUES(?,?,?,?,?,?,?)";
		try {
		
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, btitle);
			pstmt.setString(2, bisbn);
			pstmt.setString(3, iD);
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
				log.add(new LogVO(rs.getString("btitle"),rs.getString("bisbn"),rs.getString("ID"),rs.getString("name"),rs.getDate("date"),rs.getString("rentORreturn"),rs.getInt("point")));
			}
			
			rs.close();
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		
		return log;
	}


	public int insertreturnLog(String btitle, String bisbn, String ID, String name,String rentORreturn, int i) {
		
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
			pstmt.setInt(7, i);
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
		String sql = "SELECT * FROM users WHERE ID = ?";
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			
			user = new UserVO(rs.getString("name"),rs.getString("ID"),rs.getString("PW"),rs.getString("email"),rs.getInt("point"));
			
			
			rs.close();
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		
		return user;
	}


	public int insertUser(String name, String id, String pw, String email) {
		int count=0;
		String sql = "INSERT INTO users (name,ID,PW,email,point) VALUES(?,?,?,?,?)";
		try {
		
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			pstmt.setString(4, email);
			pstmt.setInt(5, 0);
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
	
}
