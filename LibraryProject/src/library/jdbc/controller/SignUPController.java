package library.jdbc.controller;

import library.jdbc.service.LibraryService;

public class SignUPController {

	public void setResult(String name, String id, String pw, String email) {
		LibraryService service = new LibraryService();
		service.insertUser(name,id,pw,email);
	}

}
