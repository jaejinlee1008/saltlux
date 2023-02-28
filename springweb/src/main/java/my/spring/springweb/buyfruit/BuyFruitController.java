package my.spring.springweb.buyfruit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import my.spring.springweb.buyfruit.service.FruitService;
import my.spring.springweb.buyfruit.vo.Fruit;

@Controller
@SessionAttributes(value= {"myFruit"})
public class BuyFruitController {
	
	@Autowired
	private FruitService service;
	
	@ModelAttribute("myFruit")
	public Fruit createFruit() {
		Fruit fruit = new Fruit();
		return fruit;
	}
	
	@GetMapping(value="apple")
	public String handler1(@ModelAttribute("myFruit") Fruit fruit) {
		Logger log = LogManager.getLogger("case3");
		
//		log.debug(selectedFruit);
		service.plusApple(fruit);
		
		return "buyfruit/shoppingbasket";
	}
	
	@GetMapping(value="banana")
	public String handler2(@ModelAttribute("myFruit") Fruit fruit) {
		Logger log = LogManager.getLogger("case3");
		
//		log.debug(selectedFruit);
		service.plusBanana(fruit);
		
		return "buyfruit/shoppingbasket";
	}
	
	@GetMapping(value="halabong")
	public String handler3(@ModelAttribute("myFruit") Fruit fruit) {
		Logger log = LogManager.getLogger("case3");
		
//		log.debug(selectedFruit);
		service.plusHalabong(fruit);
		
		return "buyfruit/shoppingbasket";
	}
	
	@PostMapping(value="confirmation")
	public String handler4(@ModelAttribute("myFruit") Fruit fruit,
			SessionStatus sessionStatus) {
		
		
		sessionStatus.setComplete();
		
		return "redirect:/resources/buyfruit/buyFruit.html";
	}
}
