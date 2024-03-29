package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import board.service.BoardService;
import board.vo.Board;

/**
 * Servlet implementation class UpdatePostServlet
 */
@WebServlet("/updatepost")
public class UpdatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePostServlet() {
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
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(title+content+num);

		
		Board board = new Board();
		board.setBoardTitle(title);
		board.setBoardContent(content);
		board.setBoardNum(num);
		
		
		// 2. 로직처리
		BoardService service = new BoardService();
		int count = 0;
		count=service.updatePost(board);
		
		
		JSONObject jobj = new JSONObject(); 
		jobj.put("data", count);
  
		response.setContentType("application/json; charset=UTF-8"); 
		PrintWriter pw = response.getWriter(); 
		pw.println(jobj); 
		pw.close();
		
		
		
	}

}
