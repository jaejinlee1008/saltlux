package lecture.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import lecture.jdbc.vo.BookVO;

public class SimpleJavaFXTableView extends Application {
	
	

	// TableView안에 데이터를 표현할때 VO를 가져다가 한 줄씩 표현
	// 그 때 어떤 VO를 사용하는지 class이름을 generic으로 지정해준다.
	TableView<BookVO> tableView;
	TextField textField;
	String input="";
	
	@Override
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
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		String id="root";
		String pw="test1234";
		
		Connection con = DriverManager.getConnection(url,id,pw);
		
		String sql = "SELECT bisbn,btitle, bauthor,bprice FROM book WHERE btitle like ? ORDER BY bprice DESC";
		
		
		// TableView에 표현할 데이터를 생성
		// TableView에 데이터를 밀어 넣을때는 ArrayList와 유사한 List를 사용
		
		
		
		tableView = new TableView<BookVO>();
		
		// 위에서 만들어진 컬럼객체를 TableView에 붙인다.
		tableView.getColumns().addAll(isbnColumn,titleColumn,authorColumn,priceColumn);
		
		textField = new TextField();
		textField.setPrefSize(250, 40);
		textField.setOnAction(e -> {
			input = textField.getText();
			PreparedStatement pstmt;
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%" + input+ "%");
				ResultSet rs = pstmt.executeQuery();
				ObservableList<BookVO> list = FXCollections.observableArrayList();
				while(rs.next())
				{
					list.add(new BookVO(rs.getString("bisbn"),rs.getString("btitle"),rs.getString("bauthor"),rs.getInt("bprice")));
				}
				tableView.setItems(list);
				textField.clear();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		});
		flowpane.getChildren().add(textField);
		
		// 데이터를 세팅한다.
		//tableView.setItems(list);
		
		
		root.setCenter(tableView);
		root.setBottom(flowpane);
		
		Scene scene = new Scene(root);
		
		PrimaryStage.setScene(scene);
		PrimaryStage.setTitle("Simple JavaFX TableView");
		
		PrimaryStage.show();
	}
	
	
	public static void main(String[] args) {
		launch();
	}
}
