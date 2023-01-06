package library.jdbc.view;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import library.jdbc.VO.LogVO;
import library.jdbc.VO.RentVO;
import library.jdbc.VO.UserVO;
import library.jdbc.controller.GetNotReturnedBookListController;
import library.jdbc.controller.LogInController;
import library.jdbc.controller.UserInfoListController;
import library.jdbc.controller.UserInfoSearchController;
import library.jdbc.controller.UserRentLogSearchController;

public class LogInView extends Application{
	
	private Text notice;
	private Text id;
	private Text pw;
	private TextField idtf;
	private TextField pwtf;
	private PasswordField pwf;
	private Button signUp;
	private Button logIn;
	private Hyperlink showpw;
	
	private BorderPane root = null;
	private Scene scene=null;
	
	public boolean loginCheck(String id, String pw)
	{
		LogInController controller = new LogInController();
		boolean b = controller.getResult(id, pw);
		return b;
	}
	
	private void logIn(Stage primaryStage,Scene scene,BorderPane root,String id, String pw)
	{
		if(id.equals("admin") && pw.equals("admin1234"))
		{
			UserInfoListController controller = new UserInfoListController();
			ObservableList<UserVO> userlist = controller.getResult();
			GetNotReturnedBookListController con = new GetNotReturnedBookListController();
			ObservableList<RentVO> rentlist = con.getResult();
			AdministratorView administratorview = new AdministratorView(primaryStage,scene,root,userlist,rentlist);
			scene.setRoot(administratorview.getRoot());
			primaryStage.setScene(scene);
			primaryStage.setTitle("관리자 모드");
		} else if(loginCheck(id, pw))
		{
			UserRentLogSearchController logcon = new UserRentLogSearchController();
			ObservableList<LogVO> loglist = logcon.getResult(idtf.getText());
			UserInfoSearchController controller = new UserInfoSearchController();
			UserVO user = controller.getResult(idtf.getText());
			UserModeView usermodeview = new UserModeView(primaryStage, scene, root,id,loglist,user);
			scene.setRoot(usermodeview.getRoot());
			primaryStage.setScene(scene);
			primaryStage.setTitle("사용자 모드");
		}else
		{
			showDialog("알림", "로그인 정보가 잘못되었습니다. 다시 확인해주세요");
		}
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
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		root = new BorderPane();
		root.setPrefSize(700, 500);
		
		notice = new Text("로그인 화면");
		notice.setWrappingWidth(700);
		notice.setTextAlignment(TextAlignment.CENTER);
		notice.setFont(Font.font(null, FontWeight.BOLD, 20));
		
		id = new Text("ID");
		id.setWrappingWidth(50);
		
		pw = new Text("비밀번호");
		pw.setWrappingWidth(50);
		
		idtf = new TextField();
		idtf.setPrefSize(200, 40);
		idtf.setPromptText("아이디");
		
		pwtf = new TextField();
		pwtf.setPrefSize(200, 40);
		pwtf.setOnAction(e->{
			logIn(primaryStage, scene, root, idtf.getText(), pwtf.getText());
		});
		
		
		pwf = new PasswordField();
		pwf.setPrefSize(200, 40);
		pwf.setPromptText("비밀번호");
		pwf.setOnAction(e->{
			
			logIn(primaryStage, scene, root, idtf.getText(), pwf.getText());
			
		});
		
		showpw = new Hyperlink("show");
		showpw.setPrefSize(50, 50);
		showpw.setAlignment(Pos.CENTER_LEFT);
		
		
		FlowPane idflowpane = new FlowPane();
		idflowpane.setPadding(new Insets(0,0,0,200));
		idflowpane.setAlignment(Pos.CENTER_LEFT);
		idflowpane.setColumnHalignment(HPos.CENTER);
		idflowpane.setPrefSize(700, 60);
		idflowpane.setHgap(10);
		idflowpane.getChildren().add(id);
		idflowpane.getChildren().add(idtf);
		
		
		FlowPane pwflowpane = new FlowPane();
		pwflowpane.setPadding(new Insets(0,0,0,200));
		pwflowpane.setAlignment(Pos.CENTER_LEFT);
		pwflowpane.setColumnHalignment(HPos.CENTER);
		pwflowpane.setPrefSize(700, 60);
		pwflowpane.setHgap(10);
		pwflowpane.getChildren().add(pw);
		pwflowpane.getChildren().add(pwf);
		pwflowpane.getChildren().add(showpw);
		
		showpw.setOnAction(e->{
			String inputpw = pwf.getText();
			pwflowpane.getChildren().remove(1);
			pwflowpane.getChildren().add(1, pwtf);
			pwtf.setText(inputpw);
			pwtf.requestFocus();
		});
		
		signUp = new Button("회원가입");
		signUp.setPrefSize(150, 70);
		signUp.setOnAction(e -> {
			SignUpView signupview = new SignUpView(primaryStage,scene,root);
			scene.setRoot(signupview.getSignUp());
			primaryStage.setScene(scene);
			primaryStage.setTitle("회원가입 화면");
		});
		
		
		logIn = new Button("로그인");
		logIn.setPrefSize(150, 70);
		logIn.setOnAction(e -> {
			if(pwtf.getText().isEmpty())
			{
				logIn(primaryStage, scene, root, idtf.getText(), pwf.getText());
			}else
			{
				logIn(primaryStage, scene, root, idtf.getText(), pwtf.getText());
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
		flowpane.getChildren().add(notice);
		flowpane.getChildren().add(idflowpane);
		flowpane.getChildren().add(pwflowpane);
		
		root.setCenter(flowpane);
		root.setBottom(bottomflowpane);
		
		scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("재진이의 도서 대여 및 반납 프로그램~!~!~!");
		primaryStage.setOnCloseRequest(e->{
			
		});
		
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
}
