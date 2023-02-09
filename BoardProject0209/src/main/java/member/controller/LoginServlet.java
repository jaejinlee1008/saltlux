package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.MemberService;
import member.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		// Servlet은 MVC(Model-View-Controller) pattern에서 Controller의 역할
		// Model : 1. Data Model => VO class가 이 역할을 담당
		//		   2. Business Logic Model => Service class가 이 역할을 담당
		//			  -DB 처리가 들어올 수 있다. 이 데이터 처리는 DAO가 담당
		// View : HTML,JSP
		// Controller : View와 Model을 연결해주는 역할을 담당 => Servlet
		//				View로부터 사용자데이터를 받아서 Model(Service)에게 전달해서
		//				로직처리시키고 로직처리된 결과를 Model(Service)로부터 받아온다.
		//				그 결과를 보고 특정 View를 선택해서 그 View를 클라이언트에게
		//				전달하도록 시킨다
		// 1. 입력받고
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userID");
		String userPw = request.getParameter("userPW");
		// 입력받은 데이터로 VO를 생성
		Member member = new Member();
		member.setMemberId(userId);
		member.setMemberPw(userPw);
		// 2. 로직처리
		MemberService service = new MemberService();
		// 객체가 생성됐으면 일을 시킨다.
		// 로그인 성공시 vo안의 회원 이름까지 포함해서 리턴
		// 로그인 실패시 null 리턴
		Member result = service.login(member);
		
		// 3. 출력처리
		if(result!=null)
		{
			// 로그인 성공
			HttpSession session = request.getSession(true);
			session.setAttribute("member", result);
			// 게시판 HTML 페이지를 클라이언트에게 전송(jsp)
			// 하나의 servlet이 다른 servlet을 호출할때 디스패쳐 사용
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
			dispatcher.forward(request, response);
		}else {
			// 로그인 실패
			// 오류 HTML페이지를 클라이언트에게 전송 (html)
			response.sendRedirect("loginFail.html");
		}
		
	}

}
