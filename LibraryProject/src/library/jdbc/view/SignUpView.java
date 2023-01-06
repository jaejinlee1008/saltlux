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
	private Text checkid;
	private Text checkPwIsSame;
	
	private Text idnotice;
	private Text pwnotice;
	
	private TextField nametf;
	private TextField idtf;
	private TextField pwtf;
	private TextField pwchecktf;
	private PasswordField pwpwf;
	private PasswordField pwcheckpwf;
	private TextField emailtf;
	
	private Hyperlink showpw;
	private Hyperlink showpwcheck;
	
	private Button signup;
	private Button goBack;
	private String inputpw;
	private String inputpwcheck;
	private String finalpw;
	private String finalpwcheck;
	
	private boolean showclicked;
	
	private void setpw()
	{
		if(pwtf.getText().isEmpty())
		{
			finalpw = pwpwf.getText();
		}else
		{
			finalpw = pwtf.getText();
		}
	}
	
	private void setpwcheck()
	{
		if(pwchecktf.getText().isEmpty())
		{
			finalpwcheck=pwcheckpwf.getText();
		}else
		{
			finalpwcheck=pwchecktf.getText();
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
		
		idnotice = new Text("최대 15자");
		idnotice.setTextAlignment(TextAlignment.LEFT);
		idnotice.setWrappingWidth(50);
		
		pwnotice = new Text("최대 20자");
		pwnotice.setTextAlignment(TextAlignment.LEFT);
		pwnotice.setWrappingWidth(70);
		
		name = new Text("이름");
		name.setWrappingWidth(50);
		
		nametf = new TextField();
		nametf.setPrefSize(200, 30);
		nametf.setPromptText("이름을 입력해주세요.");
		
		id = new Text("ID");
		id.setWrappingWidth(50);
		
		checkid = new Text("아이디를 입력해주세요.");
		checkid.setFont(Font.font(10));
		checkid.setTextAlignment(TextAlignment.CENTER);
		checkid.setWrappingWidth(700);
		
		checkPwIsSame = new Text("비밀번호가 일치하지 않습니다.");
		checkPwIsSame.setFont(Font.font(10));
		checkPwIsSame.setTextAlignment(TextAlignment.CENTER);
		checkPwIsSame.setWrappingWidth(700);
		
		idtf = new TextField();
		idtf.setPrefSize(200, 30);
		idtf.setPromptText("아이디를 입력해주세요.");
		idtf.setOnKeyTyped(e->{
			CheckCanSignUPController con = new CheckCanSignUPController();
			if(con.getResult(idtf.getText()))
			{
				checkid.setText("사용가능한 아이디입니다.");
			}else
			{
				checkid.setText("사용불가능한 아이디입니다.");
			}
		});
		
		pw = new Text("비밀번호");
		pw.setWrappingWidth(50);
		
		pwtf = new TextField();
		pwtf.setPrefSize(200, 30);
		
		pwpwf = new PasswordField();
		pwpwf.setPrefSize(200, 30);
		pwpwf.setPromptText("비밀번호를 입력해주세요");
		
		pwcheck = new Text("비밀번호확인");
		pwcheck.setWrappingWidth(50);
		
		pwchecktf=new TextField();
		pwchecktf.setPrefSize(200, 30);
		pwchecktf.setOnKeyTyped(e->{
			setpw();
			if(pwchecktf.getText().equals(finalpw))
			{
				checkPwIsSame.setText("비밀번호가 일치합니다.");
			}else
			{
				checkPwIsSame.setText("비밀번호가 일치하지 않습니다.");
			}
		});
		
		pwcheckpwf = new PasswordField();
		pwcheckpwf.setPrefSize(200, 30);
		pwcheckpwf.setPromptText("비밀번호를 재입력해주세요.");
		pwcheckpwf.setOnKeyTyped(e->{
			setpw();
			if(pwcheckpwf.getText().equals(finalpw))
			{
				checkPwIsSame.setText("비밀번호가 일치합니다.");
			}else
			{
				checkPwIsSame.setText("비밀번호가 일치하지 않습니다.");
			}
		});
		
		
		email = new Text("email");
		email.setWrappingWidth(50);
		
		emailtf = new TextField();
		emailtf.setPrefSize(200, 30);
		emailtf.setPromptText("이메일을 입력해주세요.");
		emailtf.setOnAction(e->{
			setpw();
			setpwcheck();
			signUp(nametf.getText(),idtf.getText(),finalpw,finalpwcheck,emailtf.getText());
		});
		
		showpw = new Hyperlink("show");
		showpw.setPrefSize(50, 50);
		showpw.setAlignment(Pos.CENTER_LEFT);
		
		showpwcheck = new Hyperlink("show");
		showpwcheck.setPrefSize(50, 50);
		showpwcheck.setAlignment(Pos.CENTER_LEFT);
		
		
		FlowPane nameflowpane = new FlowPane();
		nameflowpane.setPadding(new Insets(0,0,0,150));
		nameflowpane.setAlignment(Pos.CENTER_LEFT);
		nameflowpane.setColumnHalignment(HPos.CENTER);
		nameflowpane.setPrefSize(700, 40);
		nameflowpane.setHgap(10);
		nameflowpane.getChildren().add(name);
		nameflowpane.getChildren().add(nametf);
		
		FlowPane idflowpane = new FlowPane();
		idflowpane.setPadding(new Insets(0,0,0,150));
		idflowpane.setAlignment(Pos.CENTER_LEFT);
		idflowpane.setColumnHalignment(HPos.CENTER);
		idflowpane.setPrefSize(700, 40);
		idflowpane.setHgap(10);
		idflowpane.getChildren().add(id);
		idflowpane.getChildren().add(idtf);
		idflowpane.getChildren().add(idnotice);
		
		FlowPane pwflowpane = new FlowPane();
		pwflowpane.setPadding(new Insets(0,0,0,150));
		pwflowpane.setAlignment(Pos.CENTER_LEFT);
		pwflowpane.setColumnHalignment(HPos.CENTER);
		pwflowpane.setPrefSize(700, 40);
		pwflowpane.setHgap(10);
		pwflowpane.getChildren().add(pw);
		pwflowpane.getChildren().add(pwpwf);
		pwflowpane.getChildren().add(pwnotice);
		pwflowpane.getChildren().add(showpw);
		
		
		FlowPane pwcheckflowpane = new FlowPane();
		pwcheckflowpane.setPadding(new Insets(0,0,0,150));
		pwcheckflowpane.setAlignment(Pos.CENTER_LEFT);
		pwcheckflowpane.setColumnHalignment(HPos.CENTER);
		pwcheckflowpane.setPrefSize(700, 40);
		pwcheckflowpane.setHgap(10);
		pwcheckflowpane.getChildren().add(pwcheck);
		pwcheckflowpane.getChildren().add(pwcheckpwf);
		pwcheckflowpane.getChildren().add(showpwcheck);
		
		FlowPane emailflowpane = new FlowPane();
		emailflowpane.setPadding(new Insets(0,0,0,150));
		emailflowpane.setAlignment(Pos.CENTER_LEFT);
		emailflowpane.setColumnHalignment(HPos.CENTER);
		emailflowpane.setPrefSize(700, 40);
		emailflowpane.setHgap(10);
		emailflowpane.getChildren().add(email);
		emailflowpane.getChildren().add(emailtf);
		
		showpw.setOnAction(e->{
			inputpw = pwpwf.getText();
			pwflowpane.getChildren().remove(1);
			pwflowpane.getChildren().add(1, pwtf);
			pwtf.setText(inputpw);
			pwtf.requestFocus();
		});
		
		showpwcheck.setOnAction(e->{
			inputpwcheck = pwcheckpwf.getText();
			pwcheckflowpane.getChildren().remove(1);
			pwcheckflowpane.getChildren().add(1, pwchecktf);
			pwchecktf.setText(inputpwcheck);
			pwchecktf.requestFocus();
		});
		
		signup = new Button("가입");
		signup.setPrefSize(150, 70);
		signup.setOnAction(e -> {
			setpw();
			setpwcheck();
			signUp(nametf.getText(),idtf.getText(),finalpw,finalpwcheck,emailtf.getText());
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
		flowpane.setPrefSize(700, 400);
		flowpane.setVgap(10);
		flowpane.setOrientation(Orientation.VERTICAL);
		flowpane.getChildren().add(notice);
		flowpane.getChildren().add(nameflowpane);
		flowpane.getChildren().add(idflowpane);
		flowpane.getChildren().add(checkid);
		flowpane.getChildren().add(pwflowpane);
		flowpane.getChildren().add(pwcheckflowpane);
		flowpane.getChildren().add(checkPwIsSame);
		flowpane.getChildren().add(emailflowpane);
		
		
		root.setCenter(flowpane);
		root.setBottom(bottomflowpane);
		
		return root;
	}
}
