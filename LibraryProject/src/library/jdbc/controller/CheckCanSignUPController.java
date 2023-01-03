package library.jdbc.controller;

import library.jdbc.service.LibraryService;

public class CheckCanSignUPController {

	public boolean getResult(String name, String id, String pw, String pwcheck, String email) {

		LibraryService service = new LibraryService();
		return service.getCanSignUP(name, id, pw, pwcheck, email);
	}

}
