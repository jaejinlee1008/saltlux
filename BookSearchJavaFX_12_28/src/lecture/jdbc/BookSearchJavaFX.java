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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import lecture.jdbc.vo.BookVO;

public class BookSearchJavaFX extends Application{
	TableView<BookVO> tableView;
	TextField textField;
	String input="";
	Connection con;
	String sql="";
	ResultSet rs;
	Button deleteBtn;
	String deleteISBN;
	PreparedStatement pstmt;
	PreparedStatement deletepstmt;
	ObservableList<BookVO> list;
	public BookSearchJavaFX() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			String id="root";
			String pw="test1234";
			
			con = DriverManager.getConnection(url,id,pw);
			sql = "SELECT bisbn,btitle, bauthor,bprice FROM book WHERE btitle like ? ORDER BY bprice DESC";
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
		textField = new TextField();
		textField.setPrefSize(250, 40);
		textField.setOnAction(e -> {
			input = textField.getText();
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%" + input+ "%");
				rs = pstmt.executeQuery();
				list = FXCollections.observableArrayList();
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
		
		
		
		// 삭제 버튼 생성
		deleteBtn = new Button("선택된 책 삭제");
		deleteBtn.setPrefSize(150, 40);
		deleteBtn.setDisable(true);
		deleteBtn.setOnAction(e->{
			
			input = deleteISBN;
			
			try {
				String deletesql = "DELETE FROM BOOK WHERE bisbn = ?";
				
				con.setAutoCommit(false);
				deletepstmt = con.prepareStatement(deletesql);
				deletepstmt.setString(1, input);
				int count = deletepstmt.executeUpdate();
				
				if(count==1)
				{
					con.commit();
					rs = pstmt.executeQuery();
					list = FXCollections.observableArrayList();
					while(rs.next())
					{
						list.add(new BookVO(rs.getString("bisbn"),rs.getString("btitle"),rs.getString("bauthor"),rs.getInt("bprice")));
					}
					tableView.setItems(list);
				}else
				{
					con.rollback();
				}
				deletepstmt.close();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
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
		
		
		
		
		// TableView에 표현할 데이터를 생성
		// TableView에 데이터를 밀어 넣을때는 ArrayList와 유사한 List를 사용
		
		
		
		tableView = new TableView<BookVO>();
		
		// 위에서 만들어진 컬럼객체를 TableView에 붙인다.
		tableView.getColumns().addAll(isbnColumn,titleColumn,authorColumn,priceColumn);
		
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
			});
			//해당 행을 리턴하는 방식
			return row;
		});
		
		root.setCenter(tableView);
		root.setBottom(flowpane);
		
		Scene scene = new Scene(root);
		
		PrimaryStage.setScene(scene);
		PrimaryStage.setTitle("Simple JavaFX TableView");
		
		PrimaryStage.setOnCloseRequest(e -> {
			try {
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
		
		PrimaryStage.show();
	}
	
	
	public static void main(String[] args) {
		launch();
	}
}
