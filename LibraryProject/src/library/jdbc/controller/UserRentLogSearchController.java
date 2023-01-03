package library.jdbc.controller;

import javafx.collections.ObservableList;
import library.jdbc.VO.LogVO;
import library.jdbc.service.LibraryService;

public class UserRentLogSearchController {

	public ObservableList<LogVO> getResult(String ID) {
		LibraryService service = new LibraryService();
		ObservableList<LogVO> list = service.getRentLogList(ID);
		return list;
	}
	
}
