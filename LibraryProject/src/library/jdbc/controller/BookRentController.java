package library.jdbc.controller;



import javafx.collections.ObservableList;
import library.jdbc.VO.LogVO;
import library.jdbc.service.LibraryService;

public class BookRentController {

	public void setResult(String bisbn,String btitle ,String ID,String c) {
		LibraryService service = new LibraryService();
		service.insertRentInfo(bisbn,btitle,ID,c);
		
	}
	
	public ObservableList<LogVO> setResult(String btitle,String bisbn,String ID,String name,String rentORreturn,int point)
	{
		LibraryService service = new LibraryService();
		ObservableList<LogVO> loglist = service.insertRentInfo(btitle, bisbn, ID, name, rentORreturn, point);
		return loglist;
	}

}
