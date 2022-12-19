package workshop6.calculator;

class Calculator
{
	public Calculator() {
		// TODO Auto-generated constructor stub
	}
	
	public double plus(int a,int b)
	{
		return a+b;
	}
	public double minus(int a,int b)
	{
		return a-b;
	}
	public double multiplication(int a,int b)
	{
		return a*b;
	}
	
	public double divide(int a,int b)
	{
		try {
			return a/(double)b;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("분모 0");
			return 0;
		}
		
	}
}

public class CalcTest {
	public static void main(String[] args) {
		int A=Integer.parseInt(args[0]);
		char ch= args[1].charAt(0);
		int B=Integer.parseInt(args[2]);
		
		Calculator calc=new Calculator();
		switch (ch)
		{
		case '+':
			System.out.printf("결과: %.1f",calc.plus(A, B));
			break;
		case '-':
			System.out.printf("결과: %.1f",calc.minus(A, B));
			break;
		case 'x':
			System.out.printf("결과: %.1f",calc.multiplication(A, B));
			break;
		case '/':
			System.out.printf("결과: %.1f",calc.divide(A, B));
			break;
			default:
				System.out.println("잘못입력했습니다.");
				break;
		}
	}
}
