package assignment;

public class Test07 {
	public static void main(String[] args) {
		double arr[] = new double[5];
		double result=0;
		for(int i=0;i<5;i++)
		{
			arr[i]= Double.parseDouble(args[i]);
		}
		result = ((arr[0]+arr[1])/2)*0.6 + ((arr[2]+arr[3])/2)*0.2 + arr[4]*0.2;
		System.out.println("평가점수" + result);
		
		switch ((int)result/10)
		{
		case 9:
			System.out.println("Class : Gold Class");
			break;
		case 8:
			System.out.println("Class : Siver Class");
			break;
		case 7:
			System.out.println("Class : Bronze class");
			break;
		default:
			System.out.println("Class : Normal Class");
		}
	}
}
