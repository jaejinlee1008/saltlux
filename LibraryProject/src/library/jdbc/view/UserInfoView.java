package library.jdbc.view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import library.jdbc.VO.UserVO;


public class UserInfoView {
	TableView<UserVO> tableView;
	private BorderPane admin=null;
	private Scene scene = null;
	private Stage primaryStage = null;
	private Button goBack;	
	public UserInfoView(Stage primaryStage, Scene scene, BorderPane root) {
		this.admin=root;
		this.scene=scene;
		this.primaryStage=primaryStage;
	}

	public BorderPane getRoot()
	{
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		
		goBack=new Button("뒤로가기");
		goBack.setPrefSize(300, 30);
		goBack.setOnAction(e->{
			scene.setRoot(admin);
			primaryStage.setScene(scene);
			primaryStage.setTitle("관리자 모드");
		});
		
		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10,10,10,10));
		flowpane.setAlignment(Pos.CENTER);
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setPrefSize(700, 40);
		flowpane.setHgap(10);
		flowpane.getChildren().add(goBack);
		
		
		TableColumn<UserVO,String> nameColumn = new TableColumn<>("이름"); 
		nameColumn.setMinWidth(110);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		TableColumn<UserVO,String> idColumn = new TableColumn<>("ID"); 
		idColumn.setMinWidth(150);
		idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
		
		TableColumn<UserVO,String> emailColumn = new TableColumn<>("이메일"); 
		emailColumn.setMinWidth(250);
		emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
		
		TableColumn<UserVO,Character> isrentColumn = new TableColumn<>("대여여부"); 
		isrentColumn.setMinWidth(80);
		isrentColumn.setCellValueFactory(new PropertyValueFactory<>("IsRent_YN"));
		
		TableColumn<UserVO,Integer> pointColumn = new TableColumn<>("POINT"); 
		pointColumn.setMinWidth(110);
		pointColumn.setCellValueFactory(new PropertyValueFactory<>("point"));
		
		
		
		
		tableView = new TableView<UserVO>();
		//extratableView = new TableView<BookExtraVO>();
		// 위에서 만들어진 컬럼객체를 TableView에 붙인다.
		tableView.getColumns().addAll(nameColumn,idColumn,emailColumn,isrentColumn,pointColumn);
		//extratableView.getColumns().addAll(dateColumn,pageColumn,translatorColumn,supplementColumn,publisherColumn);
		
		
		root.setCenter(tableView);
		root.setBottom(flowpane);
		
		return root;
	}
	
}
