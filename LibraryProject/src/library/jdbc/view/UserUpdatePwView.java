package library.jdbc.view;

import javafx.geometry.HPos;
import javafx.geometry.Orientation;
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
import library.jdbc.controller.CheckCanUpdatePWController;

public class UserUpdatePwView {
	private BorderPane user=null;
	private Scene scene = null;
	private Stage primaryStage = null;
	
	private Text notice;
	private Text pw;
	private Text pwcheck;
	
	private TextField pwtf;
	private TextField pwchecktf;
	
	private Button apply;
	private Button goBack;
	
	private String id="";
	
	public UserUpdatePwView(BorderPane user, Scene scene, Stage primaryStage,String id) {
		super();
		this.user = user;
		this.scene = scene;
		this.primaryStage = primaryStage;
		this.id=id;
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
		
		notice = new Text("새로운 비밀번호를 입력해주세요, 최대 20자 까지 가능합니다.");
		notice.setWrappingWidth(700);
		notice.setTextAlignment(TextAlignment.CENTER);
		notice.setFont(Font.font(null, FontWeight.BOLD, 20));
		
		pw = new Text("비밀번호");
		pw.setWrappingWidth(50);
		
		pwtf = new TextField();
		pwtf.setPrefSize(200, 40);
		
		pwcheck = new Text("비밀번호확인");
		pwcheck.setWrappingWidth(50);
		
		pwchecktf = new TextField();
		pwchecktf.setPrefSize(200, 40);
		pwchecktf.setOnAction(e->{
			CheckCanUpdatePWController controller = new CheckCanUpdatePWController();
			if(controller.getResult(id,pwtf.getText(),pwchecktf.getText()))
			{
				ButtonType type = new ButtonType("OK",ButtonData.OK_DONE);
				Dialog<ButtonType> dialog = new Dialog<>();
				dialog.setTitle("알림");
				dialog.setContentText("성공적으로 변경하였습니다!!!!");
				dialog.getDialogPane().setMinSize(700, 200);
				dialog.getDialogPane().getButtonTypes().add(type);
				dialog.showAndWait();
				scene.setRoot(user);
				primaryStage.setScene(scene);
			}else
			{
				showDialog("알림", "비밀번호 변경 실패 입력 정보를 다시 확인해주세요");
			}
		});
		
		goBack=new Button("뒤로가기");
		goBack.setPrefSize(300, 40);
		goBack.setOnAction(e->{
			scene.setRoot(user);
			primaryStage.setScene(scene);
			primaryStage.setTitle("사용자 모드");
		});
		
		
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
		
		
		apply = new Button("변경");
		apply.setPrefSize(300, 40);
		apply.setOnAction(e -> {

			CheckCanUpdatePWController controller = new CheckCanUpdatePWController();
			if(controller.getResult(id,pwtf.getText(),pwchecktf.getText()))
			{
				ButtonType type = new ButtonType("OK",ButtonData.OK_DONE);
				Dialog<ButtonType> dialog = new Dialog<>();
				dialog.setTitle("알림");
				dialog.setContentText("성공적으로 변경하였습니다!!!!");
				dialog.getDialogPane().setMinSize(700, 200);
				dialog.getDialogPane().getButtonTypes().add(type);
				dialog.showAndWait();
				scene.setRoot(user);
				primaryStage.setScene(scene);
			}else
			{
				showDialog("알림", "비밀번호 변경 실패 입력 정보를 다시 확인해주세요");
			}
		});
		
		
		
		
		FlowPane bottomflowpane = new FlowPane();
		bottomflowpane.setAlignment(Pos.CENTER);
		bottomflowpane.setColumnHalignment(HPos.CENTER);
		bottomflowpane.setPrefSize(700, 100);
		bottomflowpane.setHgap(50);
		bottomflowpane.getChildren().add(apply);
		bottomflowpane.getChildren().add(goBack);
		
		FlowPane flowpane = new FlowPane();
		flowpane.setAlignment(Pos.CENTER);
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setPrefSize(700, 400);
		flowpane.setVgap(10);
		flowpane.setOrientation(Orientation.VERTICAL);
		flowpane.getChildren().add(notice);
		flowpane.getChildren().add(pwflowpane);
		flowpane.getChildren().add(pwcheckflowpane);
		
		
		root.setCenter(flowpane);
		root.setBottom(bottomflowpane);
		
		return root;
	}
}
