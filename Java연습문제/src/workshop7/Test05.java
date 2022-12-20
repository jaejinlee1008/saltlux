package workshop7;

public class Test05 {
	public static void main(String[] args) {
		String str="  [Beyond Promise.]  ";
		str=str.replaceAll(" ", "_");
		System.out.println(str);
		str=str.substring(2,str.length()-2);
		str=str.replace("_", " ");
		System.out.println(str);
		str=str.toUpperCase();
		System.out.println(str);
		str=str.toLowerCase();
		System.out.println(str);
		str=str.replaceAll("e", "a");
		str=str.replaceFirst("b", "B");
		str=str.replaceFirst("p", "P");
		System.out.println(str);
		str=str.substring(8,str.length()-2);
		str=str.replace("a", "e");
		System.out.println(str);
	}
}
