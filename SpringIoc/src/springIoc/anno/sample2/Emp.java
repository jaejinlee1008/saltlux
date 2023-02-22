package springIoc.anno.sample2;

import org.springframework.stereotype.Component;

@Component
public class Emp {
	private String name;
	private int age;
	
	public Emp() {
		// TODO Auto-generated constructor stub
	}

	public Emp(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + "," + age;
	}
}
