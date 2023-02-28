package my.spring.springweb.sample06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import my.spring.springweb.sample06.service.LottoService;
import my.spring.springweb.sample06.vo.Lotto;

@Controller
public class LottoController {
	
	@Autowired
	private LottoService service;
	
	@GetMapping(value="/lotto")
	public String lottoProcess(@ModelAttribute Lotto lotto) {
		
		// 서비스 객체를 만들어서 로직을 처리해야 한다
		boolean result = service.checkLottoNumber(lotto);
		if(result) {
			lotto.setResult("당첨입니다");
		}else {
			lotto.setResult("될리가 없죠");
		}
		return "sample06/lottoView";
	}
}
