package java2;

import java.util.HashMap;

public class HashMapTest {
	public static void main(String[] args) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		double sum=0.0;
		for(int i=1;i<=10;i++)
		{
			map.put(i, (int)(Math.random()*100)+1);
		}
		for(int i=1;i<=10;i++)
		{
			System.out.print(map.get(i) + " ");
		}
		for(int i=1;i<10;i++)
		{
			sum+=(double)map.get(i);
		}
		System.out.println();
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + sum/map.size());
	}
}
