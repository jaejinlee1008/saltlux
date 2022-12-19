package workshop4;

public class Test04 {
	public static void main(String[] args) {
		int arr[][]=new int[Integer.parseInt(args[0])][Integer.parseInt(args[1])];
		double sum=0;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				arr[i][j]=(int)(Math.random()*10)%5+1;
				System.out.print(arr[i][j]+" ");
				sum+=arr[i][j];
			}
			System.out.println();
		}
		System.out.println("sum="+sum);
		System.out.println("avg="+sum/(Integer.parseInt(args[0])*Integer.parseInt(args[1])));
		
	}
}
