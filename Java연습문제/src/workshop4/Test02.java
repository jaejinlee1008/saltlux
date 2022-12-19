package workshop4;

class Calc
{
	int sum=0;
	public Calc() {
		// TODO Auto-generated constructor stub
	}
	
	public int calculate(int data)
	{
		System.out.print("짝수:");
		for(int i=1;i<=data;i++)
		{
			if(i%2==0)
			{
				System.out.print(i + " ");
				sum+=i;
			}
		}
		System.out.println();
		return sum;
	}
}

public class Test02 {
	public static void main(String[] args) {
		Calc c=new Calc();
		System.out.println("결과:" + c.calculate(Integer.parseInt(args[0])));
		
	}
}
