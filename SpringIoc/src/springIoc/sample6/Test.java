package springIoc.sample6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		
		// Application Context를 생성
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml",Output.class);
		
		MessageBean bean1 = context.getBean("myBean", MessageBean.class);
		
		bean1.sayHello(); // 설정에 따라 console에 출력할수도 있고 파일에 출력할 수 도 있다.
		
		MessageBean bean2 = context.getBean("myBeanConsole", MessageBean.class);
		
		bean2.sayHello();
		
		((ClassPathXmlApplicationContext)context).close();
		
	}
}
