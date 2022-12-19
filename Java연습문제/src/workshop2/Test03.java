package workshop2;

public class Test03 {
	public static void main(String[] args) {
		int i=0;
		int j=0;
		while(i<=10)
		{
			while(j<=i)
			{
				System.out.print("*");
				j++;
			}
			System.out.println();
			j=0;
			i++;
		}
	}
}
