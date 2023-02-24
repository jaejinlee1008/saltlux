package my.spring.springweb.sample01;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/testController02")
public class TestController02 {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController02.class);
	
	@RequestMapping("/info")
	String myMethod01() {
		logger.debug("/testController02/info 호출");
		return "sample01/testController02";
	}
	
	@RequestMapping("/profile")
	String myMethod02() {
		logger.debug("/testController02/profile 호출");
		return "sample01/testController02";
	}
	
	@RequestMapping(value= {"","/test01","test02","test03/*"}) // 여러개의 URL 하나의 handler에서 배열처럼 처리 가능
	String myMethod03() {
		logger.debug("/testController02/멀티 호출");
		return "sample01/testController02";
	}
}
