package library.jdbc.view;

import java.text.SimpleDateFormat;
import java.util.Optional;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import library.jdbc.VO.UserVO;
import library.jdbc.controller.UserDeleteController;
import library.jdbc.controller.UserInfoUpdateController;

public class UserInfoSearchAndUpdateView {
	private BorderPane login=null;
	private BorderPane user=null;
	private Scene scene = null;
	private Stage primaryStage = null;
	private Button goBack;
	private Button pwChange;
	private Button change;
	private Button unregister;
	
	
	private Text notice;
	private Text name;
	private Text id;
	private Text email;
	private Text indate;
	private Text point;
	private TextField nametf;
	private TextField idtf;
	private TextField emailtf;
	private TextField indatetf;	
	private TextField pointtf;
	
	private UserVO uservo=null;

	public UserInfoSearchAndUpdateView(BorderPane login, BorderPane user, Scene scene, Stage primaryStage, UserVO uservo) {
		super();
		this.login=login;
		this.user = user;
		this.scene = scene;
		this.primaryStage = primaryStage;
		this.uservo=uservo;
	}
	
	public void showDialog(String title, String text)
	{
		ButtonType type = new ButtonType("OK",ButtonData.OK_DONE);
		Dialog<ButtonType> dialog = new Dialog<>();
		dialog.setTitle(title);
		dialog.setContentText(text);
		dialog.getDialogPane().setMinSize(700, 200);
		dialog.getDialogPane().getButtonTypes().add(type);
		dialog.show();
	}
	
