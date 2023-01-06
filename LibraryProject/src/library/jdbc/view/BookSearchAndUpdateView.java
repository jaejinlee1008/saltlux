package library.jdbc.view;

import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import library.jdbc.VO.BookVO;
import library.jdbc.controller.BookDeleteController;
import library.jdbc.controller.BookSearchController;



public class BookSearchAndUpdateView {
	TableView<BookVO> tableView;
	private BorderPane admin=null;
	private BorderPane logIn=null;
	private Scene scene = null;
	private Stage primaryStage = null;
	
	private TextField keyword;
	private Button delete;
	private Button update;
	private Button insert;
	private Button goBack;
	private Text notice;
	private Hyperlink logout;
	
	private String keywordstr="";
	private String deleteISBN="";
	
	private BookVO book=null;
	
	public BookSearchAndUpdateView() {
		// TODO Auto-generated constructor stub
	}
	
	public BookSearchAndUpdateView(Stage primaryStage, Scene scene, BorderPane root, BorderPane logIn) {
		this.admin=root;
		this.scene=scene;
		this.primaryStage=primaryStage;
		this.logIn=logIn;
	}
	
	public void SetTableView(TableView<BookVO> tableView)
	{
		this.tableView=tableView;
	}
	
	public BorderPane getRoot()
	{
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		notice = new Text("도서 검색 및 수정");
		notice.setWrappingWidth(500);
		notice.setTextAlignment(TextAlignment.CENTER);
		notice.setFont(Font.font(null, FontWeight.BOLD, 20));
		
		logout = new Hyperlink("로그아웃");
		logout.setOnAction(e->{
			scene.setRoot(logIn);
			primaryStage.setScene(scene);
		});
		
		
		keyword = new TextField();
		keyword.setPrefSize(250, 40);
		keyword.setText("검색어를 입력하세요.");
		keyword.setOnMouseClicked(e->{
			keyword.clear();
		});
		keyword.setOnAction(e->{
			keywordstr = keyword.getText();
			BookSearchController controller = new BookSearchController();
			ObservableList<BookVO> list =  controller.getResult(keywordstr);
			tableView.setItems(list);
		});
		
		delete=new Button("삭제");
		delete.setPrefSize(80, 40);
		delete.setDisable(true);
		delete.setOnAction(e->{
			BookDeleteController controller = new BookDeleteController();
			ObservableList<BookVO> list = controller.getDeletedResult(deleteISBN,keywordstr);
			tableView.setItems(list);
		});
		
		update=new Button("수정");
		update.setPrefSize(80, 40);
		update.setDisable(true);
		update.setOnAction(e->{
			if(book!=null)
			{
				BookUpdateView bookupdateview = new BookUpdateView(root, scene, primaryStage, book, tableView,keywordstr);
				scene.setRoot(bookupdateview.getRoot());
				primaryStage.setScene(scene);
				
			}
		});
		
		insert=new Button("입력");
		insert.setPrefSize(80, 40);
		insert.setOnAction(e->{
			BookInsertView bookinsertview = new BookInsertView(root, scene, primaryStage, tableView, keywordstr);
			scene.setRoot(bookinsertview.getRoot());
			primaryStage.setScene(scene);
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
		
		FlowPane topflowpane = new FlowPane();
		topflowpane.setPadding(new Insets(10,10,10,10));
		topflowpane.setAlignment(Pos.CENTER_RIGHT);
		topflowpane.setColumnHalignment(HPos.CENTER);
		topflowpane.setPrefSize(700, 80);
		topflowpane.setHgap(10);
		topflowpane.getChildren().add(notice);
		topflowpane.getChildren().add(logout);
		
		
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
		
		tableView.setRowFactory(e -> {
			
			TableRow<BookVO> row = new TableRow<>();
			
			row.setOnMouseClicked(e1->{
				delete.setDisable(false);
				update.setDisable(false);
				try {
					book = row.getItem();
					
					deleteISBN=book.getBisbn();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
			});
			return row;
		});
		
		root.setTop(topflowpane);
		root.setCenter(tableView);
		root.setBottom(flowpane);
		
		return root;
	}
}
