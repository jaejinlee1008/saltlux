package my.spring.springweb.sample05;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import my.spring.springweb.sample05.vo.User;

@Controller
public class ModelAttributeController {
	Logger log = LogManager.getLogger("case3");
	
	
	// method에 @ModelAttribute를 지정할때는 이름을 지정해줘야한다.
	// 이 method는 handler가 호출되기 이전에 자동으로 호출된다.
	// 그리고 해당 메소드의 리턴값이 Model에 자동으로 등록된다.
	
	@ModelAttribute("v1")
	public String createString() {
		log.debug("문자열 객체 생성");
		return "이것은 소리없는 아우성";
	}
	
	@ModelAttribute("v2")
	public User createUser() {
		log.debug("VO 객체 생성");
		User user = new User(25,"홍길동","철학과");
		
		return user;
	}
	
	@ModelAttribute("data1")
	public int createNumber1() {
		log.debug("첫번째 숫자 생성");
		
		return 100;
	}
	
	@ModelAttribute("data2")
	public int createNumber2() {
		log.debug("두번째 숫자 생성");
		
		return 200;
	}
	
	@RequestMapping(value="modelAttributes1")
	public String myMethod1(@ModelAttribute("data1") int num1,
			@ModelAttribute("data2") int num2, Model model) {
		
		log.debug("handler 호출");
		log.debug(num1+num2);
		
		model.addAttribute("sum",num1+num2);
		return "sample05/modelResult";
	}
	
	@PostMapping(value="modelAttributes2")
	public String myMethod2(@ModelAttribute User user) {

		// 이렇게 클라이언트가 보내준 데이터로 객체를 생성할 수 있다
		// Command 객체라고 부른다. 대부분 VO를 이용해서 Command 객체를 생성
		
		// 순서
		// 1. 만약 class level에서 @sessionAttributes가 지정되어 있으면
		// 	  @ModelAttribute User user 이 코드는 session에서 찾는다
		//    지금 이 코드에선 @SessionAttributes사용하지 않고 있기에 이 부분은 스킵
		// 2. User의 생성자를 찾아호출해서 객체를 생성
		//	  public 생성자를 찾는다
		//	    생성자가 여러개면 그 중 인자가 가장 적은 생성자를 찾는다 -> 일반적으로 default 생성자가 선택된다.
		//    생성자를 이용해서 객체를 생성
		// 3. setter를 이용해서 클라이언트가 보내준 데이터를 VO에 저장한다.
		// 4. @ModelAttribute는 Model객체에 해당 vo를 저장해준다
		//    기본적으로는 class의 이름의 앞글자를 소문자로 만들어서 Model에 저장
		//    원한다면 이름을 지정해줄 수도 있다. @ModelAttribute("myUser") 이런 형식으로 이름 지정
		
		log.debug("handler 호출");
		

		return "sample05/modelResult";
	}
}
