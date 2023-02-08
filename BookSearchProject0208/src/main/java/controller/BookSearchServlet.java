package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import mybatis.MyBatisConnectionFactory;
import vo.Book;

/**
 * Servlet implementation class BookSearchServlet
 */
@WebServlet("/bookSearch")
public class BookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String keyword = request.getParameter("keyword");
		String price = request.getParameter("price");
		
		Book book=new Book();
		book.setBtitle(keyword);
		book.setBprice(Integer.parseInt(price));
		
		SqlSession session=MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		List<Book> result = session.selectList("myBook.selectBookByKeyword",book);
		session.close();
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println("<h1>검색결과입니다</h1><br>");
		out.println("<h3>검색키워드"+keyword+"</h3><br>");
		out.println("<h3>검색가격"+price+"</h3><br>");
		
		out.println("<ul>");
		for(Book b:result) {
			out.println("<li> 제목 : " + b.getBtitle() + ", 가격 : "+ b.getBprice() + "</li>");
		}
		out.println("</ul>");
		out.println("<br><br>");
		out.println("</body></html>");
		out.close();
		
	}

}
