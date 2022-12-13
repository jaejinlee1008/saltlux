package assignment;

public class Test08 {
	public static void main(String[] args) {
		int i=0;
		String newstr = "";
		while(i<args.length)
		{
			newstr +=args[i];
			i++;
		}
		newstr = newstr.toLowerCase();
		char[] arrch = newstr.toCharArray();
		for(int j = arrch.length-1; j>=0; j--)
		{
			System.out.print(arrch[j]);
		}
	}
}
