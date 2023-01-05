package library.jdbc.controller;

import javafx.collections.ObservableList;
import library.jdbc.VO.UserVO;
import library.jdbc.service.LibraryService;

public class UserInfoListController {

	public ObservableList<UserVO> getResult() {
		LibraryService service = new LibraryService();
		ObservableList<UserVO> user = service.getUserList();
		return user;
	}

}
