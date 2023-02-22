package springIoc.anno.sample1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml",Food.class);
		
		MyFoodMgr obj = context.getBean("myFood", MyFoodMgr.class);
		
		System.out.println(obj);
		
		((ClassPathXmlApplicationContext)context).close();
	}
}