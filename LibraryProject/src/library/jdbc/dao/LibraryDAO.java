package library.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import library.jdbc.VO.BookVO;
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
			user = new UserVO(rs.getString("name"),rs.getString("ID"),rs.getString("PW"),rs.getString("email"),(rs.getString("isRent_YN")).charAt(0),rs.getInt("point"));
			
			rs.close();
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return user;
	}


	public RentVO selectRent(String ID) {
		
		RentVO rent = null;
		String sql = "SELECT * FROM rent WHERE ID = ?";
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ID);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			rent = new RentVO(rs.getString("bisbn"),rs.getString("ID"),rs.getDate("date"),(rs.getString("isreturn_YN")).charAt(0));
			
			rs.close();
			pstmt.close();
			return rent;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		
		return null;
	}


	public UserVO selectUser(String ID) {
		
		UserVO user = null;
		String sql = "SELECT * FROM users WHERE ID = ?";
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ID);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			user = new UserVO(rs.getString("name"),rs.getString("ID"),rs.getString("PW"),rs.getString("email"),(rs.getString("isRent_YN")).charAt(0),rs.getInt("point"));
			
			rs.close();
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
			e1.printStackTrace();
		}
		
		return list;
	}
	
}
