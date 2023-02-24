package my.spring.springweb.sample02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/calc.do")
public class CalcController {
	private static final Logger logger = LoggerFactory.getLogger(CalcController.class);
	
	@PostMapping
	public ModelAndView process(@RequestParam("firstNum") int num1,
			int secondNum, String operator) {
		//@RequestParam("key값") 사용시 뒤에 오는 인자에 해당 키의 value값을 형변환해서 넣어준다,
		//인자의 변수명과 파라미터로 넘어오는 key값의 이름이 같으면 @RequestParam을 생략할 수 있다.
		
		//@RequestParam("")을 이용해서 받는다. (String포함해서 primitive type(기본타입)인 경우)
		ModelAndView mav = new ModelAndView();
		String viewName = "";
		
		if(operator.equals("div")&&secondNum==0) {
			// 분모가 0인 나눗셈 -> 무한대, java는 무한대 개념이 없음 -> Exception
			viewName = "sample02/errorResult";
			mav.addObject("msg","0으로 나눌 수 없음");
		}else {
			int result=0;
			if(operator.equals("plus")) {
				result=num1+secondNum;
			}else if(operator.equals("minus")) {
				result=num1-secondNum;
			}else if(operator.equals("mul")) {
				result=num1*secondNum;
			}else if(operator.equals("div")) {
				result=num1/secondNum;
			}
			viewName = "sample02/calcResult";
			mav.addObject("msg",result);
		}
		mav.setViewName(viewName);
		return mav;
	}
}
