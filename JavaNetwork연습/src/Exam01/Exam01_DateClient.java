package Exam01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.application.Application;
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

public class Exam01_DateClient extends Application {

	
	TextArea textarea;
	Button connBtn;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 화면구성
		// 레이아웃부터 생성한다.
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		// component생성
		textarea = new TextArea();
		root.setCenter(textarea);
		connBtn = new Button("Date 서버 접속");
		connBtn.setPrefSize(150, 40);
		connBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// onclick이벤트
				textarea.clear(); //textarea안의 내용을 싹 다 지운다.
				//서버에 접속 -> Socket객체 생성 시도
				//객체 생성 성공시 접속 성공
				//IP와 Port알아야함
				try {
					Socket s = new Socket("127.0.0.1",3000); //127.0.0.1 -> 내가 사용하는 computer 지칭 (local host)
					System.out.println("서버에 접속 성공!");
					BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
					
					String msg = br.readLine();
					
					System.out.println(msg);
					
					
					br.close();
					s.close();
					System.out.println("서버와 연결 종료!");
				} catch (UnknownHostException e) {
					
				} catch (IOException e) {
					
				}  
			}
		});
		FlowPane flowpane = new FlowPane(); //아래 쪽 영역에 붙는 layout
		//여백 공간 설정
		flowpane.setPadding(new Insets(10,10,10,10));
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setPrefSize(700, 40);
		flowpane.setHgap(10);
		
		flowpane.getChildren().add(connBtn);
		root.setBottom(flowpane);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch();
	}

}
