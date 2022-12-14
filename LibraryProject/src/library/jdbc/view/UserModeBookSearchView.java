package library.jdbc.view;


import java.util.Optional;

import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
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
import library.jdbc.VO.LogVO;
import library.jdbc.controller.BookRentController;
import library.jdbc.controller.BookSearchController;
import library.jdbc.controller.CanRentCheckController;


public class UserModeBookSearchView {
	TableView<BookVO> tableView=null;
	private BorderPane user=null;
	private BorderPane logIn=null;
	private Scene scene = null;
	private Stage primaryStage = null;
	private TextField keywordtf;
	private String keywordstr="";
	private Button goBack;
	private String ID;
	private String name;
	private Text notice;
	private Hyperlink logout;
	private ObservableList<LogVO> loglist=null;
	
	public UserModeBookSearchView(BorderPane logIn, BorderPane user, Scene scene, Stage primaryStage, String ID, String name) {
		super();
		this.logIn=logIn;
		this.user = user;
		this.scene = scene;
		this.primaryStage = primaryStage;
		this.ID = ID;
		this.name = name;
	}
	
	
	public ObservableList<LogVO> getLoglist()
	{
		return loglist;
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
		
		goBack=new Button("????????????");
		goBack.setPrefSize(300, 30);
		goBack.setOnAction(e->{
			scene.setRoot(user);
			primaryStage.setScene(scene);
			primaryStage.setTitle("????????? ??????");
		});
		
		notice = new Text("?????? ?????? ??? ??????");
		notice.setWrappingWidth(500);
		notice.setTextAlignment(TextAlignment.CENTER);
		notice.setFont(Font.font(null, FontWeight.BOLD, 20));
		
		logout = new Hyperlink("????????????");
		logout.setOnAction(e->{
			scene.setRoot(logIn);
			primaryStage.setScene(scene);
		});
		
		FlowPane topflowpane = new FlowPane();
		topflowpane.setPadding(new Insets(10,10,10,10));
		topflowpane.setAlignment(Pos.CENTER_RIGHT);
		topflowpane.setColumnHalignment(HPos.CENTER);
		topflowpane.setPrefSize(700, 80);
		topflowpane.setHgap(10);
		topflowpane.getChildren().add(notice);
		topflowpane.getChildren().add(logout);
		
		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10,10,10,10));
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setPrefSize(700, 40);
		flowpane.setHgap(30);
		
		
		keywordtf = new TextField();
		keywordtf.setPrefSize(250, 40);
		keywordtf.setPromptText("???????????? ???????????????.");
		keywordtf.setOnMouseClicked(e->{
			keywordtf.clear();
		});
		keywordtf.setOnAction(e -> {
			keywordstr = keywordtf.getText();
			BookSearchController controller = new BookSearchController();
			ObservableList<BookVO> list =  controller.getResult(keywordstr);
			tableView.setItems(list);
			
		});
		
		flowpane.getChildren().add(keywordtf);
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
		//extratableView.getColumns().addAll(dateColumn,pageColumn,translatorColumn,supplementColumn,publisherColumn);
		
		// ????????? TableView??? ???????????? ??????????????? ?????? ??? ????????? ?????? ????????? ?????? ??????
		tableView.setRowFactory(e -> {
			//TableRow??? ????????????
			TableRow<BookVO> row = new TableRow<>();
			//?????? ?????? ????????? ????????? ????????? ??????
			
			row.setOnMouseClicked(e1->{
				// ????????? ?????? ????????????.
				BookVO book = row.getItem();
				// ????????? ?????? Primary Key??? ???????????? ??????.
				
				  if(e1.getClickCount()>1) { 
					  	CanRentCheckController controller = new CanRentCheckController();
					  	
					  	if(controller.getResult(book.getBisbn()))
					  	{
					  		ButtonType type = new ButtonType("OK",ButtonData.OK_DONE);
							Dialog<ButtonType> dialog = new Dialog<>();
							dialog.setTitle("?????? ??????");
							dialog.setContentText("????????? ???????????????. ?????? ???????????????????");
							dialog.getDialogPane().setMinSize(700, 200);
							dialog.getDialogPane().getButtonTypes().add(type);
							try {
								Optional<ButtonType> result = dialog.showAndWait();
								
							    if(result.get().getText().equals("OK"))
							    {
							    	
							    	BookRentController rentcontroller = new BookRentController();
							    	rentcontroller.setResult(book.getBisbn(),book.getBtitle(),ID,"N");
							    	loglist = rentcontroller.setResult(book.getBtitle(), book.getBisbn(), ID, name, "??????", 0);
							    	showDialog("??????", "?????? ??????");
							    }else
							    {
							    	showDialog("??????", "?????? ??????");
							    }
							} catch (Exception e2) {
								// TODO: handle exception
							}
							
					  	}else
					  	{
					  		showDialog("?????? ??????", "?????? ????????? ???????????????, ????????? ??????????????????.");
					  	}
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
