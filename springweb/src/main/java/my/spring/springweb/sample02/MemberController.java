package my.spring.springweb.sample02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import my.spring.springweb.sample02.vo.Member;

@Controller
public class MemberController {

//	private static final Logger logger = LoggerFactory.getLogger(TestController05.class);
	
	@PostMapping(value="member1")
	public ModelAndView myMethod1(
			@RequestParam(value="name", defaultValue="없음") String name,
			@RequestParam(value="phone", defaultValue="없음") String phone,
			String id, // parameter name과 request로 넘어오는 값의 이름이 같으면 생략 가능
			@RequestParam(value="password", defaultValue="없음") String password,
			Model model) {
		
		ModelAndView mav = new ModelAndView();
		// addObject하면 model에 들어가는게 아니고 request객체에 들어간다.
//		mav.addObject("name", name);
//		mav.addObject("id", id);
//		mav.addObject("phone", phone);
//		mav.addObject("password", password);
		
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("phone", phone);
		model.addAttribute("password", password);
		
		mav.setViewName("sample02/memberView");
		
		return mav;
	}
	
	@PostMapping(value="member2")
	public ModelAndView myMethod2(@ModelAttribute Member vo) { // client가 보내준 data와 vo의 필드값이 일치하면 자동으로 vo에 저장되어 받을 수 있다.
		
//		logger.debug(vo.toString());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("memberVO",vo);
		
		mav.setViewName("sample02/memberView");
		
		return mav;
	}
	
	@PostMapping(value="member3")
//	public String myMethod3(@ModelAttribute Member vo) { // 자동으로 model에 vo가 들어간다, key값으로는 class이름이 앞 글자만 소문자로 바꿔서 들어간다
														 // member(key) : vo(value)의 형태
	public String myMethod3(@ModelAttribute(value="mem") Member vo) { //value를 이용해 key 이름 직접 설정 가능	
//		logger.debug(vo.toString());
		
		
		
		return "sample02/memberView";
	}
	
	@PostMapping(value="member4")
	public String myMethod4(Member vo,String addr) {
//		logger.debug(vo.toString());
//		logger.debug(addr);
		
		
		return "sample02/memberView";
	}
}
