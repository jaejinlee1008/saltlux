package my.spring.springweb.sample07;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import my.spring.springweb.sample07.vo.Student;

@Controller
@SessionAttributes({"data1"})
@RequestMapping(value="/sessionAttributesTest02")
public class SessionAttributesController02 {

	
	Logger log = LogManager.getLogger("case3");
	
	// handler가 호출되기 이전에 아래의 메소드가 호출됨
	// data1이라는 key로 메소등의 리턴값이 Model에 저장됨
	@ModelAttribute("data1")
	public String createString1() {
		log.debug("createString1() 호출됨");
		return "createString1";
	}
	
	@ModelAttribute("data2")
	public String createString2(HttpServletRequest request) {
		// session을 직접 이용
		HttpSession session = request.getSession(true);
		
		Student student = new Student(30,"신사임당","국어국문");
		
		session.setAttribute("shin", student);
		
		log.debug("createString2() 호출됨");
		return "createString2";
	}
	
	@PostMapping
	public String handler(@ModelAttribute("data1") String str1,
			@ModelAttribute("data2") String str2,
			@RequestParam(value="msg") String requestMsg,
			@ModelAttribute("newStudent") Student studentVO) {
		
		log.debug("handelr()에서 출력 : " + str1 + "," + str2);
		log.debug("msg : " + requestMsg);
		log.debug("student : " + studentVO);
		return "sample07/sessionResult02";
	}
}
