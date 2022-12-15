package java1;

class Tv
{
	public Tv() {
		
	}
	public Tv(String name,String description,int price)
	{
		this.name=name;
		this.description=description;
		this.price = price;
	}
	String name;
	String description;
	int price;
	
	public String toString()
	{
		String msg = name + "  " + Integer.toString(price) + "  " + description;
		return msg;
	}
	public int getPrice()
	{
		return price;
	}
}

public class TvTest {
	public static void main(String[] args) {
		Tv tvarr[] = new Tv[3];
		tvarr[0] = new Tv("INFINIA", "LED TV",1500000);
		tvarr[1] = new Tv("XCANVAS", "LCD TV",1000000);
		tvarr[2] = new Tv("CINEMA", "3D TV",2000000);
		int sum=0;
		for(int i=0;i<3;i++)
		{
			System.out.println(tvarr[i].toString());
			sum+=tvarr[i].getPrice();
		}
		System.out.println("가격의 합 : " + sum);
	}
}
