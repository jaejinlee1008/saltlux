package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TextInputServlet
 */
@WebServlet("/inputText")
public class TextInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// field를 만들 수 있다
	int count=0;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TextInputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		count +=1; // 공유되는지 확인
		// 1.입력받기
		String data = request.getParameter("userID");
		// 2. 로직처리
		// 3. 출력처리
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println(data+"님 환영합니다!");
		out.println("<br><br>");
		out.println("이건 get 방식");
		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST방식일경우
		// 클라이언트로부터 servlet으로 전송된 문자데이터는 ISO_8859_1 인코딩으로 되어 있어서
		// 한글처리가 안된다.
		// 인코딩을 바꿔서 한글 처리를 해줘야 한다.
		request.setCharacterEncoding("UTF-8");
		count +=1; // 공유되는지 확인
		// 1.입력받기
		String data = request.getParameter("userID");
		// 2. 로직처리
		// 3. 출력처리
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println(data+"님 환영합니다!</body>");
		out.println("</html>");
		out.close();
		
	}

}
