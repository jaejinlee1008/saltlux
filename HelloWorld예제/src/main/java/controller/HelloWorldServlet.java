package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/sayHello")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HelloWorldServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET 방식으로 호출되면 이 method호출
		// Thread에 의해서 호출
		// 1. 클라이언트가 보내준 데이터를 받는다. -> request 객체 이용
		// 2. 로직처리(DB처리 포함해서)
		// 3. 출력처리 -> response객체 이용
		//	  1. 처리된 결과를 보내주기 전에 먼저 처리한 결과가 어떤 데이터인지를 알려줘야 한다.
		response.setContentType("text/html; charset=UTF-8");
		//    2. 실제 결과 데이터를 전송하면 된다.
		//       network을 통해서 전송해야 하기 때문에 stream을 열어서 데이터 전송
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>까꿍</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
