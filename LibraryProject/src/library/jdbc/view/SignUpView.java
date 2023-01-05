package library.jdbc.view;

import java.util.Optional;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
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
import library.jdbc.controller.CheckCanSignUPController;
import library.jdbc.controller.SignUPController;

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
	
	private Text notice;
	private Text name;
	private Text id;
	private Text pw;
	private Text pwcheck;
	private Text email;
	
	private Text idnotice;
	private Text pwnotice;
	
	private TextField nametf;
	private TextField idtf;
	private TextField pwtf;
	private TextField pwchecktf;
	private TextField emailtf;
	
	private Button signup;
	private Button goBack;
	
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
	
	private void signUp(String name, String id, String pw, String pwcheck, String email)
	{
		CheckCanSignUPController controller = new CheckCanSignUPController();
		if(controller.getResult(name,id,pw,pwcheck,email))
		{
			SignUPController signupcon = new SignUPController();
			signupcon.setResult(name,id,pw,email);
			
			ButtonType type = new ButtonType("OK",ButtonData.OK_DONE);
			Dialog<ButtonType> dialog = new Dialog<>();
			dialog.setTitle("알림");
			dialog.setContentText("성공적으로 가입하였습니다!!!!");
			dialog.getDialogPane().setMinSize(700, 200);
			dialog.getDialogPane().getButtonTypes().add(type);
			try {
				Optional<ButtonType> result = dialog.showAndWait();
				
			    if(result.get().getText().equals("OK"))
			    {
			    	scene.setRoot(logIn);
					primaryStage.setScene(scene);
			    }
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}else
		{
			showDialog("알림", "가입 실패 입력 정보를 다시 확인해주세요");
		}
	}
	
	public BorderPane getSignUp()
	{
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		notice = new Text("회원가입 화면");
		notice.setWrappingWidth(700);
		notice.setTextAlignment(TextAlignment.CENTER);
		notice.setFont(Font.font(null, FontWeight.BOLD, 20));
		
		idnotice = new Text("ID를 15자 이내로 입력해주세요.");
		idnotice.setWrappingWidth(200);
		
		pwnotice = new Text("비밀번호를 20자 이내로 입력해주세요.");
		pwnotice.setWrappingWidth(200);
		
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
		emailtf.setOnAction(e->{
			signUp(nametf.getText(),idtf.getText(),pwtf.getText(),pwchecktf.getText(),emailtf.getText());
			
		});
		
		FlowPane nameflowpane = new FlowPane();
		nameflowpane.setPadding(new Insets(0,0,0,150));
		nameflowpane.setAlignment(Pos.CENTER_LEFT);
		nameflowpane.setColumnHalignment(HPos.CENTER);
		nameflowpane.setPrefSize(700, 60);
		nameflowpane.setHgap(10);
		nameflowpane.getChildren().add(name);
		nameflowpane.getChildren().add(nametf);
		
		FlowPane idflowpane = new FlowPane();
		idflowpane.setPadding(new Insets(0,0,0,150));
		idflowpane.setAlignment(Pos.CENTER_LEFT);
		idflowpane.setColumnHalignment(HPos.CENTER);
		idflowpane.setPrefSize(700, 60);
		idflowpane.setHgap(10);
		idflowpane.getChildren().add(id);
		idflowpane.getChildren().add(idtf);
		idflowpane.getChildren().add(idnotice);
		
		FlowPane pwflowpane = new FlowPane();
		pwflowpane.setPadding(new Insets(0,0,0,150));
		pwflowpane.setAlignment(Pos.CENTER_LEFT);
		pwflowpane.setColumnHalignment(HPos.CENTER);
		pwflowpane.setPrefSize(700, 60);
		pwflowpane.setHgap(10);
		pwflowpane.getChildren().add(pw);
		pwflowpane.getChildren().add(pwtf);
		pwflowpane.getChildren().add(pwnotice);
		
		FlowPane pwcheckflowpane = new FlowPane();
		pwcheckflowpane.setPadding(new Insets(0,0,0,150));
		pwcheckflowpane.setAlignment(Pos.CENTER_LEFT);
		pwcheckflowpane.setColumnHalignment(HPos.CENTER);
		pwcheckflowpane.setPrefSize(700, 60);
		pwcheckflowpane.setHgap(10);
		pwcheckflowpane.getChildren().add(pwcheck);
		pwcheckflowpane.getChildren().add(pwchecktf);
		
		FlowPane emailflowpane = new FlowPane();
		emailflowpane.setPadding(new Insets(0,0,0,150));
		emailflowpane.setAlignment(Pos.CENTER_LEFT);
		emailflowpane.setColumnHalignment(HPos.CENTER);
		emailflowpane.setPrefSize(700, 60);
		emailflowpane.setHgap(10);
		emailflowpane.getChildren().add(email);
		emailflowpane.getChildren().add(emailtf);
		
		signup = new Button("가입");
		signup.setPrefSize(150, 70);
		signup.setOnAction(e -> {
			signUp(nametf.getText(),idtf.getText(),pwtf.getText(),pwchecktf.getText(),emailtf.getText());
		});
		
		goBack=new Button("뒤로가기");
		goBack.setPrefSize(150, 70);
		goBack.setOnAction(e->{
			scene.setRoot(logIn);
			primaryStage.setScene(scene);
			primaryStage.setTitle("사용자 모드");
		});
		
		
		FlowPane bottomflowpane = new FlowPane();
		bottomflowpane.setAlignment(Pos.CENTER);
		bottomflowpane.setColumnHalignment(HPos.CENTER);
		bottomflowpane.setPrefSize(700, 100);
		bottomflowpane.setHgap(200);
		bottomflowpane.getChildren().add(signup);
		bottomflowpane.getChildren().add(goBack);
		
		FlowPane flowpane = new FlowPane();
		flowpane.setAlignment(Pos.CENTER);
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setPrefSize(700, 500);
		flowpane.setVgap(10);
		flowpane.setOrientation(Orientation.VERTICAL);
		flowpane.getChildren().add(notice);
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
