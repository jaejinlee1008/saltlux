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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import library.jdbc.VO.BookVO;
import library.jdbc.controller.BookSearchController;
import library.jdbc.controller.CheckCanInsertBookController;

public class BookInsertView {
	private BorderPane booksearch=null;
	private Scene scene = null;
	private Stage primaryStage = null;
	
	private Text notice;
	
	private Text bisbn;
	private Text btitle;
	private Text bauthor;
	private Text bprice;
	
	private TextField bisbntf;
	private TextField btitletf;
	private TextField bauthortf;
	private TextField bpricetf;
	
	private Button apply;
	private Button goBack;
	
	
	private String newbisbn;
	private String newbtitle;
	private String newbauthor;
	private String newbprice;
	private String keywordstr="";
	
	private TableView<BookVO> tableView=null;
	
	
	
	public BookInsertView(BorderPane booksearch, Scene scene, Stage primaryStage,TableView<BookVO> tableView, String keywordstr) {
		super();
		this.booksearch = booksearch;
		this.scene = scene;
		this.primaryStage = primaryStage;
		this.tableView=tableView;
		this.keywordstr = keywordstr;
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
	
	
	public BorderPane getRoot()
	{
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		notice = new Text("도서 등록");
		notice.setWrappingWidth(700);
		notice.setTextAlignment(TextAlignment.CENTER);
		notice.setFont(Font.font(null, FontWeight.BOLD, 20));
		
		bisbn = new Text("일련번호");
		bisbn.setWrappingWidth(50);
		
		bisbntf = new TextField();
		bisbntf.setPrefSize(200, 40);
		
		
		btitle = new Text("책 제목");
		btitle.setWrappingWidth(50);
		
		btitletf = new TextField();
		btitletf.setPrefSize(200, 40);
		
		
		bauthor = new Text("저자");
		bauthor.setWrappingWidth(50);
		
		bauthortf = new TextField();
		bauthortf.setPrefSize(200, 40);
		
		
		bprice = new Text("가격");
		bprice.setWrappingWidth(50);
		
		bpricetf = new TextField();
		bpricetf.setPrefSize(200, 40);
		bpricetf.setOnAction(e->{
			newbisbn = bisbntf.getText();
			newbtitle = btitletf.getText();
			newbauthor = bauthortf.getText();
			newbprice = bpricetf.getText();
			CheckCanInsertBookController controller = new CheckCanInsertBookController();
			if(controller.getResult(newbisbn,newbtitle,newbauthor,newbprice))
			{
				BookSearchAndUpdateView view = new BookSearchAndUpdateView();
				ButtonType type = new ButtonType("OK",ButtonData.OK_DONE);
				Dialog<ButtonType> dialog = new Dialog<>();
				dialog.setTitle("알림");
				dialog.setContentText("새로운 도서를 성공적으로 등록하였습니다!!!!");
				dialog.getDialogPane().setMinSize(700, 200);
				dialog.getDialogPane().getButtonTypes().add(type);
				dialog.showAndWait();
				tableView.setItems(getList(keywordstr));
				view.SetTableView(tableView);
				scene.setRoot(booksearch);
				primaryStage.setScene(scene);
			}else
			{
				showDialog("알림", "도서 등록 실패 입력 정보를 다시 확인해주세요");
			}
		});
		
		
		FlowPane isbnflowpane = new FlowPane();
		isbnflowpane.setAlignment(Pos.CENTER);
		isbnflowpane.setColumnHalignment(HPos.CENTER);
		isbnflowpane.setPrefSize(700, 60);
		isbnflowpane.setHgap(10);
		isbnflowpane.getChildren().add(bisbn);
		isbnflowpane.getChildren().add(bisbntf);
		
		FlowPane titleflowpane = new FlowPane();
		titleflowpane.setAlignment(Pos.CENTER);
		titleflowpane.setColumnHalignment(HPos.CENTER);
		titleflowpane.setPrefSize(700, 60);
		titleflowpane.setHgap(10);
		titleflowpane.getChildren().add(btitle);
		titleflowpane.getChildren().add(btitletf);
		
		FlowPane authorflowpane = new FlowPane();
		authorflowpane.setAlignment(Pos.CENTER);
		authorflowpane.setColumnHalignment(HPos.CENTER);
		authorflowpane.setPrefSize(700, 60);
		authorflowpane.setHgap(10);
		authorflowpane.getChildren().add(bauthor);
		authorflowpane.getChildren().add(bauthortf);
		
		FlowPane priceflowpane = new FlowPane();
		priceflowpane.setAlignment(Pos.CENTER);
		priceflowpane.setColumnHalignment(HPos.CENTER);
		priceflowpane.setPrefSize(700, 60);
		priceflowpane.setHgap(10);
		priceflowpane.getChildren().add(bprice);
		priceflowpane.getChildren().add(bpricetf);
		
		
		apply = new Button("변경");
		apply.setPrefSize(300, 40);
		apply.setOnAction(e -> {
			newbisbn = bisbntf.getText();
			newbtitle = btitletf.getText();
			newbauthor = bauthortf.getText();
			newbprice = bpricetf.getText();
			CheckCanInsertBookController controller = new CheckCanInsertBookController();
			if(controller.getResult(newbisbn,newbtitle,newbauthor,newbprice))
			{
				BookSearchAndUpdateView view = new BookSearchAndUpdateView();
				ButtonType type = new ButtonType("OK",ButtonData.OK_DONE);
				Dialog<ButtonType> dialog = new Dialog<>();
				dialog.setTitle("알림");
				dialog.setContentText("새로운 도서를 성공적으로 등록하였습니다!!!!");
				dialog.getDialogPane().setMinSize(700, 200);
				dialog.getDialogPane().getButtonTypes().add(type);
				dialog.showAndWait();
				tableView.setItems(getList(keywordstr));
				view.SetTableView(tableView);
				scene.setRoot(booksearch);
				primaryStage.setScene(scene);
			}else
			{
				showDialog("알림", "도서 등록 실패 입력 정보를 다시 확인해주세요");
			}
		});
		
		goBack=new Button("뒤로가기");
		goBack.setPrefSize(300, 40);
		goBack.setOnAction(e->{
			scene.setRoot(booksearch);
			primaryStage.setScene(scene);
			primaryStage.setTitle("관리자 모드");
		});
		
		
		FlowPane bottomflowpane = new FlowPane();
		bottomflowpane.setAlignment(Pos.CENTER);
		bottomflowpane.setColumnHalignment(HPos.CENTER);
		bottomflowpane.setPrefSize(700, 100);
		bottomflowpane.setHgap(50);
		bottomflowpane.getChildren().add(apply);
		bottomflowpane.getChildren().add(goBack);
		
		FlowPane flowpane = new FlowPane();
		flowpane.setAlignment(Pos.CENTER);
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setPrefSize(700, 400);
		flowpane.setVgap(10);
		flowpane.setOrientation(Orientation.VERTICAL);
		flowpane.getChildren().add(notice);
		flowpane.getChildren().add(isbnflowpane);
		flowpane.getChildren().add(titleflowpane);
		flowpane.getChildren().add(authorflowpane);
		flowpane.getChildren().add(priceflowpane);
		
		root.setCenter(flowpane);
		root.setBottom(bottomflowpane);
		
		return root;
	}

	public ObservableList<BookVO> getList(String keywordstr) {
		BookSearchController controller = new BookSearchController();
		ObservableList<BookVO> list =  controller.getResult(keywordstr);
		return list;
	}
}
