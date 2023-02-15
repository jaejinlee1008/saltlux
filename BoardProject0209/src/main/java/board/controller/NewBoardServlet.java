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
import board.vo.showBoard;
import member.vo.Member;

/**
 * Servlet implementation class NewBoardServlet
 */
@WebServlet("/newboard")
public class NewBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewBoardServlet() {
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
		String postTitle = request.getParameter("title");
		String postContent = request.getParameter("content");
		
		
		Board newpost = new Board();
		newpost.setBoardTitle(postTitle);
		newpost.setBoardContent(postContent);
		newpost.setBoardLike(0);
		HttpSession session = request.getSession(true);
		if(session!=null)
		{
			System.out.println(((Member)session.getAttribute("member")).getMemberName());
			newpost.setBoardAuthor(((Member)session.getAttribute("member")).getMemberId());
		}else
		{
			System.out.println("비어있음");
		}
		
		// 2. 로직처리
		BoardService service = new BoardService();
		// 객체가 생성됐으면 일을 시킨다.
		// 로그인 성공시 vo안의 회원 이름까지 포함해서 리턴
		// 로그인 실패시 null 리턴
		service.createPost(newpost);
		
		List<showBoard> list = null;
		BoardService bservice = new BoardService();
		list = bservice.getAllBoard();
		
		
		// 3. 출력처리
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
		session.setAttribute("boardList", list);
		dispatcher.forward(request, response);
		
		
		
		 
	}

}
