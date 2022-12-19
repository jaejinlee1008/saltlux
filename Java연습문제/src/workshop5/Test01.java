package workshop5;

public class Test01 {
	public static void main(String[] args) {
		String str=args[0];
		char ch[]=str.toCharArray();
		for(int i=ch.length-1;i>=0;i--)
		{
			System.out.print(ch[i]);
		}
	}
}
