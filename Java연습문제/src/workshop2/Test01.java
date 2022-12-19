package workshop2;

public class Test01 {
	public static void main(String[] args) {
		int x=15;
		if(x>10&&x<20)
		{
			System.out.println("true");
		}
		char ch1=' ';
		if(Character.compare(ch1, ' ')!=0||Character.compare(ch1, '\t')!=0)
		{
			System.out.println("true");
		}
		char ch2='x';
		if(Character.compare(ch2, 'x')==0||Character.compare(ch2, 'X')==0)
		{
			System.out.println("true");
		}
		char ch3='0';
		if(Character.compare(ch3, '0')>=0 && Character.compare(ch3, '9')<=0)
		{
			System.out.println("true");
		}
		char ch4='a';
		if((Character.compare(ch4, 'a')>=0 && Character.compare(ch4, 'z')<=0) || (Character.compare(ch4, 'A')>=0 && Character.compare(ch4, 'Z')<=0))
		{
			System.out.println("true");
		}
		int year=400;
		if(year%400==0||(year%4==0&&year%100!=0))
		{
			System.out.println("true");
		}
		boolean powerOn=false;
		if(!powerOn)
		{
			System.out.println("true");
		}
		String str="yes";
		if(str.compareTo("yes")==0)
		{
			System.out.println("true");
		}
	}
}
