package lecture.jdbc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lecture.jdbc.vo.BookExtraVO;
import lecture.jdbc.vo.BookVO;

public class BookDAO {
	
	private static BasicDataSource basicDS;
	
	static
	{
		basicDS = new BasicDataSource();
		basicDS.setDriverClassName("com.mysql.cj.jdbc.Driver");
		basicDS.setUrl("jdbc:mysql://127.0.0.1:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
		basicDS.setUsername("root");
		basicDS.setPassword("test1234");
		basicDS.setInitialSize(10);
		basicDS.setMaxTotal(20);
	}
	
	public static DataSource getDataSource()
	{
		return basicDS;
	}
	
	public ObservableList<BookVO> select(String input) {
		
		DataSource ds = getDataSource();
		Connection con = null;
		ObservableList<BookVO> list = null;
		String sql = "SELECT bisbn,btitle, bauthor,bprice FROM book WHERE btitle like ? ORDER BY bprice DESC";
		try {
			con = ds.getConnection();
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
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return list;
	}

	public int delete(String deleteISBN) {
		DataSource ds = getDataSource();
		
		Connection con = null;
		try {
			con = ds.getConnection();
			String deletesql = "DELETE FROM BOOK WHERE bisbn = ?";
			
			con.setAutoCommit(false);
			PreparedStatement deletepstmt = con.prepareStatement(deletesql);
			deletepstmt.setString(1, deleteISBN);
			int count = deletepstmt.executeUpdate();
			
			if(count==1)
			{
				con.commit();
				
			}else
			{
				con.rollback();
			}
			deletepstmt.close();
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return 0;
	}

	public ObservableList<BookExtraVO> selectSupplementary(String deleteISBN) {
		
		DataSource ds = getDataSource();
		Connection con = null;
		ObservableList<BookExtraVO> list = null;
		String sql = "SELECT bdate,bpage,btranslator,bsupplement,bpublisher FROM book WHERE bisbn = ?";
		try {
			con = ds.getConnection();
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
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return list;
	}

}
