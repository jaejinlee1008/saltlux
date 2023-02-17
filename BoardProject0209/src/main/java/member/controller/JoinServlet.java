package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberService;
import member.vo.Member;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
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
		String userId = request.getParameter("userID");
		String userName = request.getParameter("userName");
		String userPw = request.getParameter("userPW");
		// 입력받은 데이터로 VO를 생성
		Member member = new Member();
		member.setMemberId(userId);
		member.setMemberName(userName);
		member.setMemberPw(userPw);
		// 2. 로직처리
		MemberService service = new MemberService();
		// 객체가 생성됐으면 일을 시킨다.
		// 로그인 성공시 vo안의 회원 이름까지 포함해서 리턴
		// 로그인 실패시 null 리턴
		int count = service.join(member);
		
		if(count==1)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
			dispatcher.forward(request, response);
		}else {
			
			response.sendRedirect("join.jsp");
		}
		
		
		
		
	}

}
