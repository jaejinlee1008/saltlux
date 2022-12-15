package com.lgcns.calc;

class Calc
{
	public int sum(int a,int b)
	{
		return a+b;
	}
	
	public int substract(int a, int b)
	{
		return a-b;
	}
	public int multiply(int a, int b)
	{
		return a*b;
	}
	public int divide(int a, int b)
	{
		if(b>0)
		{
			return a/b;
		}else
		{
			return 0;
		}
	}
}

public class CalcTest {
	public static void main(String[] args) {
		Calc c = new Calc();
		int A = Integer.parseInt(args[0]);
		int B = Integer.parseInt(args[1]);
		System.out.println("합 : " + c.sum(A, B));
		System.out.println("차 : " + c.substract(A, B));
		System.out.println("곱 : " + c.multiply(A, B));
		System.out.println("나누기 : " + c.divide(A, B));
	}
}
