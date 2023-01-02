package library.jdbc.view;

import java.util.Optional;

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
import library.jdbc.VO.BookVO;
import library.jdbc.controller.BookSearchController;


public class UserModeBookSearchView {
	TableView<BookVO> tableView=null;
	private BorderPane user=null;
	private Scene scene = null;
	private Stage primaryStage = null;
	private TextField keywordtf;
	private String keywordstr="";
	private Button goBack;
	
	public UserModeBookSearchView(BorderPane user, Scene scene, Stage primaryStage) {
		super();
		this.user = user;
		this.scene = scene;
		this.primaryStage = primaryStage;
	}
	
	
	

	public BorderPane getRoot()
	{
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		goBack=new Button("뒤로가기");
		goBack.setPrefSize(300, 30);
		goBack.setOnAction(e->{
			scene.setRoot(user);
			primaryStage.setScene(scene);
			primaryStage.setTitle("사용자 모드");
		});
		
		// 2. BorderPane 아래쪽에 붙일 판자(FlowPane)를 하나 생성
		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10,10,10,10));
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setPrefSize(700, 40);
		flowpane.setHgap(30);
		
		// 3. 각각의 component를 생성해서 붙인다.
		keywordtf = new TextField();
		keywordtf.setPrefSize(250, 40);
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
		
		// 나중에 TableView에 데이터가 표현되는데 이때 각 행들에 대해 이벤트 설정 가능
		tableView.setRowFactory(e -> {
			//TableRow를 만들어서
			TableRow<BookVO> row = new TableRow<>();
			//해당 행에 이벤트 처리를 설정한 다음
			row.setOnMouseClicked(e1->{
				// 클릭한 행을 얻어온다.
				BookVO book = row.getItem();
				// 삭제할 책의 Primary Key를 알아내야 한다.
				
				  if(e1.getClickCount()>1) { 
				  
					    ButtonType type = new ButtonType("OK",ButtonData.OK_DONE);
						Dialog<ButtonType> dialog = new Dialog<>();
						dialog.setTitle("대여 알림");
						dialog.setContentText("대여 하시겠습니까?");
						dialog.getDialogPane().setMinSize(700, 200);
						dialog.getDialogPane().getButtonTypes().add(type);
						Optional<ButtonType> result = dialog.showAndWait();
					    if(result.get().getText().equals("OK"))
					    {
					    	// 대여하고 정보 수정
					    	ButtonType type1 = new ButtonType("OK",ButtonData.OK_DONE);
							Dialog<ButtonType> dialog1 = new Dialog<>();
							dialog1.setTitle("알림");
							dialog1.setContentText("대여 성공");
							dialog1.getDialogPane().setMinSize(700, 200);
							dialog1.getDialogPane().getButtonTypes().add(type);
							dialog1.show();
					    }else
					    {
					    	ButtonType type1 = new ButtonType("OK",ButtonData.OK_DONE);
							Dialog<ButtonType> dialog1 = new Dialog<>();
							dialog1.setTitle("알림");
							dialog1.setContentText("대여 실패");
							dialog1.getDialogPane().setMinSize(700, 200);
							dialog1.getDialogPane().getButtonTypes().add(type);
							dialog1.show();
					    }
				  }
				 
			});
			
			
			
			//해당 행을 리턴하는 방식
			return row;
		});
		
		root.setCenter(tableView);
		root.setBottom(flowpane);
		
		return root;
	}
}
