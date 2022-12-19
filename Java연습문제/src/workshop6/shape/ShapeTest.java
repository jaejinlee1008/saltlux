package workshop6.shape;

abstract class Shape
{
	int width;
	int height;
	String colors;
	
	public Shape() {
		// TODO Auto-generated constructor stub
	}
	
	public Shape(int width,int height,String colors)
	{
		
	}
	
	public abstract double getArea();
	
}
interface Resize
{
	public void setResize(int size);
}

class Triangle extends Shape implements Resize
{
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return width*height*0.5;
	}
	@Override
	public void setResize(int size) {
		// TODO Auto-generated method stub
		height+=size;
	}
	public Triangle() {
		// TODO Auto-generated constructor stub
	}
	public Triangle(int width,int height,String colors)
	{
		this.width=width;
		this.height=height;
		this.colors=colors;
	}
}

class Rectangle extends Shape implements Resize
{
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return width*height;
	}
	@Override
	public void setResize(int size) {
		// TODO Auto-generated method stub
		width+=size;
	}
	public Rectangle() {
		// TODO Auto-generated constructor stub
	}
	public Rectangle(int width,int height,String colors)
	{
		this.width=width;
		this.height=height;
		this.colors=colors;
	}
}

public class ShapeTest {
	public static void main(String[] args) {
		Shape shape[] = new Shape[6];
		shape[0]=new Triangle(7,5,"Blue");
		shape[1]=new Rectangle(4,6,"Blue");
		shape[2]=new Triangle(6,7,"Red");
		shape[3]=new Rectangle(8,3,"Red");
		shape[4]=new Triangle(9,8,"White");
		shape[5]=new Rectangle(5,7,"White");
		System.out.println("기본 정보");
		for(int i=0;i<6;i++)
		{
			if(shape[i] instanceof Triangle)
			{
				System.out.printf("Triangle %.1f %s\n",shape[i].getArea(),shape[i].colors);
			}
			else if(shape[i] instanceof Rectangle)
			{
				System.out.printf("Rectangle %.1f %s\n",shape[i].getArea(),shape[i].colors);
			}
		}
		
		System.out.println("사이즈를 변경 후 정보");
		for(int i=0;i<6;i++)
		{
			if(shape[i] instanceof Triangle)
			{
				((Triangle)shape[i]).setResize(5);
			}
			else if(shape[i] instanceof Rectangle)
			{
				((Rectangle)shape[i]).setResize(5);
			}
		}
		for(int i=0;i<6;i++)
		{
			if(shape[i] instanceof Triangle)
			{
				System.out.printf("Triangle %.1f %s\n",shape[i].getArea(),shape[i].colors);
			}
			else if(shape[i] instanceof Rectangle)
			{
				System.out.printf("Rectangle %.1f %s\n",shape[i].getArea(),shape[i].colors);
			}
		}
	}
	
}


