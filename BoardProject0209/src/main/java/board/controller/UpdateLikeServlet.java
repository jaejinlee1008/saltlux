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
import board.vo.Like;

/**
 * Servlet implementation class UpdateLikeServlet
 */
@WebServlet("/updatelike")
public class UpdateLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateLikeServlet() {
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
		
		String id = request.getParameter("id");
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(id+num);

		Like like = new Like();
		like.setBoardNum(num);
		like.setLikeId(id);
		
		Board board = new Board();
		board.setBoardNum(num);
		
		BoardService service = new BoardService();
		int counti = 0;
		int countd =0;
		int countb=0;
		int likecount=0;
		Like isexist = service.getIsExist(like);
		if(isexist!=null)
		{
			countd=service.deleteLike(like);
			if(countd==1)
			{
				countb=service.updatesubLike(board);
			}
		}else
		{
			counti=service.insertLike(like);
			if(counti==1)
			{
				countb=service.updateplusLike(board);
			}
		}
	
		if(countb==1)
		{
			System.out.println("좋아요 새로고침 성공");
			likecount=service.getLikeNum(board);
		}else
		{
			System.out.println("좋아요 뭔가 문제 발생");
		}
		
		JSONObject jobj = new JSONObject();
		jobj.put("counti", counti);
		jobj.put("countd", countd);
		jobj.put("countb", countb);
		jobj.put("likecount", likecount);
		
		response.setContentType("application/json; charset=UTF-8"); 
		PrintWriter pw = response.getWriter(); 
		pw.println(jobj); 
		pw.close();
	}

}
