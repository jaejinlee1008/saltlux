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
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import library.jdbc.VO.LogVO;
import library.jdbc.VO.RentVO;
import library.jdbc.controller.BookReturnController;
import library.jdbc.controller.GetNotReturnedBookListController;
import library.jdbc.controller.UserRentLogSearchController;

public class UserRentInfoView {
	TableView<LogVO> tableView;
	private BorderPane user=null;
	private BorderPane logIn=null;	
	private Scene scene = null;
	private Stage primaryStage = null;
	private Button goBack;
	private Button btnreturn;
	private ObservableList<LogVO> list = null;
	private ObservableList<RentVO> NotReturnedlist = null;
	private LogVO log=null;
	
	private Text notice;
	private Hyperlink logout;
	
	public UserRentInfoView(BorderPane admin, Scene scene, Stage primaryStage, ObservableList<LogVO> list, BorderPane logIn) {
		super();
		this.user = admin;
		this.scene = scene;
		this.primaryStage = primaryStage;
		this.list = list;
		this.logIn=logIn;
	}
	
	private boolean returnCheck(String bisbn) {
		/*
		 * CanReturnCheckController controller = new CanReturnCheckController();
		 * 
		 * return controller.getResult(bisbn);
		 */
		for(RentVO rent : NotReturnedlist)
		{
			if(bisbn.equals(rent.getBisbn()))
			{
				return true;
			}
		}
		return false;
	}
	
	private void setNotReturnedlist()
	{
		GetNotReturnedBookListController controller = new GetNotReturnedBookListController();
		NotReturnedlist = controller.getResult();
	}
	
	public BorderPane getRoot()
	{
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		setNotReturnedlist();
		
		notice = new Text("대여 내역 조회");
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
			scene.setRoot(user);
			primaryStage.setScene(scene);
			primaryStage.setTitle("사용자 모드");
		});
		
		btnreturn = new Button("반납하기");
		btnreturn.setPrefSize(300, 40);
		btnreturn.setDisable(true);
		btnreturn.setOnAction(e -> {
			
			BookReturnController returncontroller = new BookReturnController();
			//반납 추가
			returncontroller.setResultlog(log);
			UserRentLogSearchController logcon = new UserRentLogSearchController();
			ObservableList<LogVO> loglist = logcon.getResult(log.getID());
			tableView.setItems(loglist);
			//list삭제
			returncontroller.setResultlist(log.getBisbn(),log.getID());
		});
		
		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10,10,10,10));
		flowpane.setAlignment(Pos.CENTER);
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setPrefSize(700, 50);
		flowpane.setHgap(10);
		flowpane.getChildren().add(goBack);
		flowpane.getChildren().add(btnreturn);
		
		FlowPane topflowpane = new FlowPane();
		topflowpane.setPadding(new Insets(10,10,10,10));
		topflowpane.setAlignment(Pos.CENTER_RIGHT);
		topflowpane.setColumnHalignment(HPos.CENTER);
		topflowpane.setPrefSize(700, 80);
		topflowpane.setHgap(10);
		topflowpane.getChildren().add(notice);
		topflowpane.getChildren().add(logout);
		
		TableColumn<LogVO,String> titleColumn = new TableColumn<>("책 제목"); 
		titleColumn.setMinWidth(130);
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("btitle"));
		
		TableColumn<LogVO,String> isbnColumn = new TableColumn<>("ISBN"); 
		isbnColumn.setMinWidth(130);
		isbnColumn.setCellValueFactory(new PropertyValueFactory<>("bisbn"));
		
		TableColumn<LogVO,String> idColumn = new TableColumn<>("대여자ID"); 
		idColumn.setMinWidth(80);
		idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
		
		TableColumn<LogVO,String> nameColumn = new TableColumn<>("대여자 이름"); 
		nameColumn.setMinWidth(80);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		TableColumn<LogVO,Date> dateColumn = new TableColumn<>("대여일/반납일"); 
		dateColumn.setMinWidth(100);
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
		
		TableColumn<LogVO,String> rentorreturnColumn = new TableColumn<>("대여/반납"); 
		rentorreturnColumn.setMinWidth(80);
		rentorreturnColumn.setCellValueFactory(new PropertyValueFactory<>("rentORreturn"));
		
		TableColumn<LogVO,Integer> pointColumn = new TableColumn<>("POINT"); 
		pointColumn.setMinWidth(80);
		pointColumn.setCellValueFactory(new PropertyValueFactory<>("point"));
		
		TableColumn<LogVO,Date> duedateColumn = new TableColumn<>("반납마감일"); 
		duedateColumn.setMinWidth(100);
		duedateColumn.setCellValueFactory(new PropertyValueFactory<>("duedate"));
		
		
		tableView = new TableView<LogVO>();
		
		tableView.getColumns().addAll(isbnColumn,titleColumn,idColumn,dateColumn,rentorreturnColumn,pointColumn,duedateColumn);
		
		tableView.setItems(list);
		
		tableView.setRowFactory(e->{
			TableRow<LogVO> row = new TableRow<>();
			
			row.setOnMouseClicked(e1->{
				// 클릭한 행을 얻어온다.
				try {
					log = row.getItem();
					if(returnCheck(log.getBisbn()))
					{
						btnreturn.setDisable(false);
					}else
					{
						btnreturn.setDisable(true);
					}
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
