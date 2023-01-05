package library.jdbc.controller;

import library.jdbc.service.LibraryService;

public class CheckCanInsertBookController {

	public boolean getResult(String newbisbn, String newbtitle, String newbauthor, String newbprice) {
		LibraryService service = new LibraryService();
		
		return service.BookInsert(newbisbn,newbtitle,newbauthor,newbprice);
	}

}
