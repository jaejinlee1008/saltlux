package springIoc.sample7;

public class Developer extends Emp {
	private String dept;
	
	public Developer() {
		// TODO Auto-generated constructor stub
	}

	public Developer(String name, int salary, String dept) {
		super(name,salary);
		this.dept = dept;
	}
	
}
