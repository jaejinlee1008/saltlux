package Sample;

public class ExampleTest {
	public static void main(String[] args) {
		//프로그램 실행시
		//javac ExampleTest.java 만들어지고 이를 compile하면
		//결과로 bytecode인 ExampleTest.class 파일 생성
		//java ExampleTest 엔터 눌러서 실행
		//java ExampleTest 10 20
		System.out.println(args[0]+","+args[1]);
		
	}
}
