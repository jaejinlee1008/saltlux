package library.jdbc.view;

import java.sql.Date;

import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import library.jdbc.VO.RentVO;


public class NotReturnedBookView {
	TableView<RentVO> tableView;
	private BorderPane admin=null;
	private BorderPane logIn=null;
	private Scene scene = null;
	private Stage primaryStage = null;
	private Button goBack;
	private Text notice;
	private Hyperlink logout;
	private ObservableList<RentVO> list=null;
	public NotReturnedBookView(BorderPane admin, Scene scene, Stage primaryStage, ObservableList<RentVO> list, BorderPane logIn) {
		super();
		this.admin = admin;
		this.scene = scene;
		this.primaryStage = primaryStage;
		this.list = list;
		this.logIn = logIn;
	}
	
	public BorderPane getRoot()
	{
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		
		notice = new Text("미납도서 목록");
		notice.setWrappingWidth(500);
		notice.setTextAlignment(TextAlignment.CENTER);
		notice.setFont(Font.font(null, FontWeight.BOLD, 20));
		
		logout = new Hyperlink("로그아웃");
		logout.setOnAction(e->{
			scene.setRoot(logIn);
			primaryStage.setScene(scene);
		});
		
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
		
		FlowPane topflowpane = new FlowPane();
		topflowpane.setPadding(new Insets(10,10,10,10));
		topflowpane.setAlignment(Pos.CENTER_RIGHT);
		topflowpane.setColumnHalignment(HPos.CENTER);
		topflowpane.setPrefSize(700, 80);
		topflowpane.setHgap(10);
		topflowpane.getChildren().add(notice);
		topflowpane.getChildren().add(logout);
		
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
		
		root.setTop(topflowpane);
		root.setCenter(tableView);
		root.setBottom(flowpane);
		
		return root;
	}
}
