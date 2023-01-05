package library.jdbc.controller;

import javafx.collections.ObservableList;
import library.jdbc.VO.BookVO;
import library.jdbc.service.LibraryService;

public class BookDeleteController {
	public ObservableList<BookVO> getDeletedResult(String deleteISBN, String input) {
		LibraryService service = new LibraryService();
		ObservableList<BookVO> list = service.getDeletedByISBN(deleteISBN,input);
		return list;
	}
}
