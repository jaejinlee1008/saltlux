package java2;

import java.util.StringTokenizer;

public class StringTest {
	public static void main(String[] args) {
		String str="1.22,4.12,5.93,8.71,9.34";
		double data[]=new double[5];
		double sum=0.0;
		StringTokenizer st;
		st=new StringTokenizer(str,",");
		for(int i=0;st.hasMoreElements();i++)
		{
			data[i]=Double.parseDouble(st.nextToken());
		}
		for(int i=0;i<5;i++)
		{
			sum+=data[i];
		}
		
		System.out.println("합계 : " + String.format("%.3f", sum));
		System.out.println("평균 : " + sum/(double)data.length);
	}
}
