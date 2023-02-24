package my.spring.springweb.sample01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// 일반적으로 RequestMapping은 class level에서 사용
@Controller
@RequestMapping(value="testController04")
public class TestController04 {
	private static final Logger logger = LoggerFactory.getLogger(TestController04.class);
	
	@GetMapping
	String myMethod01() {
		
		logger.debug("testController04-Get 호출됨");
		return "sample01/testController04";
	}
	
	@PostMapping
	String myMethod02() {
		
		logger.debug("testController04-Post 호출됨");
		return "sample01/testController04";
	}
	
	@GetMapping(value="/test001")
	String myMethod03() {
		
		logger.debug("testController04-Get,test001 호출됨");
		return "sample01/testController04";
	}
}
