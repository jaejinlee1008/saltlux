package java1;

public class Test2 {
	public static void main(String[] args) {
		int A = Integer.parseInt(args[0]);
		int B = Integer.parseInt(args[1]);
		
		if((A*B)/10==0)
		{
			System.out.println("한자리 수 입니다.");
		}else
		{
			System.out.println("두자리 수 입니다.");
		}
	}
}
