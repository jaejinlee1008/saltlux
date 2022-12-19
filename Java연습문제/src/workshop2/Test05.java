package workshop2;

public class Test05 {
	public static void main(String[] args) {
		int random=((int)(Math.random()*10))%6+1;
		for(int i=0;i<100;i++)
		{
			random=((int)(Math.random()*10))%6+1;
			System.out.println(random);
		}
	}
}
