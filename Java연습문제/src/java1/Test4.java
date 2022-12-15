package java1;

public class Test4 {
	public static void main(String[] args) {
		double result =0.0;
		int i=1;
		while(i<=100)
		{
			result+=(double)i;
			i++;
		}
		System.out.println("합계 : "+result);
		System.out.println("평균 : " + result/100.0);
	}
}
