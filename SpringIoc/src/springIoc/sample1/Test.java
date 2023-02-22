package springIoc.sample1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		// ApplicationContext부터 생성해보아요!
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml", 
						MessageBean.class);
		
		System.out.println("===== IoC/DI 컨테이너 생성 =====");
		
		// scope가 singleton인 경우는 이미 context안에 존재하는 Bean을 찾아서 리턴하고
		// scope가  prototype인 경우는 이 시점에 Bean객체를 생성해서 리턴해요!
		MessageBean myBean = context.getBean("messageBean", MessageBean.class);
		
		myBean.sayHello(); // 딸기 : 3000 
		
		System.out.println(myBean);
		System.out.println(context.getBean("messageBean", MessageBean.class));
		
		((ClassPathXmlApplicationContext)context).close();
		
	}
}
