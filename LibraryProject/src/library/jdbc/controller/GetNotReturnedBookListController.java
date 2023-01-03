package library.jdbc.controller;

import javafx.collections.ObservableList;
import library.jdbc.VO.RentVO;
import library.jdbc.service.LibraryService;

public class GetNotReturnedBookListController {

	public ObservableList<RentVO> getResult() {
		LibraryService service = new LibraryService();
		ObservableList<RentVO> list = service.getNotReturnedList();
		return list;
	}

}
