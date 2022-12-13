package Sample;

interface myInterface{
	void aa();
}

class MyClass implements myInterface{
	public void aa() {
		
	}
}

public class InterfaceTest {
	public static void main(String[] args) {
		myInterface a = new MyClass();
	}
}
