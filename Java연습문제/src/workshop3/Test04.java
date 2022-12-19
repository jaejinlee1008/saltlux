package workshop3;

public class Test04 {
	public static void main(String[] args) {
		int arr3[]=new int[5];
		int rand;
		int sum=0;
		boolean same=false;
		for(int i=0;i<arr3.length;i++)
		{
			rand=(int)(Math.random()*10)+1;
			for(int j=0;j<=i;j++)
			{
				if(arr3[j]==rand)
				{
					same=true;
					i--;
					break;
				}
			}
			if(!same)
			{
				arr3[i]=rand;
				
			}
			same=false;
		}
		
		for(int i=0;i<arr3.length;i++) { 
			System.out.print(arr3[i]+"  ");
			sum+=arr3[i];
		}
		 System.out.println();
		 System.out.println("sum="+sum);
		 System.out.println("avg="+sum/(double)arr3.length);
	}
}
