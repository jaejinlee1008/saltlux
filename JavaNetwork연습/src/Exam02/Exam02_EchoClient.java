package Exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam02_EchoClient extends Application {

	TextArea textarea;
	Button connBtn;
	TextField textField;
	TextField idField;
	
	Socket s;
	PrintWriter pr;
	BufferedReader br;
	
	
	private void printMsg(String msg)
	{
		Platform.runLater(() -> {
			textarea.appendText(msg+"\n");
		});
	}
	
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500); //Layout의 가로세로 크기
		
		textarea = new TextArea();
		root.setCenter(textarea);
		
		connBtn = new Button("서버 접속");
		connBtn.setPrefSize(150, 40);
		connBtn.setOnAction(e -> {
			try {
				s = new Socket("127.0.0.1", 5000);
				printMsg("서버에 연결 성공!!");
				textField.setDisable(false);
				pr = new PrintWriter(s.getOutputStream());
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			} catch (UnknownHostException e1) {
				
			} catch (IOException e1) {
				
			}
		});
		
		idField = new TextField();
		idField.setPrefSize(200, 40);
		
		
		textField = new TextField();
		textField.setPrefSize(200, 40);
		textField.setDisable(true);
		textField.setOnAction(e -> {
			String msg = textField.getText();
			String id = idField.getText();
			pr.println(id + "> " + msg);
			pr.flush();
			
			if(!msg.equals("/exit"))
			{
				try {
					printMsg(br.readLine());
				} catch (IOException e1) {
				}
				
			}else {
				printMsg("클라이언트가 종료 되었어요");
			}
			textField.clear();
		});
		
		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10,10,10,10)); //여백 상하좌우 10씩
		flowpane.setColumnHalignment(HPos.CENTER); //가운데 정렬
		flowpane.setHgap(10); //컴포넌트 사이의 여백
		flowpane.getChildren().add(connBtn);
		flowpane.getChildren().add(idField);
		flowpane.getChildren().add(textField);
		root.setBottom(flowpane);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Echo Client Program");
		primaryStage.show();
	}
	
	
	public static void main(String[] args) {
		launch();
	}
}
