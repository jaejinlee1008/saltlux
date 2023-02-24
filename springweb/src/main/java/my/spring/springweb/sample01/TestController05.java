package my.spring.springweb.sample01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/testController05")
public class TestController05 {
	private static final Logger logger = LoggerFactory.getLogger(TestController05.class);
	
	@GetMapping(params="myName") //GET방식으로 호출할 때 쿼리스트링에 myName이라는 key가 존재하면 이 handler를 호출
	String myMethod01() {
		
		logger.debug("testController05 호출 - myName");
		return "sample01/testController05";
	}
	
	@GetMapping(params="myName=신사임당") 
	String myMethod02() {
		// 조건에 맞는 handelr가 여러개면 더 자세한 handler를 호출, 이렇게 모호하게 사용하면 안된다.
		logger.debug("testController05 호출 - myName=신사임당"); 
		return "sample01/testController05";
	}
}
