package library.jdbc.controller;

import javafx.collections.ObservableList;
import library.jdbc.VO.RentVO;
import library.jdbc.service.LibraryService;

public class UserRentInfoSearchController {

	
	public ObservableList<RentVO> getResult(String ID) {
		LibraryService service = new LibraryService();
		ObservableList<RentVO> rent = service.rentinfo(ID);
		return rent;
	}

}
