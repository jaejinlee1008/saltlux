package workshop3;

class Calc
{
	public Calc() {
		// TODO Auto-generated constructor stub
	}
	
	public int calcSum(int a, int b, int c, int d)
	{
		return a+b+c+d;
	}
}

public class Test05 {
	public static void main(String[] args) {
		Calc c= new Calc();
		int sum = c.calcSum(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
		double avg=sum/4.0;
		System.out.println("sum="+sum);
		System.out.println("avg="+avg);
		switch((int)(avg/10.0))
		{
		case 10:
		case 9:
			System.out.println("A");
			break;
		case 8:
		case 7:
			System.out.println("B");
			break;
		case 6:
		case 5:
			System.out.println("C");
			break;
		case 4:
		case 3:
			System.out.println("D");
			break;
			default:
				System.out.println("F");
		
		}
	}
}
