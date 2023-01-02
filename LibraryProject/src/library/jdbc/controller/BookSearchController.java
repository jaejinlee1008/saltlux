package library.jdbc.controller;

import javafx.collections.ObservableList;
import library.jdbc.VO.BookVO;
import library.jdbc.service.LibraryService;


public class BookSearchController {

	public ObservableList<BookVO> getResult(String input) {
		
		LibraryService service = new LibraryService();
		ObservableList<BookVO> list =  service.getSelectedBykeyword(input);
		
		return list;
	}

}
