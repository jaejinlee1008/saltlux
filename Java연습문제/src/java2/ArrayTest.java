package java2;

public class ArrayTest {
	public static void main(String[] args) {
		int arr[][] = {
				{12,41,36,56},
				{82,10,12,61},
				{14,16,18,78},
				{45,26,72,23}
		};
		double sum=0.0;
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				sum+=(double)arr[i][j];
			}
		}
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + sum/16.0);
	}
}
