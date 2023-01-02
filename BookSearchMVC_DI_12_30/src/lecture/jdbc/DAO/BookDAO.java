package lecture.jdbc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lecture.jdbc.vo.BookExtraVO;
import lecture.jdbc.vo.BookVO;

public class BookDAO {
	
	Connection con = null;
	
	public BookDAO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public BookDAO(Connection con) {
		super();
		this.con = con;
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

	public int delete(String deleteISBN) {
		
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

	public ObservableList<BookExtraVO> selectSupplementary(String deleteISBN) {
		
		
		ObservableList<BookExtraVO> list = null;
		String sql = "SELECT bdate,bpage,btranslator,bsupplement,bpublisher FROM book WHERE bisbn = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, deleteISBN);
			ResultSet rs = pstmt.executeQuery();
			list = FXCollections.observableArrayList();
			while(rs.next())
			{
				list.add(new BookExtraVO(rs.getString("bdate"),rs.getInt("bpage"),rs.getString("btranslator"),rs.getString("bsupplement"),rs.getString("bpublisher")));
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
