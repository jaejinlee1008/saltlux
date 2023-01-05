package library.jdbc.controller;

import library.jdbc.service.LibraryService;

public class UserDeleteController {

	public void setResult(String oldID) {
		LibraryService service = new LibraryService();
		service.deleteuser(oldID);
		
	}

}
