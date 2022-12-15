package Exam03;

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

public class Exam03_MultiEchoClient extends Application{
	
	TextArea textarea;
	TextField ipTextField;
	TextField idTextField;
	TextField chatTextField;
	Button connBtn;
	
	Socket socket;
	PrintWriter pr;
	BufferedReader br;
	
	private void printMsg(String msg)
	{
		Platform.runLater(()->{
			textarea.appendText(msg + "\n");
		});
	}
	
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		BorderPane root = new BorderPane();
		textarea = new TextArea();
		root.setPrefSize(700, 500);
		root.setCenter(textarea);
		
		
		
		ipTextField = new TextField();
		ipTextField.setPrefSize(200, 40);
		
		connBtn = new Button("서버 시작");
		connBtn.setPrefSize(150, 40);
		connBtn.setOnAction(e->{
			try {
				socket = new Socket(ipTextField.getText(),7777);
				pr = new PrintWriter(socket.getOutputStream());
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		FlowPane flowpanetop = new FlowPane();
		
		flowpanetop.setPadding(new Insets(10,10,10,10));
		flowpanetop.setColumnHalignment(HPos.CENTER);
		flowpanetop.setPrefSize(700, 40);
		flowpanetop.setHgap(10);
		flowpanetop.getChildren().add(ipTextField);
		flowpanetop.getChildren().add(connBtn);
		
		idTextField = new TextField();
		idTextField.setPrefSize(200, 40);
		
		chatTextField = new TextField();
		chatTextField.setPrefSize(300, 40);
		chatTextField.setOnAction(e->{
			String id = idTextField.getText();
			String msg = chatTextField.getText();
			pr.println(id+ "> " + msg);
			pr.flush();
			
			try {
				String receive = br.readLine();
				printMsg(receive);
			} catch (IOException e1) {
				
			}
			chatTextField.clear();
		});
		
		FlowPane flowpanebottom = new FlowPane();
		
		flowpanebottom.setPadding(new Insets(10,10,10,10));
		flowpanebottom.setColumnHalignment(HPos.CENTER);
		flowpanebottom.setPrefSize(700, 40);
		flowpanebottom.setHgap(10);
		flowpanebottom.getChildren().add(idTextField);
		flowpanebottom.getChildren().add(chatTextField);
		
		root.setTop(flowpanetop);
		root.setBottom(flowpanebottom);
		
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Multi Echo Client Program");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
}
