package assignment;

import java.util.Arrays;

public class Test05 {
	public static void main(String[] args) {
		int sort[] = new int[3];
		sort[0]=Integer.parseInt(args[0]);
		sort[1]=Integer.parseInt(args[1]);
		sort[2]=Integer.parseInt(args[2]);
		
		System.out.println("입력값 : " + sort[0] + " " + sort[1] + " " + sort[2]);
		
		Arrays.sort(sort);
		
		System.out.println("최대값 : " + sort[2]);
		System.out.println("최소값 : " + sort[0]);
		
		
		
	}
}
