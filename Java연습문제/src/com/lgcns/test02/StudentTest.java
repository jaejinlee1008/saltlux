package com.lgcns.test02;

class Human
{
	public Human() {
		
	}
	
	public Human(String name,int age, int height,int weight)
	{
		this.name=name;
		this.age=age;
		this.height=height;
		this.weight=weight;
	}
	
	String name;
	int age;
	int height;
	int weight;
	
	public String printInformation()
	{
		String msg=name + " " + Integer.toString(age) + " " + Integer.toString(height) + " " + Integer.toString(weight);
		return msg;
	}
}

class Student extends Human
{
	public Student() {
		
	}
	
	public Student(String name,int age,int height, int weight,String number,String major)
	{
		this.name=name;
		this.age=age;
		this.height=height;
		this.weight=weight;
		this.number=number;
		this.major=major;
	}
	
	String number;
	String major;
	
	public String printInformation()
	{
		
		String msg=super.printInformation() + " " + number + " " + major;
		return msg;
	}
}

public class StudentTest {
	public static void main(String[] args) {
		Student arrays[] = new Student[3];
		arrays[0]=new Student("홍길동",15,171,81,"201101","영문");
		arrays[1]=new Student("한사람",13,183,72,"201102","건축");
		arrays[2]=new Student("임걱정",16,175,65,"201103","무역");
		
		for(int i=0;i<arrays.length;i++)
		{
			System.out.println(arrays[i].printInformation());
		}
	}
}
