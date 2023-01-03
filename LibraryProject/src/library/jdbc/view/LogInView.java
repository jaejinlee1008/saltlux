package library.jdbc.view;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import library.jdbc.controller.LogInController;

public class LogInView extends Application{
	
	private Text id;
	private Text pw;
	private TextField idtf;
	private TextField pwtf;
	private Button signUp;
	private Button logIn;
	
	private BorderPane root = null;
	private Scene scene=null;
	
	public boolean loginCheck(String id, String pw)
	{
		LogInController controller = new LogInController();
		boolean b = controller.getResult(id, pw);
		return b;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		root = new BorderPane();
		root.setPrefSize(700, 500);
		
		id = new Text("ID");
		id.setWrappingWidth(50);
		
		pw = new Text("비밀번호");
		pw.setWrappingWidth(50);
		
		idtf = new TextField();
		idtf.setPrefSize(200, 40);
		
		pwtf = new TextField();
		pwtf.setPrefSize(200, 40);
		pwtf.setOnAction(e->{
			
			
			if(idtf.getText().equals("administrator") && pwtf.getText().equals("administer1234"))
			{
				AdministratorView administratorview = new AdministratorView(primaryStage,scene,root);
				scene.setRoot(administratorview.getRoot());
				primaryStage.setScene(scene);
				primaryStage.setTitle("관리자 모드");
			} else if(loginCheck(idtf.getText(), pwtf.getText()))
			{
				UserModeView usermodeview = new UserModeView(primaryStage, scene, root,idtf.getText());
				scene.setRoot(usermodeview.getRoot());
				primaryStage.setScene(scene);
				primaryStage.setTitle("사용자 모드");
			}
		});
		
		FlowPane idflowpane = new FlowPane();
		idflowpane.setAlignment(Pos.CENTER);
		idflowpane.setColumnHalignment(HPos.CENTER);
		idflowpane.setPrefSize(700, 60);
		idflowpane.setHgap(10);
		idflowpane.getChildren().add(id);
		idflowpane.getChildren().add(idtf);
		
		FlowPane pwflowpane = new FlowPane();
		pwflowpane.setAlignment(Pos.CENTER);
		pwflowpane.setColumnHalignment(HPos.CENTER);
		pwflowpane.setPrefSize(700, 60);
		pwflowpane.setHgap(10);
		pwflowpane.getChildren().add(pw);
		pwflowpane.getChildren().add(pwtf);
		
		signUp = new Button("회원가입");
		signUp.setPrefSize(150, 70);
		signUp.setOnAction(e -> {
			SignUpView signupview = new SignUpView(primaryStage,scene,root);
			scene.setRoot(signupview.getSignUp());
			primaryStage.setScene(scene);
			primaryStage.setTitle("SignUP");
		});
		
		
		logIn = new Button("로그인");
		logIn.setPrefSize(150, 70);
		logIn.setOnAction(e -> {
			//db에서 id, pw 확인
			//관리자라면 관리자 모드, 사용자라면 사용자 모드
			if(idtf.getText().equals("administrator") && pwtf.getText().equals("administer1234"))
			{
				AdministratorView administratorview = new AdministratorView(primaryStage,scene,root);
				scene.setRoot(administratorview.getRoot());
				primaryStage.setScene(scene);
				primaryStage.setTitle("관리자 모드");
			}else if(loginCheck(idtf.getText(), pwtf.getText()))
			{
				UserModeView usermodeview = new UserModeView(primaryStage, scene, root,idtf.getText());
				scene.setRoot(usermodeview.getRoot());
				primaryStage.setScene(scene);
				primaryStage.setTitle("사용자 모드");
			}
		});
		
		
		FlowPane bottomflowpane = new FlowPane();
		bottomflowpane.setAlignment(Pos.CENTER);
		bottomflowpane.setColumnHalignment(HPos.CENTER);
		bottomflowpane.setPrefSize(700, 100);
		bottomflowpane.setHgap(200);
		bottomflowpane.getChildren().add(signUp);
		bottomflowpane.getChildren().add(logIn);
		
		FlowPane flowpane = new FlowPane();
		flowpane.setAlignment(Pos.CENTER);
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setPrefSize(700, 400);
		flowpane.setVgap(30);
		flowpane.setOrientation(Orientation.VERTICAL);
		flowpane.getChildren().add(idflowpane);
		flowpane.getChildren().add(pwflowpane);
		
		
		root.setCenter(flowpane);
		root.setBottom(bottomflowpane);
		
		scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Library Project");
		primaryStage.setOnCloseRequest(e->{
			
		});
		
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
}
