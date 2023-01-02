package lecture.jdbc.view;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import lecture.jdbc.controller.BookDeleteController;
import lecture.jdbc.controller.BookSearchController;
import lecture.jdbc.controller.BookSearchOtherDataController;
import lecture.jdbc.vo.BookExtraVO;
import lecture.jdbc.vo.BookVO;


public class BookSearchView extends Application{
	TableView<BookVO> tableView;
	//TableView<BookExtraVO> extratableView;
	TextField textField;
	String input="";
	String sql="";
	Button deleteBtn;
	String deleteISBN;
	Dialog<String> dialog;

	
	
	public void start(Stage PrimaryStage) throws Exception {
		// 1. layout부터 설정
		// BorderPane을 이용 (동,서,남,북,중앙으로 영역을 분할)
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		
		// 2. BorderPane 아래쪽에 붙일 판자(FlowPane)를 하나 생성
		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10,10,10,10));
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setPrefSize(700, 40);
		flowpane.setHgap(10);
		
		// 3. 각각의 component를 생성해서 붙인다.
		textField = new TextField();
		textField.setPrefSize(250, 40);
		textField.setOnAction(e -> {
			input = textField.getText();
			BookSearchController controller = new BookSearchController();
			ObservableList<BookVO> list =  controller.getResult(input);
			tableView.setItems(list);
			//root.setCenter(tableView);
		});
		
		
		
		// 삭제 버튼 생성
		deleteBtn = new Button("선택된 책 삭제");
		deleteBtn.setPrefSize(150, 40);
		deleteBtn.setDisable(true);
		deleteBtn.setOnAction(e->{
			BookDeleteController controller = new BookDeleteController();
			ObservableList<BookVO> list = controller.getDeletedResult(deleteISBN,input);
			tableView.setItems(list);
			//root.setCenter(tableView);
		});
		
		flowpane.getChildren().add(textField);
		flowpane.getChildren().add(deleteBtn);
		
		// 컬럼객체를 생성
		// TableColumn<해당 컬럼에 나오는 데이터를 갖는 VO, VO에서 값을 가져올 때 사용하는 데이터 Type>
		TableColumn<BookVO,String> isbnColumn = new TableColumn<>("ISBN"); //"ISBN" 화면에 보여지는 컬럼명
		isbnColumn.setMinWidth(150);
		// 해당컬럼의 데이터는 VO의 어떤 field에서 값을 가져올지 설정
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
		
		// 더블클릭 extra컬럼 생성
		/*
		 * TableColumn<BookExtraVO,String> dateColumn = new TableColumn<>("DATE");
		 * dateColumn.setMinWidth(120); dateColumn.setCellValueFactory(new
		 * PropertyValueFactory<>("bdate"));
		 * 
		 * TableColumn<BookExtraVO,Integer> pageColumn = new TableColumn<>("PAGE");
		 * pageColumn.setMinWidth(120); pageColumn.setCellValueFactory(new
		 * PropertyValueFactory<>("bpage"));
		 * 
		 * TableColumn<BookExtraVO,String> translatorColumn = new
		 * TableColumn<>("TRANSLATOR"); translatorColumn.setMinWidth(120);
		 * translatorColumn.setCellValueFactory(new
		 * PropertyValueFactory<>("btranslator"));
		 * 
		 * TableColumn<BookExtraVO,String> supplementColumn = new
		 * TableColumn<>("SUPPLEMENT"); supplementColumn.setMinWidth(120);
		 * supplementColumn.setCellValueFactory(new
		 * PropertyValueFactory<>("bsupplement"));
		 * 
		 * TableColumn<BookExtraVO,String> publisherColumn = new
		 * TableColumn<>("PUBLISHER"); publisherColumn.setMinWidth(120);
		 * publisherColumn.setCellValueFactory(new
		 * PropertyValueFactory<>("bpublisher"));
		 */
		
		
		
		tableView = new TableView<BookVO>();
		//extratableView = new TableView<BookExtraVO>();
		// 위에서 만들어진 컬럼객체를 TableView에 붙인다.
		tableView.getColumns().addAll(isbnColumn,titleColumn,authorColumn,priceColumn);
		//extratableView.getColumns().addAll(dateColumn,pageColumn,translatorColumn,supplementColumn,publisherColumn);
		
		// 나중에 TableView에 데이터가 표현되는데 이때 각 행들에 대해 이벤트 설정 가능
		tableView.setRowFactory(e -> {
			//TableRow를 만들어서
			TableRow<BookVO> row = new TableRow<>();
			//해당 행에 이벤트 처리를 설정한 다음
			row.setOnMouseClicked(e1->{
				deleteBtn.setDisable(false);
				// 클릭한 행을 얻어온다.
				BookVO book = row.getItem();
				// 삭제할 책의 Primary Key를 알아내야 한다.
				deleteISBN=book.getBisbn();
				if(e1.getClickCount()>1)
				{
					
					ButtonType type = new ButtonType("OK",ButtonData.OK_DONE);
					BookSearchOtherDataController controller = new BookSearchOtherDataController();
					// VO 새로 만들지 않고 기존의 VO에 추가, 생성자를 새로 만들어준다
					ObservableList<BookExtraVO> list = controller.getResult(deleteISBN);
					dialog = new Dialog<>();
					dialog.setTitle("책의 부가정보");
					dialog.setContentText("출판일 : " + list.get(0).getBdate() + ", 페이지 수 : " + list.get(0).getBpage() + ", 보충자료 : " + list.get(0).getBsupplement() + ", 역자 : " + list.get(0).getBtranslator() + ", 출판사 : " + list.get(0).getBpublisher());
					dialog.getDialogPane().setMinSize(700, 200);
					dialog.getDialogPane().getButtonTypes().add(type);
					dialog.show();
				}
			});
			
			
			
			//해당 행을 리턴하는 방식
			return row;
		});
		
		root.setCenter(tableView);
		root.setBottom(flowpane);
		
		Scene scene = new Scene(root);
		
		PrimaryStage.setScene(scene);
		PrimaryStage.setTitle("BookSearch JavaFX MVC");
		PrimaryStage.setOnCloseRequest(e->{
			
		});
		
		PrimaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch();
	}
}
