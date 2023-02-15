package board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;

import board.service.BoardService;
import board.vo.Board;
import board.vo.showBoard;

/**
 * Servlet implementation class DeletePostServlet
 */
@WebServlet("/deletepost")
public class DeletePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePostServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(num);

		HttpSession session = request.getSession(true);
		
		Board board = new Board();
		board.setBoardNum(num);
		
		showBoard showboard = new showBoard();
		showboard.setBoardNum(num);
		
		BoardService service = new BoardService();
		int count = 0;
		count=service.deletePost(board);
		if(count==1)
		{
			System.out.println("게시글 삭제 하고 서블릿까지");
		}
		List<showBoard> list = null;
		BoardService bservice = new BoardService();
		list = bservice.getAllBoard();
		if(list!=null)
		{
			System.out.println("list안비었다.");
		}

		session.setAttribute("boardList", list);
		
		JSONArray jarr = new JSONArray(list);
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println(jarr);
		pw.close();
	}

}
