package workshop2;

public class Test07 {
	public static void main(String[] args) {
		int num=Integer.parseInt(args[0]);
		int tmp=num;
		int sum=0;
		while(num<=100)
		{
			sum+=num;
			num+=tmp;
		}
		System.out.println(sum);
	}
}
