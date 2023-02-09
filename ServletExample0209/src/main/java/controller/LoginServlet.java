package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import mybatis.MyBatisConnectionFactory;
import vo.User;

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
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("userID");
		String pw = request.getParameter("userPW");
		
		User user=new User();
		user.setId(id);
		user.setPassword(pw);
		
		SqlSession sqlsession=MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		User result = sqlsession.selectOne("myLogin.LoginCheck", user);
		sqlsession.close();
		
		if(result!=null)
		{
			// 로그인 성공
			// servlet container에게 session객체를 요청
			// 만약 기존에 할당받은 세션객체가 존재하면 그 객체 리턴
			// 없다면 새로 만들어서 리턴
			HttpSession session = request.getSession(true);
			// 이 세션객체는 Map형태이다.
			session.setAttribute("loginName", result.getName());
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		if(result==null)
		{
			out.println("로그인 실패!!");
		}else
		{
			out.println(result.getName() + "님 환영합니다!");
			out.println("<br><br>");
			out.println("<a href='board'>게시판 들어가기</a>");
		}
		
		
		out.println("<br><br>");
		out.println("</body></html>");
		out.close();
	}

}
