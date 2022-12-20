package workshop7;

import java.util.StringTokenizer;

public class Test04 {
	public static void main(String[] args) {
		String str="I am second to none";
		StringTokenizer st = new StringTokenizer(str," ");
		int wordcount=0;
		int charcount=0;
		while(st.hasMoreTokens())
		{
			wordcount++;
			charcount+=st.nextToken().length();
		}
		System.out.printf("문자개수 : %d\n",charcount);
		System.out.printf("단어개수 : %d\n",wordcount);
	}
}
