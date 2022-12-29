package lecture.jdbc.controller;

import javafx.collections.ObservableList;
import lecture.jdbc.service.BookService;
import lecture.jdbc.vo.BookExtraVO;

public class BookSearchOtherDataController {

	public ObservableList<BookExtraVO> getResult(String deleteISBN) {
		BookService service = new BookService();
		ObservableList<BookExtraVO> list = service.getSupplementaryDataByISBN(deleteISBN);
		return list;
	}

}
