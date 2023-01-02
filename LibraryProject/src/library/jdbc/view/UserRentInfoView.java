package library.jdbc.view;

import java.sql.Date;

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
import library.jdbc.VO.RentVO;

public class UserRentInfoView {
	TableView<RentVO> tableView;
	private BorderPane admin=null;
	private Scene scene = null;
	private Stage primaryStage = null;
	private Button goBack;
	private RentVO rent = null;
	public UserRentInfoView(BorderPane admin, Scene scene, Stage primaryStage, RentVO rent) {
		super();
		this.admin = admin;
		this.scene = scene;
		this.primaryStage = primaryStage;
		this.rent = rent;
	}
	
	public BorderPane getRoot()
	{
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		
		goBack=new Button("뒤로가기");
		goBack.setPrefSize(300, 40);
		goBack.setOnAction(e->{
			scene.setRoot(admin);
			primaryStage.setScene(scene);
			primaryStage.setTitle("관리자 모드");
		});
		
		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10,10,10,10));
		flowpane.setAlignment(Pos.CENTER);
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setPrefSize(700, 50);
		flowpane.setHgap(10);
		flowpane.getChildren().add(goBack);
		
		
		TableColumn<RentVO,String> isbnColumn = new TableColumn<>("ISBN"); 
		isbnColumn.setMinWidth(150);
		isbnColumn.setCellValueFactory(new PropertyValueFactory<>("bisbn"));
		
		TableColumn<RentVO,String> idColumn = new TableColumn<>("대여자ID"); 
		idColumn.setMinWidth(150);
		idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
		
		TableColumn<RentVO,Date> dateColumn = new TableColumn<>("대여날짜"); 
		dateColumn.setMinWidth(150);
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
		
		TableColumn<RentVO,Character> isreturnColumn = new TableColumn<>("반납여부"); 
		isreturnColumn.setMinWidth(150);
		isreturnColumn.setCellValueFactory(new PropertyValueFactory<>("isreturn_yn"));
		
		
		tableView = new TableView<RentVO>();
		
		tableView.getColumns().addAll(isbnColumn,idColumn,dateColumn,isreturnColumn);
		
		
		root.setCenter(tableView);
		root.setBottom(flowpane);
		
		return root;
	}
}
