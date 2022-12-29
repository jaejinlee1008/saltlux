package lecture.jdbc.service;

import javafx.collections.ObservableList;
import lecture.jdbc.DAO.BookDAO;
import lecture.jdbc.vo.BookExtraVO;
import lecture.jdbc.vo.BookVO;

public class BookService {

	public ObservableList<BookVO> getSelectedBykeyword(String input) {
		
		BookDAO dao = new BookDAO();
		ObservableList<BookVO> list =  dao.select(input);
		
		return list;
	}

	public ObservableList<BookVO> getDeletedByISBN(String deleteISBN, String input) {
		BookDAO dao = new BookDAO();
		int count = dao.delete(deleteISBN);
		ObservableList<BookVO> list = dao.select(input);
		return list;
	}

	public ObservableList<BookExtraVO> getSupplementaryDataByISBN(String deleteISBN) {
		BookDAO dao = new BookDAO();
		ObservableList<BookExtraVO> list = dao.selectSupplementary(deleteISBN);
		return list;
	}

}
