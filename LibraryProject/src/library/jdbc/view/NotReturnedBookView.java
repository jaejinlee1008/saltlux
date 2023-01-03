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
import library.jdbc.VO.RentVO;


public class NotReturnedBookView {
	TableView<RentVO> tableView;
	private BorderPane admin=null;
	private Scene scene = null;
	private Stage primaryStage = null;
	private Button goBack;
	private ObservableList<RentVO> list=null;
	public NotReturnedBookView(BorderPane admin, Scene scene, Stage primaryStage, ObservableList<RentVO> list) {
		super();
		this.admin = admin;
		this.scene = scene;
		this.primaryStage = primaryStage;
		this.list = list;
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
		isbnColumn.setMinWidth(130);
		isbnColumn.setCellValueFactory(new PropertyValueFactory<>("bisbn"));
		
		TableColumn<RentVO,String> titleColumn = new TableColumn<>("책 제목"); 
		titleColumn.setMinWidth(130);
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("btitle"));
		
		TableColumn<RentVO,String> idColumn = new TableColumn<>("대여자ID"); 
		idColumn.setMinWidth(80);
		idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
		
		TableColumn<RentVO,Date> dateColumn = new TableColumn<>("대여날짜"); 
		dateColumn.setMinWidth(100);
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
		
		TableColumn<RentVO,String> isreturnColumn = new TableColumn<>("반납여부"); 
		isreturnColumn.setMinWidth(80);
		isreturnColumn.setCellValueFactory(new PropertyValueFactory<>("isreturn_YN"));
		
		
		tableView = new TableView<RentVO>();
		
		tableView.getColumns().addAll(isbnColumn,titleColumn,idColumn,dateColumn,isreturnColumn);
		
		tableView.setItems(list);
		
		root.setCenter(tableView);
		root.setBottom(flowpane);
		
		return root;
	}
}
