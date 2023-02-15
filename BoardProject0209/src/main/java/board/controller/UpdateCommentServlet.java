package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import board.service.BoardService;
import board.vo.Comment;

/**
 * Servlet implementation class UpdateCommentServlet
 */
@WebServlet("/updatecomment")
public class UpdateCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCommentServlet() {
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
		String comment = request.getParameter("comment");
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(comment+num);

		HttpSession session = request.getSession(true);
		
		Comment cmt = new Comment();
		cmt.setCommentContent(comment);
		cmt.setCommentNum(num);
		
		
		// 2. 로직처리
		BoardService service = new BoardService();
		// 객체가 생성됐으면 일을 시킨다.
		// 로그인 성공시 vo안의 회원 이름까지 포함해서 리턴
		// 로그인 실패시 null 리턴
		int count = 0;
		count=service.updateComment(cmt);
		
		//List<Comment> list = null;
		//list = service.getAllComments(cmt.getPostNum());
		
		Comment newcmt = null;
		newcmt = service.getUpdatedComment(cmt);
		
		if(newcmt!=null) {
			System.out.println("여기부터 수정 서블릿");
			System.out.println(newcmt.getCommentContent());
			System.out.println(newcmt.getCommentDate()); 
		}
		String str = newcmt.getCommentContent();
		JSONObject jobj = new JSONObject(); 
		jobj.put("newComment", str);
		  
		//JSONArray jarr = new JSONArray(list);
		response.setContentType("application/json; charset=UTF-8"); 
		PrintWriter pw = response.getWriter(); 
		pw.println(jobj); 
		pw.close();
		 
		
	}

}
