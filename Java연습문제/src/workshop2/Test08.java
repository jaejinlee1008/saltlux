package workshop2;

public class Test08 {
	public static void main(String[] args) {
		int arr[]= {10,20,30,40,50};
		int sum=0;
		for(Integer i : arr)
		{
			sum+=i;
		}
		System.out.println("sum="+sum);
		System.out.println("avg="+sum/arr.length);
	}
}
