package workshop6.calc;

class Calc
{
	public Calc() {
		// TODO Auto-generated constructor stub
	}
	
	public int calculate(int data)
	{
		int sum=0;
		for(int i=1;i<=data;i++)
		{
			if(i%2==0)
			{
				sum+=i;
			}
			
		}
		return sum;
	}
}

public class Test01 {
	public static void main(String[] args) {
		int A=Integer.parseInt(args[0]);

		if(A>=5&&A<=10)
		{
			Calc c = new Calc();
			System.out.println(c.calculate(A));
		}else
		{
			System.out.println("다시 입력하세요");
		}
		
	}
}
