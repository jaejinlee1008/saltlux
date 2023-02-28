package my.spring.springweb.sample01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// client request method에 따른 handler 호출

@Controller
@RequestMapping(value="/testController03")
public class TestController03 {
//	private static final Logger logger = LoggerFactory.getLogger(TestController03.class);
	
	@RequestMapping(value="",method=RequestMethod.GET)
	String myMethod01() {
		
		
		return null;
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	String myMethod02() {
		
		
		return null;
	}
}
