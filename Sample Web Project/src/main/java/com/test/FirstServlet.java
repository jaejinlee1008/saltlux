package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/myservlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FirstServlet() {
        // TODO Auto-generated constructor stub
    }
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    	// TODO Auto-generated method stub
//    	// Thread Invoker가 만든 Thread가 이 service()를 호출
//    	super.service(req, resp);
//    }
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	// init()의 목적은 servlet instance를 초기화 하기 위함이다.
    	System.out.println("init이 호출됨");
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// 클라이언트가 GET 방식으로 이 servlet을 호출하면 이 method가 호출된다.
		// 결과적으로 봤을때 doGet() method가 호출된다.
		// 클라이언트의 호출 URL= http://127.0.0.1:8080/sample/myservlet
		// URL이 불리면 이 클래스 안에 있는 doGet()이 호출된다.
		
		// 따라서 클라이언트가 접속했을때 해야할 일을 여기에 작성해야 한다.
		// 프로그램 처리방식대로 작성
		// 1. 입력을 받는다.
		// 2. 로직처리.
		// 3. 출력처리.
		//    1. 여기에서(server) 클라이언트에게 전달한 데이터가 어떤 데이터인지 설정
		response.setContentType("text/html; charset=UTF-8");
		//    2. 클라이언트에게 데이터를 전달하기 위해 stream을 연다
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>이건 servlet의 결과</body>");
		out.println("</html>");
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
