package JavaFxExam;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFXExample extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 화면 구성하는 작업을 여기서 한다
		Button btn = new Button();
		btn.setText("안녕!");
		//button에 이벤트 처리를 해야 한다.
		//Java는 delegation model을 이용한다. -> Web의 javascript에서도 이 방식을 이용한다.
		btn.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				
				System.out.println("안녕하세요!!");
			}
		});
		
		
		//Layout을 설정한다 (컴포넌트가 붙는 방식을 결정하는 객체)
		StackPane root = new StackPane(); //Layout중 추가되는 순서대로 덧붙여서 시각화하는 Layout
		root.getChildren().add(btn);
		
		Scene scene = new Scene(root,300,150);
		primaryStage.setTitle("연습입니다");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(); //static method, GUI thread를 실행시킨다.
	}
}
