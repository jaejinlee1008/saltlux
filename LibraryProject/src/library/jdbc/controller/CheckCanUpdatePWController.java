package library.jdbc.controller;

import library.jdbc.service.LibraryService;

public class CheckCanUpdatePWController {

	public boolean getResult(String id,String pw, String pwcheck) {
		LibraryService service = new LibraryService();
		
		return service.updatePW(id, pw, pwcheck);
	}

}
