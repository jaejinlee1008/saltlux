package library.jdbc.controller;

import library.jdbc.VO.RentVO;
import library.jdbc.service.LibraryService;

public class UserRentInfoSearchController {

	
	public RentVO getResult(String ID) {
		LibraryService service = new LibraryService();
		RentVO rent = service.rentinfo(ID);
		return rent;
	}

}
