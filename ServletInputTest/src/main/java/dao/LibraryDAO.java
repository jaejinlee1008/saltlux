package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.BookVO;

public class LibraryDAO {
	
	Connection con = null;
	private SqlSessionFactory factory=null;

	
	public LibraryDAO(Connection con) { this.con = con; }
	 
	public LibraryDAO(SqlSessionFactory factory) {
		this.factory = factory;
	}

	public ArrayList<BookVO> select(String input, int price) {
		String bisbn="";
		String btitle="";
		String bauthor="";
		int bprice=0;
		
		ArrayList<BookVO> booklist = null;
		List<HashMap<String,Object>> list = null;
		HashMap<String,Object> hashmap = new HashMap<>();
		hashmap.put("input", input);
		hashmap.put("price",price);
		SqlSession session = factory.openSession();
		
		list = session.selectList("servlet.myBook.selectListByid", hashmap);
		
		booklist = new ArrayList<BookVO>();
		
		for(HashMap<String, Object> map : list)
		{
			bisbn = (String) map.get("bisbn");
			btitle = (String) map.get("btitle");
			bauthor = (String) map.get("bauthor");
			bprice = (Integer) map.get("bprice");
			booklist.add(new BookVO(bisbn,btitle,bauthor,bprice));
		}
		
		return booklist;
	}
	
	

	
}
