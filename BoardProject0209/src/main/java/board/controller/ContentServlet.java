package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardService;
import board.vo.Board;
import board.vo.Comment;
import board.vo.showBoard;

/**
 * Servlet implementation class ContentServlet
 */
@WebServlet("/content")
public class ContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String numstr = request.getParameter("num");
		int num = Integer.parseInt(numstr);
		
		
		
		Board content = new Board();
		showBoard sb = new showBoard();
		content.setBoardNum(num);
		sb.setBoardNum(num);

		BoardService service = new BoardService();
		
		Board board = service.getContent(content);
		showBoard sboard = service.getName(sb);
		
		List<Comment> list = null;
		list = service.getAllComments(num);
		
		HttpSession session = request.getSession(true);
		session.setAttribute("Board", board);
		session.setAttribute("showBoard", sboard);
		RequestDispatcher dispatcher = request.getRequestDispatcher("content.jsp");
		request.setAttribute("commentList", list);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
