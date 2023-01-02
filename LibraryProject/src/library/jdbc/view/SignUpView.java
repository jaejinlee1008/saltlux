package library.jdbc.view;

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

public class SignUpView{
	
	private BorderPane logIn=null;
	private Stage primaryStage=null;
	private Scene scene=null;
	
	public SignUpView() {
		// TODO Auto-generated constructor stub
	}
	
	public SignUpView(Stage primaryStage,Scene scene,BorderPane root) {
		this.primaryStage=primaryStage;
		this.scene = scene;
		this.logIn=root;
	}

	private Text name;
	private Text id;
	private Text pw;
	private Text pwcheck;
	private Text email;
	private TextField nametf;
	private TextField idtf;
	private TextField pwtf;
	private TextField pwchecktf;
	private TextField emailtf;
	
	private Button signup;
	
	public BorderPane getSignUp()
	{
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		name = new Text("이름");
		name.setWrappingWidth(50);
		
		nametf = new TextField();
		nametf.setPrefSize(200, 40);
		
		id = new Text("ID");
		id.setWrappingWidth(50);
		
		idtf = new TextField();
		idtf.setPrefSize(200, 40);
		
		pw = new Text("비밀번호");
		pw.setWrappingWidth(50);
		
		pwtf = new TextField();
		pwtf.setPrefSize(200, 40);
		
		pwcheck = new Text("비밀번호확인");
		pwcheck.setWrappingWidth(50);
		
		pwchecktf = new TextField();
		pwchecktf.setPrefSize(200, 40);
		
		email = new Text("email");
		email.setWrappingWidth(50);
		
		emailtf = new TextField();
		emailtf.setPrefSize(200, 40);
		
		FlowPane nameflowpane = new FlowPane();
		nameflowpane.setAlignment(Pos.CENTER);
		nameflowpane.setColumnHalignment(HPos.CENTER);
		nameflowpane.setPrefSize(700, 60);
		nameflowpane.setHgap(10);
		nameflowpane.getChildren().add(name);
		nameflowpane.getChildren().add(nametf);
		
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
		
		FlowPane pwcheckflowpane = new FlowPane();
		pwcheckflowpane.setAlignment(Pos.CENTER);
		pwcheckflowpane.setColumnHalignment(HPos.CENTER);
		pwcheckflowpane.setPrefSize(700, 60);
		pwcheckflowpane.setHgap(10);
		pwcheckflowpane.getChildren().add(pwcheck);
		pwcheckflowpane.getChildren().add(pwchecktf);
		
		FlowPane emailflowpane = new FlowPane();
		emailflowpane.setAlignment(Pos.CENTER);
		emailflowpane.setColumnHalignment(HPos.CENTER);
		emailflowpane.setPrefSize(700, 60);
		emailflowpane.setHgap(10);
		emailflowpane.getChildren().add(email);
		emailflowpane.getChildren().add(emailtf);
		
		signup = new Button("가입");
		signup.setPrefSize(150, 70);
		signup.setOnAction(e -> {
			//db에 데이터 넣고 창 로그인 창으로 돌아가기
			scene.setRoot(logIn);
			primaryStage.setScene(scene);
		});
		
		
		
		
		FlowPane bottomflowpane = new FlowPane();
		bottomflowpane.setAlignment(Pos.CENTER);
		bottomflowpane.setColumnHalignment(HPos.CENTER);
		bottomflowpane.setPrefSize(700, 100);
		bottomflowpane.setHgap(200);
		bottomflowpane.getChildren().add(signup);
		
		FlowPane flowpane = new FlowPane();
		flowpane.setAlignment(Pos.CENTER);
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setPrefSize(700, 400);
		flowpane.setVgap(10);
		flowpane.setOrientation(Orientation.VERTICAL);
		flowpane.getChildren().add(nameflowpane);
		flowpane.getChildren().add(idflowpane);
		flowpane.getChildren().add(pwflowpane);
		flowpane.getChildren().add(pwcheckflowpane);
		flowpane.getChildren().add(emailflowpane);
		
		
		root.setCenter(flowpane);
		root.setBottom(bottomflowpane);
		
		return root;
	}
}
