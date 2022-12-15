package Exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

class MyRunnable implements Runnable
{
	
	Socket socket;
	PrintWriter pr;
	BufferedReader br;
	public MyRunnable() {
		
	}
	
	public MyRunnable(Socket socket)
	{
		this.socket = socket;
		try {
			this.pr = new PrintWriter(socket.getOutputStream());
			this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
		}
		
	}
	
	
	public void run() {
		while(true) {
			String msg = "";
			try {
				msg = br.readLine();
			} catch (IOException e1) {
			}
			
			pr.println(msg);
			pr.flush();
		}
		
	}
}

public class Exam03_MultiEchoServer extends Application{
	
	TextArea textarea;
	Button startBtn;
	Button stopBtn;
	ServerSocket server;
	
	private void printMsg(String msg)
	{
		Platform.runLater(()->{
			textarea.appendText(msg + "\n");
		});
	}
	
	public void start(Stage primaryStage) throws Exception {
		//화면구성
		//primaryStage -> 실제 window
		//화면을 구성할 Layout 먼저 생성
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		
		
		textarea = new TextArea();
		root.setCenter(textarea);
		
		startBtn = new Button("서버 시작!!");
		startBtn.setPrefSize(150, 40);
		//버튼의 이벤트 처리코드 작성
		startBtn.setOnAction(e -> {
			//여기가 실행 될 동안 window는 block된다.
			
			
			new Thread(()->{
				//서버소켓 하나 생성 -> 클라이언트의 접속 기다린다
				try {
					//port 번호가 다른 프로그램에서 사용되고 있을 수 있기 때문에 예외처리를 해줘야함
					server = new ServerSocket(7777);
					while(true)
					{
						Socket socket = server.accept();//클라이언트의 접속 대기
						//대기하고 있다가 클라이언트가 접속하면 해당 클라이언트와 연결된 Socket객체를 하나 생성
						
						printMsg("새로운 클라이언트 접속\n");
						
						//socket을 이용해서 직접 클라이언트와 통신하는 기능을 수행하는 Thread 생성
						new Thread(new MyRunnable(socket)).start();
					}
					
				} catch (IOException e1) {
					
				}
			}).start();
			
			
		});
		
		stopBtn = new Button("서버 중지");
		stopBtn.setPrefSize(150, 40);
		stopBtn.setOnAction(e -> {
			
		});
		
		//BorderPane의 아래부분(Bottom)에 버튼을 부착시키기 위해 또 다른 Layout을 하나 만들어서 버튼 2개를 붙이고 이 Layout을 BorderPane 아래 부분에 붙인다
		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10,10,10,10));
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setPrefSize(700, 40);
		flowpane.setHgap(10);
		flowpane.getChildren().add(startBtn);
		flowpane.getChildren().add(stopBtn);
		
		root.setBottom(flowpane);
		//이런 Layout을 이용해서 장면(Scene)을 만든다.
		Scene scene = new Scene(root);
		
		//이제 만들어진 장면을 window에 넣어서 띄워요!
		primaryStage.setScene(scene);
		primaryStage.setTitle("Echo Server Program");
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		//main thread에 의해서 최초로 실행되는 method
		//entry point
		//GUI Thread를 하나 생성
		launch();
	}
}
