package java2;

abstract class Plane{
	String planeName;
	int fuelSize;
	
	public Plane() {
		
	}
	
	public Plane(String planeName,int fuelSize)
	{
		this.planeName=planeName;
		this.fuelSize=fuelSize;
	}
	
	public void refuel(int fuel)
	{
		fuelSize+=fuel;
	}
	public abstract void flight(int distance);
}

class Airplane extends Plane
{

	public Airplane()
	{
		
	}
	
	public Airplane(String planeName,int fuelSize) {
		this.planeName=planeName;
		this.fuelSize=fuelSize;
	}
	
	public void flight(int distance) {
		
		while(distance>=10)
		{
			this.fuelSize-=30;
			distance-=10;
		}
	}
}

class Cargoplane extends Plane
{
	public Cargoplane() {
		
	}
	public Cargoplane(String planeName,int fuelSize)
	{
		this.planeName=planeName;
		this.fuelSize=fuelSize;
	}
	
	public void flight(int distance) {
		
		while(distance>=10)
		{
			this.fuelSize-=50;
			distance-=10;
		}
	}
}

public class PlaneTest {
	public static void main(String[] args) {
		Airplane air = new Airplane("L747", 1000);
		Cargoplane cargo = new Cargoplane("C40", 1000);
		
		System.out.println("Plane           fuelSize");
		System.out.println("------------------------");
		System.out.println(air.planeName+"              "+air.fuelSize);
		System.out.println(cargo.planeName+"               "+cargo.fuelSize);
		System.out.println();
		
		System.out.println("100운항");
		air.flight(100);
		cargo.flight(100);
		System.out.println("Plane           fuelSize");
		System.out.println("------------------------");
		System.out.println(air.planeName+"              "+air.fuelSize);
		System.out.println(cargo.planeName+"               "+cargo.fuelSize);
		System.out.println();
		
		System.out.println("200주유");
		air.refuel(200);
		cargo.refuel(200);
		System.out.println("Plane           fuelSize");
		System.out.println("------------------------");
		System.out.println(air.planeName+"              "+air.fuelSize);
		System.out.println(cargo.planeName+"               "+cargo.fuelSize);
		
		
	}
}
