package library.jdbc.view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import library.jdbc.VO.BookVO;



public class BookSearchAndUpdateView {
	TableView<BookVO> tableView;
	private BorderPane admin=null;
	private Scene scene = null;
	private Stage primaryStage = null;
	
	private TextField keyword;
	private Button delete;
	private Button update;
	private Button insert;
	private Button goBack;
	
	public BookSearchAndUpdateView(Stage primaryStage, Scene scene, BorderPane root) {
		this.admin=root;
		this.scene=scene;
		this.primaryStage=primaryStage;
	}
	
	public BorderPane getRoot()
	{
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		keyword = new TextField();
		keyword.setPrefSize(250, 40);
		
		delete=new Button("삭제");
		delete.setPrefSize(80, 40);
		delete.setOnAction(e->{
			
		});
		
		update=new Button("수정");
		update.setPrefSize(80, 40);
		update.setOnAction(e->{
			
		});
		
		insert=new Button("입력");
		insert.setPrefSize(80, 40);
		insert.setOnAction(e->{
		});
		
		goBack=new Button("뒤로가기");
		goBack.setPrefSize(80, 40);
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
		flowpane.getChildren().add(keyword);
		flowpane.getChildren().add(delete);
		flowpane.getChildren().add(update);
		flowpane.getChildren().add(insert);
		flowpane.getChildren().add(goBack);
		
		
		TableColumn<BookVO,String> isbnColumn = new TableColumn<>("ISBN"); 
		isbnColumn.setMinWidth(150);
		isbnColumn.setCellValueFactory(new PropertyValueFactory<>("bisbn"));
		
		TableColumn<BookVO,String> titleColumn = new TableColumn<>("TITLE"); 
		titleColumn.setMinWidth(150);
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("btitle"));
		
		TableColumn<BookVO,String> authorColumn = new TableColumn<>("AUTHOR"); 
		authorColumn.setMinWidth(150);
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("bauthor"));
		
		TableColumn<BookVO,Integer> priceColumn = new TableColumn<>("PRICE"); 
		priceColumn.setMinWidth(150);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("bprice"));
		
		
		tableView = new TableView<BookVO>();
		
		tableView.getColumns().addAll(isbnColumn,titleColumn,authorColumn,priceColumn);
		
		
		root.setCenter(tableView);
		root.setBottom(flowpane);
		
		return root;
	}
}
