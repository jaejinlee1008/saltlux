package library.jdbc.controller;



import library.jdbc.service.LibraryService;

public class BookRentController {

	public void setResult(String bisbn,String btitle ,String ID,String c) {
		LibraryService service = new LibraryService();
		service.insertRentInfo(bisbn,btitle,ID,c);
		
	}
	
	public void setResult(String btitle,String bisbn,String ID,String name,String rentORreturn,int point)
	{
		LibraryService service = new LibraryService();
		service.insertRentInfo(btitle, bisbn, ID, name, rentORreturn, point);		
	}

}
