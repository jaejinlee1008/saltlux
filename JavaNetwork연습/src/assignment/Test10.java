package assignment;

class BookUpdate{
	
	public BookUpdate() {
		
	}
	
	public BookUpdate(Book bookData)
	{
		this.bookData = bookData;
	}
	
	
	
	public Book getBookData() {
		return bookData;
	}

	public void setBookData(Book bookData) {
		this.bookData = bookData;
	}

	public void updateBookPrice()
	{
		bookData.setBookPrice(bookData.getDiscountBookPrice());
	}

	Book bookData;
}

public class Test10 {
	public static void main(String[] args) {
		Book bookdata = new Book("IT","HTML",30000.0,10.0);
		System.out.println("기본정보");
		System.out.println(bookdata.getBookName() + " " + bookdata.getBookPrice());
		BookUpdate bookupdate = new BookUpdate(bookdata);
		bookupdate.updateBookPrice();
		System.out.println("변경된 정보");
		System.out.println(bookdata.getBookName() + " " + bookdata.getBookPrice());
	}
}
