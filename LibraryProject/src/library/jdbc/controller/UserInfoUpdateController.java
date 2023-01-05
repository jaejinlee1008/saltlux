package library.jdbc.controller;

import library.jdbc.service.LibraryService;

public class UserInfoUpdateController {

	public boolean setResult(String oldID, String text) {
		LibraryService service = new LibraryService();
		return service.updateUserInfo(oldID,text);
		
	}

}
