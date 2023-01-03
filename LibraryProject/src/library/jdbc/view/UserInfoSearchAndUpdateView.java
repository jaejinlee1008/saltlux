package library.jdbc.view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UserInfoSearchAndUpdateView {
	private BorderPane user=null;
	private Scene scene = null;
	private Stage primaryStage = null;
	private Button goBack;
	private Button pwChange;
	private Button change;
	private Button unregister;
	
	private String oldName;
	private String oldID;
	private String oldEmail;
	private int oldPoint;
	
	private Text name;
	private Text id;
	private Text email;
	private Text isrent;
	private Text point;
	private TextField nametf;
	private TextField idtf;
	private TextField emailtf;
	private TextField isrenttf;
	private TextField pointtf;
	

	public UserInfoSearchAndUpdateView(BorderPane user, Scene scene, Stage primaryStage, String oldName, String oldID,
			String oldEmail, int oldPoint) {
		super();
		this.user = user;
		this.scene = scene;
		this.primaryStage = primaryStage;
		this.oldName = oldName;
		this.oldID = oldID;
		this.oldEmail = oldEmail;
		this.oldPoint = oldPoint;
	}

	public BorderPane getRoot()
	{
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		name = new Text("이름");
		name.setWrappingWidth(50);
		
		nametf = new TextField();
		nametf.setPrefSize(200, 40);
		nametf.setDisable(true);
		nametf.setText(oldName);
		
		id = new Text("ID");
		id.setWrappingWidth(50);
		
		idtf = new TextField();
		idtf.setPrefSize(200, 40);
		idtf.setDisable(true);
		idtf.setText(oldID);
		
		email = new Text("email");
		email.setWrappingWidth(50);
		
		emailtf = new TextField();
		emailtf.setPrefSize(200, 40);
		emailtf.setText(oldEmail);
		
		isrent = new Text("대여여부");
		isrent.setWrappingWidth(50);
		
		
		
		point = new Text("point");
		point.setWrappingWidth(50);
		
		pointtf = new TextField();
		pointtf.setPrefSize(200, 40);
		pointtf.setDisable(true);
		pointtf.setText(Integer.toString(oldPoint));
		
		pwChange = new Button("비밀번호 수정");
		pwChange.setPrefSize(200, 40);
		
		change = new Button("수정");
		change.setPrefSize(200, 40);
		
		unregister = new Button("회원 탈퇴");
		unregister.setPrefSize(300, 30);
		
		goBack=new Button("뒤로가기");
		goBack.setPrefSize(300, 30);
		goBack.setOnAction(e->{
			scene.setRoot(user);
			primaryStage.setScene(scene);
			primaryStage.setTitle("관리자 모드");
		});
		
		FlowPane nameflowpane = new FlowPane();
		nameflowpane.setPadding(new Insets(10,10,10,10));
		nameflowpane.setAlignment(Pos.CENTER);
		nameflowpane.setColumnHalignment(HPos.CENTER);
		nameflowpane.setPrefSize(700, 40);
		nameflowpane.setHgap(10);
		nameflowpane.getChildren().add(name);
		nameflowpane.getChildren().add(nametf);
		
		FlowPane idflowpane = new FlowPane();
		idflowpane.setPadding(new Insets(10,10,10,10));
		idflowpane.setAlignment(Pos.CENTER);
		idflowpane.setColumnHalignment(HPos.CENTER);
		idflowpane.setPrefSize(700, 40);
		idflowpane.setHgap(10);
		idflowpane.getChildren().add(id);
		idflowpane.getChildren().add(idtf);
		
		FlowPane emailflowpane = new FlowPane();
		emailflowpane.setPadding(new Insets(10,10,10,10));
		emailflowpane.setAlignment(Pos.CENTER);
		emailflowpane.setColumnHalignment(HPos.CENTER);
		emailflowpane.setPrefSize(700, 40);
		emailflowpane.setHgap(10);
		emailflowpane.getChildren().add(email);
		emailflowpane.getChildren().add(emailtf);
		
		
		FlowPane pointflowpane = new FlowPane();
		pointflowpane.setPadding(new Insets(10,10,10,10));
		pointflowpane.setAlignment(Pos.CENTER);
		pointflowpane.setColumnHalignment(HPos.CENTER);
		pointflowpane.setPrefSize(700, 40);
		pointflowpane.setHgap(10);
		pointflowpane.getChildren().add(point);
		pointflowpane.getChildren().add(pointtf);
		
		FlowPane updateflowpane = new FlowPane();
		updateflowpane.setPadding(new Insets(10,10,10,10));
		updateflowpane.setAlignment(Pos.CENTER);
		updateflowpane.setColumnHalignment(HPos.CENTER);
		updateflowpane.setPrefSize(700, 40);
		updateflowpane.setHgap(10);
		updateflowpane.getChildren().add(pwChange);
		updateflowpane.getChildren().add(change);
		
		FlowPane centerflowpane = new FlowPane();
		centerflowpane.setPadding(new Insets(10,10,10,10));
		centerflowpane.setAlignment(Pos.CENTER);
		centerflowpane.setColumnHalignment(HPos.CENTER);
		centerflowpane.setPrefSize(700, 600);
		centerflowpane.setVgap(10);
		centerflowpane.getChildren().add(nameflowpane);
		centerflowpane.getChildren().add(idflowpane);
		centerflowpane.getChildren().add(emailflowpane);
		centerflowpane.getChildren().add(pointflowpane);
		centerflowpane.getChildren().add(updateflowpane);
		
		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10,10,10,10));
		flowpane.setAlignment(Pos.CENTER);
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setPrefSize(700, 40);
		flowpane.setHgap(10);
		flowpane.getChildren().add(unregister);
		flowpane.getChildren().add(goBack);
		
		
		
		root.setCenter(centerflowpane);
		root.setBottom(flowpane);
		
		return root;
	}
}
