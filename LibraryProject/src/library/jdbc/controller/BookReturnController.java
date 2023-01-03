package library.jdbc.controller;

import library.jdbc.VO.LogVO;
import library.jdbc.service.LibraryService;

public class BookReturnController {

	public void setResultlog(LogVO log) {
		LibraryService service = new LibraryService();
		service.setreturnlog(log);
		
	}

	public void setResultlist(String bisbn, String id) {
		LibraryService service = new LibraryService();
		service.deletelist(bisbn,id);
		
	}

	

}