	public BorderPane getRoot()
	{
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		
		notice = new Text("개인정보 수정 및 조회");
		notice.setWrappingWidth(700);
		notice.setTextAlignment(TextAlignment.CENTER);
		notice.setFont(Font.font(null, FontWeight.BOLD, 30));
		
		name = new Text("이름");
		name.setWrappingWidth(50);
		
		nametf = new TextField();
		nametf.setPrefSize(200, 30);
		nametf.setDisable(true);
		nametf.setText(uservo.getName());
		
		id = new Text("ID");
		id.setWrappingWidth(50);
		
		idtf = new TextField();
		idtf.setPrefSize(200, 30);
		idtf.setDisable(true);
		idtf.setText(uservo.getID());
		
		email = new Text("email");
		email.setWrappingWidth(50);
		
		emailtf = new TextField();
		emailtf.setPrefSize(200, 30);
		emailtf.setText(uservo.getEmail());
		emailtf.setOnMouseClicked(e->{
			emailtf.clear();
		});
		
		indate = new Text("가입일");
		indate.setWrappingWidth(50);
		
		indatetf = new TextField();
		indatetf.setPrefSize(200, 30);
		indatetf.setDisable(true);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(uservo.getIndate());
		indatetf.setText(date);
		
		point = new Text("point");
		point.setWrappingWidth(50);
		
		pointtf = new TextField();
		pointtf.setPrefSize(200, 30);
		pointtf.setDisable(true);
		pointtf.setText(Integer.toString(uservo.getPoint()));
		
		pwChange = new Button("비밀번호 수정");
		pwChange.setPrefSize(200, 40);
		pwChange.setOnAction(e->{
			UserUpdatePwView userupdatepwview = new UserUpdatePwView(root, scene, primaryStage, uservo.getID());
			scene.setRoot(userupdatepwview.getRoot());
			primaryStage.setScene(scene);
			primaryStage.setTitle("개인정보 수정 및 조회");
		});
		
		change = new Button("수정");
		change.setPrefSize(200, 40);
		change.setOnAction(e->{
			UserInfoUpdateController controller = new UserInfoUpdateController();
			
			if(controller.setResult(uservo.getID(),emailtf.getText()))
			{
				showDialog("알림", "회원 정보를 성공적으로 수정하였습니다!!!!");
				
			}else
			{
				showDialog("알림", "회원 정보 수정 실패 입력값을 다시 확인해주세요");
			}
		});
		
		unregister = new Button("회원 탈퇴");
		unregister.setPrefSize(300, 30);
		unregister.setOnAction(e->{
			ButtonType type = new ButtonType("OK",ButtonData.OK_DONE);
			Dialog<ButtonType> dialog = new Dialog<>();
			dialog.setTitle("알림");
			dialog.setContentText("정말 회원탈퇴를 하시겠습니까??? really??");
			dialog.getDialogPane().setMinSize(700, 200);
			dialog.getDialogPane().getButtonTypes().add(type);
			try {
				Optional<ButtonType> result = dialog.showAndWait();
				
			    if(result.get().getText().equals("OK"))
			    {
			    	
			    	UserDeleteController controller = new UserDeleteController();
			    	controller.setResult(uservo.getID());
			    	showDialog("알림", "회원 탈퇴 성공");
					scene.setRoot(login);
					primaryStage.setScene(scene);
			    }else
			    {
			    	showDialog("알림", "회원 탈퇴 실패");
			    }
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			
		});
		
		goBack=new Button("뒤로가기");
		goBack.setPrefSize(300, 30);
		goBack.setOnAction(e->{
			scene.setRoot(user);
			primaryStage.setScene(scene);
			primaryStage.setTitle("사용자 모드");
		});
		
		FlowPane nameflowpane = new FlowPane();
		nameflowpane.setPadding(new Insets(10,10,10,10));
		nameflowpane.setAlignment(Pos.CENTER);
		nameflowpane.setColumnHalignment(HPos.CENTER);
		nameflowpane.setPrefSize(700, 30);
		nameflowpane.setHgap(10);
		nameflowpane.getChildren().add(name);
		nameflowpane.getChildren().add(nametf);
		
		FlowPane idflowpane = new FlowPane();
		idflowpane.setPadding(new Insets(10,10,10,10));
		idflowpane.setAlignment(Pos.CENTER);
		idflowpane.setColumnHalignment(HPos.CENTER);
		idflowpane.setPrefSize(700, 30);
		idflowpane.setHgap(10);
		idflowpane.getChildren().add(id);
		idflowpane.getChildren().add(idtf);
		
		FlowPane emailflowpane = new FlowPane();
		emailflowpane.setPadding(new Insets(10,10,10,10));
		emailflowpane.setAlignment(Pos.CENTER);
		emailflowpane.setColumnHalignment(HPos.CENTER);
		emailflowpane.setPrefSize(700, 30);
		emailflowpane.setHgap(10);
		emailflowpane.getChildren().add(email);
		emailflowpane.getChildren().add(emailtf);
		
		FlowPane indateflowpane = new FlowPane();
		indateflowpane.setPadding(new Insets(10,10,10,10));
		indateflowpane.setAlignment(Pos.CENTER);
		indateflowpane.setColumnHalignment(HPos.CENTER);
		indateflowpane.setPrefSize(700, 30);
		indateflowpane.setHgap(10);
		indateflowpane.getChildren().add(indate);
		indateflowpane.getChildren().add(indatetf);
		
		FlowPane pointflowpane = new FlowPane();
		pointflowpane.setPadding(new Insets(10,10,10,10));
		pointflowpane.setAlignment(Pos.CENTER);
		pointflowpane.setColumnHalignment(HPos.CENTER);
		pointflowpane.setPrefSize(700, 30);
		pointflowpane.setHgap(10);
		pointflowpane.getChildren().add(point);
		pointflowpane.getChildren().add(pointtf);
		
		FlowPane updateflowpane = new FlowPane();
		updateflowpane.setPadding(new Insets(10,10,10,10));
		updateflowpane.setAlignment(Pos.CENTER);
		updateflowpane.setColumnHalignment(HPos.CENTER);
		updateflowpane.setPrefSize(700, 30);
		updateflowpane.setHgap(20);
		updateflowpane.getChildren().add(pwChange);
		updateflowpane.getChildren().add(change);
		
		FlowPane centerflowpane = new FlowPane();
		centerflowpane.setPadding(new Insets(10,10,10,10));
		centerflowpane.setAlignment(Pos.CENTER);
		centerflowpane.setColumnHalignment(HPos.CENTER);
		centerflowpane.setPrefSize(700, 400);
		centerflowpane.setVgap(10);
		centerflowpane.getChildren().add(notice);
		centerflowpane.getChildren().add(nameflowpane);
		centerflowpane.getChildren().add(idflowpane);
		centerflowpane.getChildren().add(emailflowpane);
		centerflowpane.getChildren().add(indateflowpane);
		centerflowpane.getChildren().add(pointflowpane);
		centerflowpane.getChildren().add(updateflowpane);
		
		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10,10,10,10));
		flowpane.setAlignment(Pos.CENTER);
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setPrefSize(700, 100);
		flowpane.setHgap(10);
		flowpane.getChildren().add(unregister);
		flowpane.getChildren().add(goBack);
		
		
		
		root.setCenter(centerflowpane);
		root.setBottom(flowpane);
		
		return root;
	}
}
