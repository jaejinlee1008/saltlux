package springIoc.anno.sample2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("myEng")
@Scope("prototype")
public class Engineer {
	
	@Autowired
	@Qualifier(value="emp1")
//	@Resource(name="emp1")
	private Emp emp;
	private String dept;
	
	public Engineer() {
		
	}
	
//	@Autowired
	public Engineer(Emp emp) {
		this.emp=emp;
		System.out.println("constructor 이용시");
	}
	
	@Autowired //(required=false) 사용불가 에러남
	public void my_dept(String dept) {
		this.dept=dept;
		System.out.println("일반 메소드");
	}
	
	/*
	 * @Override public String toString() { // TODO Auto-generated method stub
	 * return emp + dept; }
	 */
}
