package library.jdbc.view;

import java.sql.Date;

import javafx.collections.ObservableList;
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
	ObservableList<UserVO> list=null;
	private BorderPane admin=null;
	private Scene scene = null;
	private Stage primaryStage = null;
	private Button goBack;
	
	public UserInfoView(Stage primaryStage, Scene scene, BorderPane root,ObservableList<UserVO> list) {
		this.admin=root;
		this.scene=scene;
		this.primaryStage=primaryStage;
		this.list=list;
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
		nameColumn.setMinWidth(60);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		TableColumn<UserVO,String> idColumn = new TableColumn<>("ID"); 
		idColumn.setMinWidth(100);
		idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
		
		TableColumn<UserVO,String> emailColumn = new TableColumn<>("이메일"); 
		emailColumn.setMinWidth(180);
		emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
		
		TableColumn<UserVO,Date> indateColumn = new TableColumn<>("가입일"); 
		indateColumn.setMinWidth(100);
		indateColumn.setCellValueFactory(new PropertyValueFactory<>("indate"));
		
		TableColumn<UserVO,Integer> pointColumn = new TableColumn<>("POINT"); 
		pointColumn.setMinWidth(20);
		pointColumn.setCellValueFactory(new PropertyValueFactory<>("point"));
		
		TableColumn<UserVO,String> isoutColumn = new TableColumn<>("탈퇴여부"); 
		isoutColumn.setMinWidth(20);
		isoutColumn.setCellValueFactory(new PropertyValueFactory<>("isout"));
		
		TableColumn<UserVO,Date> outdateColumn = new TableColumn<>("탈퇴일"); 
		outdateColumn.setMinWidth(100);
		outdateColumn.setCellValueFactory(new PropertyValueFactory<>("outdate"));
		
		tableView = new TableView<UserVO>();
	
		tableView.getColumns().addAll(nameColumn,idColumn,emailColumn,indateColumn,pointColumn,isoutColumn,outdateColumn);
		
		tableView.setItems(list);
		
		root.setCenter(tableView);
		root.setBottom(flowpane);
		
		return root;
	}
	
}
