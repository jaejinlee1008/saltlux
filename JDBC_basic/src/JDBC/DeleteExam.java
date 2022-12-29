package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import JDBC.VO.Book;

public class DeleteExam {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String keyword = scan.next();
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			String id="root";
			String pw="test1234";
			
			// 2. 데이터베이스 연결
			Connection con=DriverManager.getConnection(jdbc_url,id,pw);
			
			con.setAutoCommit(false);
			
			// 3. PreparedStatement 생성
			String sql="DELETE FROM book where btitle like ?";
			String sql1="SELECT bisbn,btitle, bauthor,bprice FROM book WHERE btitle like ? ORDER BY bprice DESC";
			//PreparedStatement pstmt = con.prepareStatement(sql);
			PreparedStatement pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, "%"+keyword+"%");
			
			// 4. 실행
			//int count = pstmt.executeUpdate();
			// 리턴 값은 정수값, 영향을 받은 row의 개수
			ResultSet rs=pstmt.executeQuery();
			// 5. 결과처리
			//System.out.println("삭제한 row의 수는 : " + count);
			
			ArrayList<Book> list = new ArrayList<Book>();

			while(rs.next()){ 
				Book book = new Book(rs.getString("bisbn"), rs.getString("btitle"), rs.getString("bauthor"), rs.getInt("bprice"));
	            list.add(book);
	        }
			 
			for(Book book: list) {
				System.out.println(book);
	        }

			//con.commit() or con.rollback()
			//만약 transaction을 종료하지 않고 connection close시 자동으로 commit된다.
			con.rollback();
			
			// 6. 사용한 자원 반납
			pstmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
