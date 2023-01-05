package library.jdbc.controller;

import library.jdbc.service.LibraryService;

public class CheckCanUpdateBookController {
	public boolean getResult(String Selectedbisbn, String newbtitle, String newbauthor, String newbprice) {
		LibraryService service = new LibraryService();
		
		return service.updateBook(Selectedbisbn,newbtitle,newbauthor,newbprice);
	}
}
