package Exam02;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


class EchoRunnable implements Runnable{
	
	public EchoRunnable() {
		// TODO Auto-generated constructor stub
	}
	
	public EchoRunnable(Socket s)
	{
		this.s =s;
		try {
			pr=new PrintWriter(s.getOutputStream());
			br=new BufferedReader(new InputStreamReader(s.getInputStream()));
		} catch (IOException e) {
		}
		
	}
	Socket s;
	PrintWriter pr;
	BufferedReader br;
	
	
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

public class Exam02_EchoServer extends Application {
	
	TextArea textarea;
	Button startBtn;
	Button stopBtn;
	ServerSocket server;
	Socket s;
	PrintWriter pr;
	BufferedReader br;
	
	private void printMsg(String msg)
	{
		Platform.runLater(() -> {
			textarea.appendText(msg+"\n");
		});
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500); //Layout의 가로세로 크기
		
		textarea = new TextArea();
		root.setCenter(textarea);
		
		startBtn = new Button("서버 시작");
		startBtn.setPrefSize(150, 40);
		startBtn.setOnAction(e -> {  //EventHandler의 축약형, 일반적인 사용형태이다, 모든 핸들러에 적용되는 것은 아니다.
			//textarea.appendText("서버가 시작되었어요!\n"); //blocking method 실행되는 동안 수행이 잠시 중지된다.
			//순차처리를 안하기 위해서 Thread를 사용한다.
			/*
			 * Platform.runLater(new Runnable() {
			 * 
			 * public void run() {
			 * 
			 * } });
			 */
			printMsg("서버가 시작되었어요!");
			try {
				server = new ServerSocket(5000);
				printMsg("클라이언트 접속 대기중");
				
				new Thread(()->{
					try {
						while(true)
						{
							s = server.accept();
							printMsg("클라이언트 접속 성공");
							new Thread(new EchoRunnable(s)).start();
						}
					} catch (IOException e1) {
					}
				}).start();
				
			} catch (IOException e1) {
				
			}
			
		}); 
		
		stopBtn = new Button("서버 종료");		
		stopBtn.setPrefSize(150, 40);
		stopBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
					
			}
		});
		
		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10,10,10,10)); //여백 상하좌우 10씩
		flowpane.setColumnHalignment(HPos.CENTER); //가운데 정렬
		flowpane.setHgap(375); //컴포넌트 사이의 여백
		flowpane.getChildren().add(startBtn);
		flowpane.getChildren().add(stopBtn);
		root.setBottom(flowpane);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Echo Server Program");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
}
