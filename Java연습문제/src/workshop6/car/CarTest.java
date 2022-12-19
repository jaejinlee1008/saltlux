package workshop6.car;

abstract class Car
{
	String name;
	String engine;
	int oilTank;
	int oilSize;
	int distance;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}
	public Car(String name, String engine,int oilTank,int oilSize,int distance)
	{
		this.name=name;
		this.engine=engine;
		this.oilTank=oilTank;
		this.oilSize=oilSize;
		this.distance=distance;
	}
	public abstract void go(int distance);
	public abstract void setOil(int oilSize);
}

interface Temp
{
	public int getTempGage();
}

class L3 extends Car implements Temp
{
	@Override
	public void go(int distance) {
		this.distance+=distance;
		while(distance>=10)
		{
			distance-=10;
			oilSize-=1;
		}
	}
	@Override
	public void setOil(int oilSize) {
		// TODO Auto-generated method stub
		this.oilSize+=oilSize;
	}
	@Override
	public int getTempGage() {
		int temp=0;
		while(distance>=10)
		{
			distance-=10;
			temp+=1;
		}

		return temp;
	}
	public L3() {
		// TODO Auto-generated constructor stub
	}
	public L3(String name,String engine,int oilTank,int oilSize,int distance)
	{
		this.name=name;
		this.engine=engine;
		this.oilSize=oilSize;
		this.oilTank=oilTank;
		this.distance=distance;
	}
}

class L5 extends Car implements Temp
{
	@Override
	public void go(int distance) {
		this.distance+=distance;
		while(distance>=8)
		{
			distance-=8;
			oilSize-=1;
		}
		
	}
	@Override
	public void setOil(int oilSize) {
		// TODO Auto-generated method stub
		this.oilSize+=oilSize;
	}
	@Override
	public int getTempGage() {
		int temp=0;
		while(distance>=10)
		{
			distance-=10;
			temp+=2;
		}

		return temp;
	}
	public L5() {
		// TODO Auto-generated constructor stub
	}
	public L5(String name,String engine,int oilTank,int oilSize,int distance)
	{
		this.name=name;
		this.engine=engine;
		this.oilSize=oilSize;
		this.oilTank=oilTank;
		this.distance=distance;
	}
}

public class CarTest {
	public static void main(String[] args) {
		Car car[]=new Car[2];
		car[0]=new L3("L3","1500",50,25,0);
		car[1]=new L5("L5","2000",75,35,0);
		System.out.printf("%s %s %d %d %d\n",car[0].name,car[0].engine,car[0].oilTank,car[0].oilSize,car[0].distance);
		System.out.printf("%s %s %d %d %d\n",car[1].name,car[1].engine,car[1].oilTank,car[1].oilSize,car[1].distance);
		
		car[0].setOil(25);
		car[1].setOil(25);
		
		System.out.printf("%s %s %d %d %d\n",car[0].name,car[0].engine,car[0].oilTank,car[0].oilSize,car[0].distance);
		System.out.printf("%s %s %d %d %d\n",car[1].name,car[1].engine,car[1].oilTank,car[1].oilSize,car[1].distance);
		car[0].go(80);
		car[1].go(80);
		System.out.printf("%s %s %d %d %d\n",car[0].name,car[0].engine,car[0].oilTank,car[0].oilSize,car[0].distance);
		System.out.printf("%s %s %d %d %d\n",car[1].name,car[1].engine,car[1].oilTank,car[1].oilSize,car[1].distance);
	}
}
