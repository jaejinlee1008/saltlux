package lecture.jdbc.service;

import java.sql.Connection;
import java.sql.SQLException;

import javafx.collections.ObservableList;
import lecture.jdbc.DAO.BookDAO;
import lecture.jdbc.DAO.DBCPConnectionPool;
import lecture.jdbc.vo.BookExtraVO;
import lecture.jdbc.vo.BookVO;

public class BookService {

	public ObservableList<BookVO> getSelectedBykeyword(String input) {
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookDAO dao = new BookDAO(con);
		ObservableList<BookVO> list =  dao.select(input);
		
		return list;
	}

	public ObservableList<BookVO> getDeletedByISBN(String deleteISBN, String input) {
		// Transaction 시작
		// Connection에 대해서 setAutoCommit()을 false로 지정해야 Transaction이 시작
		// 여기에서 database connection을 얻어와야한다.
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		BookDAO dao = new BookDAO(con);
		int count = dao.delete(deleteISBN);
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

	public ObservableList<BookExtraVO> getSupplementaryDataByISBN(String deleteISBN) {
		
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookDAO dao = new BookDAO(con);
		ObservableList<BookExtraVO> list = dao.selectSupplementary(deleteISBN);
		return list;
	}

}
