package my.spring.springweb.sample07;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import my.spring.springweb.sample07.vo.Student;

@Controller
@SessionAttributes({"data1","shin","newStudent"})
@RequestMapping(value="/sessionAttributesTest05")
public class SessionAttributesController05 {

	
	Logger log = LogManager.getLogger("case3");
	
	// handler가 호출되기 이전에 아래의 메소드가 호출됨
	// data1이라는 key로 메소등의 리턴값이 Model에 저장됨
	@ModelAttribute("data1")
	public String createString1() {
		log.debug("createString1() 호출됨");
		return "createString1";
	}
	
	@ModelAttribute("data2")
	public String createString2(Model model) {
		
		Student student = new Student(30,"신사임당","국어국문");
		model.addAttribute("shin",student);
		
		log.debug("createString2() 호출됨");
		return "createString2";
	}
	
	@PostMapping
	public String handler(@ModelAttribute("data1") String str1,
			@ModelAttribute("shin") Student student,
			@RequestParam(value="msg") String requestMsg,
			@ModelAttribute("newStudent") Student studentVO) {
			// @ModelAttribute("newStudent")은 session에 newStudent가 있는지를 먼저 확인한다.
			// 위에서 @SessionAttributes({"data1","shin","newStudent"}) 로 newStudent를 지정해주었기 때문에
			// 새로운 studentVO를 만들어서 command객체를 만드는 것이 아닌 session에 있는 newStudent라는 키값의 객체를 가져오려고 한다.
			// 하지만 현재 newStudent에 넣어준 값이 없기에 에러 발생
		log.debug("handelr()에서 출력 : " + str1 + "," + student);
		log.debug("msg : " + requestMsg);
		log.debug("student : " + studentVO);
		return "sample07/sessionResult05";
	}
}
