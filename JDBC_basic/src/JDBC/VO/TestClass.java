package JDBC.VO;

public class TestClass {
	private String Category;
	private String Department_Name;
	private int Capacity;
	
	public TestClass() {
		
	}

	public TestClass(String category, String department_Name, int capacity) {
		super();
		Category = category;
		Department_Name = department_Name;
		Capacity = capacity;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getDepartment_Name() {
		return Department_Name;
	}

	public void setDepartment_Name(String department_Name) {
		Department_Name = department_Name;
	}

	public int getCapacity() {
		return Capacity;
	}

	public void setCapacity(int capacity) {
		Capacity = capacity;
	}
	
	public String toString() {
		
		return Category + "| " + Department_Name + "| " + Capacity + "| " ;
		
	}
	
}
