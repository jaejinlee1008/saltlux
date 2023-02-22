package springIoc.anno.sample2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml",Emp.class);
		
		Engineer eng1 = context.getBean("myEng", Engineer.class);
		Engineer eng2 = context.getBean("myEng",Engineer.class);
		System.out.println(eng1);
		System.out.println(eng2);
		
		((ClassPathXmlApplicationContext)context).close();
	}
}