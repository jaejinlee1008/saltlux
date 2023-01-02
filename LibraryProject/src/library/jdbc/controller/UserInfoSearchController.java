package library.jdbc.controller;


import library.jdbc.VO.UserVO;
import library.jdbc.service.LibraryService;

public class UserInfoSearchController {
	
	public UserVO getResult(String ID) {
		LibraryService service = new LibraryService();
		UserVO user = service.userinfo(ID);
		return user;
	}
	
}
