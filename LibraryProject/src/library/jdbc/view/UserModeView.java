package library.jdbc.view;

import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import library.jdbc.VO.LogVO;
import library.jdbc.VO.RentVO;
import library.jdbc.VO.UserVO;
import library.jdbc.controller.UserInfoSearchController;
import library.jdbc.controller.UserRentInfoSearchController;
import library.jdbc.controller.UserRentLogSearchController;


public class UserModeView {
	private BorderPane logIn=null;
	private Stage primaryStage=null;
	private Scene scene=null;
	private String ID="";
	public UserModeView(Stage primaryStage, Scene scene, BorderPane root,String ID) {
		this.primaryStage=primaryStage;
		this.scene = scene;
		this.logIn=root;
		this.ID = ID;
	}
	
	private Button rentInfoSearch;
	private Button userInfoSearchAndUpdate;
	private Button searchBook;
	private Button logOut;
	private Dialog<String> dialog;
	public BorderPane getRoot()
	{
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		rentInfoSearch = new Button("대여 내역 조회");
		rentInfoSearch.setPrefSize(150, 70);
		rentInfoSearch.setOnAction(e -> {
			UserRentInfoSearchController controller = new UserRentInfoSearchController();
			ObservableList<RentVO> list =  controller.getResult(ID);
			if(list==null)
			{
				ButtonType type = new ButtonType("OK",ButtonData.OK_DONE);
				dialog = new Dialog<>();
				dialog.setTitle("알림!!");
				dialog.setContentText("대여 내역이 없습니다.");
				dialog.getDialogPane().setMinSize(700, 200);
				dialog.getDialogPane().getButtonTypes().add(type);
				dialog.show();
			}
			UserRentLogSearchController logcon = new UserRentLogSearchController();
			ObservableList<LogVO> loglist = logcon.getResult(ID);
			UserRentInfoView userrentinfoview = new UserRentInfoView(root, scene, primaryStage, loglist);
			scene.setRoot(userrentinfoview.getRoot());
			primaryStage.setScene(scene);
			primaryStage.setTitle("대여 내역 조회");
		});
		
		userInfoSearchAndUpdate = new Button("개인정보 수정 및 조회");
		userInfoSearchAndUpdate.setPrefSize(150, 70);
		userInfoSearchAndUpdate.setOnAction(e -> {
			UserInfoSearchController controller = new UserInfoSearchController();
			UserVO user = controller.getResult(ID);
			UserInfoSearchAndUpdateView userinfosearchandupdateview = new UserInfoSearchAndUpdateView(root, scene, primaryStage, user.getName(), user.getID(), user.getEmail(), user.getPoint());
			scene.setRoot(userinfosearchandupdateview.getRoot());
			primaryStage.setScene(scene);
			primaryStage.setTitle("개인정보 수정 및 조회");
		});
		
		searchBook = new Button("도서 검색");
		searchBook.setPrefSize(150, 70);
		searchBook.setOnAction(e -> {
			UserInfoSearchController controller = new UserInfoSearchController();
			UserVO user = controller.getResult(ID);
			UserModeBookSearchView usermodebooksearchview = new UserModeBookSearchView(root, scene, primaryStage,ID,user.getName());
			scene.setRoot(usermodebooksearchview.getRoot());
			primaryStage.setScene(scene);
			primaryStage.setTitle("도서 검색");
		});
		
		logOut = new Button("로그아웃");
		logOut.setPrefSize(300, 70);
		logOut.setOnAction(e -> {
			scene.setRoot(logIn);
			primaryStage.setScene(scene);
		});
		
		
		
		
		FlowPane bottomflowpane = new FlowPane();
		bottomflowpane.setAlignment(Pos.CENTER);
		bottomflowpane.setColumnHalignment(HPos.CENTER);
		bottomflowpane.setPrefSize(700, 100);
		bottomflowpane.getChildren().add(logOut);
		
		FlowPane flowpane = new FlowPane();
		flowpane.setAlignment(Pos.CENTER);
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setPrefSize(700, 400);
		flowpane.setVgap(30);
		flowpane.setOrientation(Orientation.VERTICAL);
		flowpane.getChildren().add(rentInfoSearch);
		flowpane.getChildren().add(userInfoSearchAndUpdate);
		flowpane.getChildren().add(searchBook);
		
		
		root.setCenter(flowpane);
		root.setBottom(bottomflowpane);
		
		return root;
	}
}
