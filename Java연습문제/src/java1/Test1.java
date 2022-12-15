package java1;

public class Test1 {
	public static void main(String[] args) {
		int A = Integer.parseInt(args[0]);
		
		if(A%2==0)
		{
			System.out.println("2의 배수 입니다.");
		}else
		{
			System.out.println("2의 배수가 아닙니다.");
		}
	}
}
