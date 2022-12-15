package java2;

import java.util.ArrayList;
import java.util.Collections;

public class ListTest {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<10;i++)
		{
			list.add((int)(Math.random()*10)+1);
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
		Collections.sort(list);
		
		for(Integer i:list)
		{
			System.out.print(i+" ");
		}
	}
}
