package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LibraryService;
import vo.BookVO;

/**
 * Servlet implementation class BookSearchServlet
 */
@WebServlet("/booksearch")
public class BookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String keyword = request.getParameter("mytext");
		String radio= request.getParameter("myradio");
		int price = Integer.parseInt(radio);
		LibraryService service = new LibraryService();
		ArrayList<BookVO> list = service.getSelectedBykeyword(keyword,price);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println("<h1>검색결과입니다</h1><br>");
		out.println("<div>검색키워드"+keyword+"</div><br>");
		out.println("<div>검색가격"+radio+"</div><br>");
		
		out.println("<ul>");
		for(BookVO book:list) {
			out.println("<li> 제목 : " + book.getBtitle() + " 가격 : "+ book.getBprice() + "</li>");
		}
		out.println("</ul>");
		out.println("<br><br>");
		out.println("</body></html>");
		out.close();
	}

}
