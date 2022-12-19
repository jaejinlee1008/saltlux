package workshop2;

public class Test06 {
	public static void main(String[] args) {
		for(int i=2;i<=8;i+=3)
		{
			for(int j=1;j<=3;j++)
			{
				if(i!=8)
				{
					System.out.printf("%d*%d-=%-2d %d*%d=%-2d %d*%d=%-2d\n",i,j,i*j,i+1,j,(i+1)*j,i+2,j,(i+2)*j);
				}else
				{
					System.out.printf("%d*%d-=%-2d %d*%d=%-2d\n",i,j,i*j,i+1,j,(i+1)*j);
				}
				
			}
		}
	}
}
