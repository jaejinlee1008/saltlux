package workshop1;

public class Test04 {
	public static void main(String[] args) {
		char ch='v';
		boolean b;
		if((Character.compare(ch, 'a')>=0 && Character.compare(ch, 'z')<=0) || (Character.compare(ch, 'A')>=0 && Character.compare(ch, 'Z')<=0))
		{
			b=true;
		}else
		{
			b=false;
		}
		System.out.println(b);
	}
}
