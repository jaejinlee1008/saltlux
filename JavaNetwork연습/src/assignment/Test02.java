package assignment;

public class Test02 {
	public static void main(String[] args) {
		int A, result;
		A=Integer.parseInt(args[0]);
		result = 1;
		for(int i=1;i<=A;i++)
		{
			result*=i;
			if(i<A)
			{
				System.out.print(i+"*");
			}else if(i==A)
			{
				System.out.print(i);
			}
		}
		
		System.out.print("=" + result);
	}
}
