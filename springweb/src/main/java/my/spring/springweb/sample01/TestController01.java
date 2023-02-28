package my.spring.springweb.sample01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController01 {

//	private static final Logger logger = LoggerFactory.getLogger(TestController01.class);
	
	// http://localhost:8080/springweb
	@RequestMapping(value="/testController01", method=RequestMethod.GET) 
	String myMethod() {
//		logger.debug("/springweb/testController01 호출");
		return "sample01/testController01";
	}
}
