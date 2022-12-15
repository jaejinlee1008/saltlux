package java2;

import java.util.HashMap;

abstract class Employee
{
	String name;
	int number;
	String department;
	int salary;
	
	public Employee() {
		
	}

	public Employee(String name, int number, String department, int salary) {
		super();
		this.name = name;
		this.number = number;
		this.department = department;
		this.salary = salary;
	}
	
	public abstract double tax();
	
}

interface Bonus
{
	public void incentive(int pay);
}

class Secretary extends Employee implements Bonus 
{
	
	public Secretary() {
		
	}
	
	public Secretary(String name,int number, String department,int salary)
	{
		this.name=name;
		this.number=number;
		this.department=department;
		this.salary=salary;
	}
	
	public double tax() {
		
		return (double)salary*0.1;
	}
	
	
	public void incentive(int pay) {
		this.salary += (int)((double)pay * 0.8);
		
	}
	public int getNumber()
	{
		return this.number;
	}
}

class Sales extends Employee implements Bonus
{
	public Sales() {
		
	}
	
	public Sales(String name,int number, String department,int salary)
	{
		this.name=name;
		this.number=number;
		this.department=department;
		this.salary=salary;
	}
	
	public double tax() {
		
		return (double)salary*0.13;
	}
	
	public void incentive(int pay) {
		this.salary += (int)((double)pay * 1.2);
	}
	public int getNumber()
	{
		return this.number;
	}
}

public class Company {
	public static void main(String[] args) {
		HashMap<Integer, Object> map = new HashMap<Integer,Object>();
		Secretary secretary = new Secretary("Hilery",1,"Secretary",800);
		Sales sales=new Sales("Clinten",2,"Sales",1200);
		map.put(secretary.getNumber(), secretary);
		map.put(sales.getNumber(), sales);
		//Sales s = (Sales)map.get(2);
		
		
		
		System.out.println("name            department     salary");
		System.out.println("-------------------------------------");
		for(Integer i : map.keySet())
		{
			if(map.get(i) instanceof Secretary)
			{
				
				System.out.println(((Secretary)map.get(i)).name + "          " + ((Secretary)map.get(i)).department + "        " + ((Secretary)map.get(i)).salary);
			}else if(map.get(i) instanceof Sales)
			{
				System.out.println(((Sales)map.get(i)).name + "          " + ((Sales)map.get(i)).department + "           " + ((Sales)map.get(i)).salary);
			}
		}
		System.out.println();
		System.out.println("인센티브 100 지급");
		System.out.println("name            department     salary     tax");
		System.out.println("---------------------------------------------");
		((Secretary)map.get(1)).incentive(100);
		((Sales)map.get(2)).incentive(100);
		for(Integer i : map.keySet())
		{
			if(map.get(i) instanceof Secretary)
			{
				
				System.out.println(((Secretary)map.get(i)).name + "          " + ((Secretary)map.get(i)).department + "        " + ((Secretary)map.get(i)).salary + "      " + ((Secretary)map.get(i)).tax());
			}else if(map.get(i) instanceof Sales)
			{
				System.out.println(((Sales)map.get(i)).name + "          " + ((Sales)map.get(i)).department + "           " + ((Sales)map.get(i)).salary + "     " + ((Sales)map.get(i)).tax());
			}
		}
		
		
		
	}
}
