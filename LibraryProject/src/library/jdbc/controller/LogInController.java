package library.jdbc.controller;

import library.jdbc.service.LibraryService;

public class LogInController {
	public boolean getResult(String id, String pw)
	{
		LibraryService service = new LibraryService();
		boolean b = service.userInfoCheck(id, pw);
		return b;
	}
}
