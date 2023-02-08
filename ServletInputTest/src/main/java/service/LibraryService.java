package service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSessionFactory;

import dao.LibraryDAO;
import mybatis.MyBatisConnectionFactory;
import vo.BookVO;

public class LibraryService {
	public ArrayList<BookVO> getSelectedBykeyword(String input, int price) {
			
			SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
			LibraryDAO dao = new LibraryDAO(factory);
			ArrayList<BookVO> list =  dao.select(input,price);
			
			return list;
	}
}
