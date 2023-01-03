package library.jdbc.view;

import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import library.jdbc.VO.RentVO;
import library.jdbc.controller.GetNotReturnedBookListController;

public class AdministratorView {
	private BorderPane logIn=null;
	private Stage primaryStage=null;
	private Scene scene=null;
	
	public AdministratorView(Stage primaryStage, Scene scene, BorderPane root) {
		this.primaryStage=primaryStage;
		this.scene = scene;
		this.logIn=root;
	}
	
	private Button userInfoSearch;
	private Button bookSearchAndUpdate;
	private Button searchNotReturnedBook;
	private Button logOut;
	
	public BorderPane getRoot()
	{
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		userInfoSearch = new Button("회원정보 조회");
		userInfoSearch.setPrefSize(150, 70);
		userInfoSearch.setOnAction(e -> {
			UserInfoView userinfoview = new UserInfoView(primaryStage,scene,root);
			scene.setRoot(userinfoview.getRoot());
			primaryStage.setScene(scene);
			primaryStage.setTitle("회원정보 조회");
		});
		
		bookSearchAndUpdate = new Button("도서 검색 및 수정");
		bookSearchAndUpdate.setPrefSize(150, 70);
		bookSearchAndUpdate.setOnAction(e -> {
			BookSearchAndUpdateView booksearchandupdateview = new BookSearchAndUpdateView(primaryStage, scene, root);
			scene.setRoot(booksearchandupdateview.getRoot());
			primaryStage.setScene(scene);
			primaryStage.setTitle("도서 검색 및 수정");
			});
		
		searchNotReturnedBook = new Button("미납도서 검색");
		searchNotReturnedBook.setPrefSize(150, 70);
		searchNotReturnedBook.setOnAction(e -> {
			
			GetNotReturnedBookListController con = new GetNotReturnedBookListController();
			ObservableList<RentVO> list = con.getResult();
			NotReturnedBookView notreturnedbookview = new NotReturnedBookView(root, scene, primaryStage,list);
			scene.setRoot(notreturnedbookview.getRoot());
			primaryStage.setScene(scene);
			primaryStage.setTitle("미납 도서 검색");
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
		flowpane.getChildren().add(userInfoSearch);
		flowpane.getChildren().add(bookSearchAndUpdate);
		flowpane.getChildren().add(searchNotReturnedBook);
		
		
		root.setCenter(flowpane);
		root.setBottom(bottomflowpane);
		
		return root;
	}
}
