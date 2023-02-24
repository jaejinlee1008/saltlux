package my.spring.springweb.sample01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/testController07")
public class TestController07 {
	private static final Logger logger = LoggerFactory.getLogger(TestController07.class);
	
	@GetMapping
	public String myMethod1(Model model) {
		
		
		// Model 객체가 주입된다. (applicationContext에 의해)
		// Model은 Map으로 되어있다 - key:value 형태로 데이터 저장
		logger.debug("TestController07 호출");
		model.addAttribute("myName","홍길동");
		model.addAttribute("myAge",20);
		
		return "sample01/testController07";
		
	}
}
