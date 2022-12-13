package assignment;

public class Test01 {
	public static void main(String[] args) {
		double A,B;
		A=Double.parseDouble(args[0]);
		B=Double.parseDouble(args[1]);
		
		if(A%B<=1)
		{
			System.out.println("나머지가 1보다 작거나 같다!");
		}else
		{
			System.out.println("나머지가 1보다 크다!");
		}
	}
}
