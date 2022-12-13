package assignment;


class Book{
	public Book() {
		
	}
	
	public Book(String category,String bookName,double bookPrice,double bookDiscountRate)
	{
		this.category = category;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookDiscountRate = bookDiscountRate;
	}
	
	String category;
	String bookName;
	double bookPrice;
	double bookDiscountRate;
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public double getBookDiscountRate() {
		return bookDiscountRate;
	}

	public void setBookDiscountRate(double bookDiscountRate) {
		this.bookDiscountRate = bookDiscountRate;
	}
	
	public double getDiscountBookPrice()
	{
		return (this.bookPrice * (1-(0.01*this.bookDiscountRate)));
	}
}

public class Test09 {
	public static void main(String[] args) {
		Book bookArray[] = new Book[5];
		double itSum=0;
		double nobelSum=0;
		bookArray[0] = new Book("IT","SQL Plus", 50000.0, 5.0);
		bookArray[1] = new Book("IT","Java 2.0",40000.0, 3.0);
		bookArray[2] = new Book("IT","JSP Servlet",60000.0,6.0);
		bookArray[3] = new Book("Nobel","davincicode",30000.0,10.0);
		bookArray[4] = new Book("Nobel","cloven hoof",50000.0,15.0);
		
		for(int i=0;i<5;i++)
		{
			System.out.println(bookArray[i].getCategory() +" "+bookArray[i].getBookName() + "    " + bookArray[i].getBookPrice() + "원 " + bookArray[i].getBookDiscountRate()+"%");
			
			if(bookArray[i].getCategory().compareTo("IT")==0)
			{
				itSum+=bookArray[i].getDiscountBookPrice();
			}else if(bookArray[i].getCategory().compareTo("Nobel")==0)
			{
				nobelSum+=bookArray[i].getDiscountBookPrice();
			}
		}
		System.out.println("IT Category의 책 가격 합 : " + itSum);
		System.out.println("Nobel Category의 책 가격 합 : " + nobelSum);
		
	}
}
