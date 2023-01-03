package library.jdbc.controller;

import library.jdbc.service.LibraryService;

public class CanRentCheckController {

	public boolean getResult(String bisbn) {
		LibraryService service = new LibraryService();
		
		return service.getCanRent(bisbn);
	}

}
