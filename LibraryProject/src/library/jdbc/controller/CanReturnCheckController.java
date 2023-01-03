package library.jdbc.controller;

import library.jdbc.service.LibraryService;

public class CanReturnCheckController {

	public boolean getResult(String bisbn) {
		LibraryService service = new LibraryService();
		
		return service.getCanReturn(bisbn);
		
	}

}
