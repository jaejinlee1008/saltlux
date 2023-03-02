package my.spring.springweb.sample08;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestMappingConsumesController {
	
	Logger log = LogManager.getLogger("case3");
	
	@RequestMapping(value="/testController1", 
					method=RequestMethod.GET,
					consumes= {"application/json", "application/xml"}) //GET 방식일 때는 consumes 사용하면 안됨
					// GET방식은 request를 보낼때 body안에 data를 넣지 않기 때문에 content-type도 존재하지 않아서 받을 수 없음
	public String myMethod1() {
		
		log.debug("GET방식으로 호출되었어요");
		return null;
	}
	
	@RequestMapping(value = "/testController2", 
					method = RequestMethod.POST, 
					consumes = { "application/json","application/x-www-form-urlencoded" })
	public String myMethod2() {

		log.debug("POST방식으로 호출되었어요");
		return null;
	}
}
