package lecture.jdbc.controller;

import javafx.collections.ObservableList;
import lecture.jdbc.service.BookService;
import lecture.jdbc.vo.BookVO;

public class BookDeleteController {

	public ObservableList<BookVO> getDeletedResult(String deleteISBN, String input) {
		BookService service = new BookService();
		ObservableList<BookVO> list = service.getDeletedByKeyword(deleteISBN,input);
		return list;
	}

}
