package springIoc.sample10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml",DataBean.class);
		TestBean bean = context.getBean("myObj",TestBean.class);
		System.out.println(bean.getData1());
		System.out.println(bean.getData2());
	}
}
