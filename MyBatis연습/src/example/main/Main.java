package example.main;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import example.dao.BookDAO;
import example.mybatis.MyBatisConnectionFactory;

public class Main {
	public static void main(String[] args) {
		//간단하게 책을 조회하고 삭제처리하는 데이터베이스 처리를
		//MyBatis를 이용해서 해본다.
		
		//DAO만 만들어서 처리(Controller와 Service는 배제)
		
		//1. 책의 ISBN을 이용해서 책 1권의 데이터를 가져와서 출력
		//DAO부터 생성해서 처리
		//기존에는 DAO한테 Connection을 넘겨줬는데 이제 DAO에게 SqlSessionFactory를 넘겨준다
		
		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
		BookDAO dao = new BookDAO(factory);
		/*
		 * HashMap<String,Object> map = dao.selectByISBNHashMap("89-7914-206-4");
		 * for(String key : map.keySet()) { System.out.println(key + ", " +
		 * map.get(key)); }
		 */
		
		//2. 조건 없이 모든 책의 데이터 가져와서 출력
		
		  List<HashMap<String,Object>> list = dao.selectAllHashMap();
		  
		  for(HashMap<String,Object> map : list) { for(String key : map.keySet()) {
		  System.out.println(key + ", " + map.get(key)); } }
		 
		
		//3. HashMap이 아니라 VO로 받기
		/*
		 * BookVO book = dao.selectByISBNBookVO("89-7914-206-4");
		 * System.out.println(book.getBtitle());
		 */
		
		//4. 책의 ISBN을 이용해서 책 1권의 데이터를 가져와서 출력
		//   resultMap이용
		//BookVO book = dao.selectByISBNResultMap("89-7914-206-4");
		
		//5. 책의 ISBN을 이용해서 책 1권의 데이터를 업데이트
		//   update하면 결과가 int로 나온다.
		/*
		 * BookVO book = new BookVO(); book.setBisbn("89-7914-206-4");
		 * book.setBtitle("자바 30일 완성!!"); book.setBauthor("신사임당"); book.setBprice(3000);
		 * int result = dao.updateByISBN(book); System.out.println("영향을 받은 행의 수 : " +
		 * result);
		 */
	}
}
