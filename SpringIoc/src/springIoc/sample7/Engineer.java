package springIoc.sample7;

public class Engineer {
	private Emp emp;
	private String dept;
	
	public Engineer() {
		
	}
	
	public Engineer(Emp emp, String dept) {
		this.emp = emp;
		this.dept = dept;
	}
}
