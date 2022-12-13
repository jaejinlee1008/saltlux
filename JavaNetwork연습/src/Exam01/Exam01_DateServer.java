package Exam01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.util.Date;

public class Exam01_DateServer {
	public static void main(String[] args) {
		
		try { //객체 생성시 port 번호를 부여해야 client가 프로그램을 찾아올 수 있다. port번호가 중복될 수 있기에 try catch문을 써야함
			ServerSocket server = new ServerSocket(3000);
			//이 서버소켓을 통해 클라이언트의 접속을 기다려야 한다.
			if(server!=null)
			{
				System.out.println("서버소켓이 생성되었어요 - 포트번호 3000");
			}
			Socket s = server.accept(); //Client가 접속 할 때 까지 대기
			System.out.println("클라이언트 접속 성공");
			
			PrintWriter out = new PrintWriter(s.getOutputStream());
			
			DateFormat dateformat = DateFormat.getInstance();
			String currentDate = dateformat.format(new Date());
			
			out.println(currentDate);
			out.flush();
			
			out.close();
			s.close();
			
			server.close();
			System.out.println("서버 프로그램 종료");
		} catch (IOException e) {
	
		}
	}
}
