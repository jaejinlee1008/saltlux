package springIoc.sample6;

public class ConsoleOutput implements Output {
	
	public ConsoleOutput() {
		System.out.println("ConsoleOutput default 생성자 호출");
	}
	
	@Override
	public void print(String message) throws Exception {
		System.out.println(message);
		
	}
}
