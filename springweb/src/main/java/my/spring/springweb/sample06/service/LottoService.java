package my.spring.springweb.sample06.service;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import my.spring.springweb.sample06.dao.LottoDao;
import my.spring.springweb.sample06.vo.Lotto;

@Service
public class LottoService {
	
	Logger log = LogManager.getLogger("case3");
	
	@Resource(name="lottoDao")
	private LottoDao dao;
	
	public LottoService() {
		// TODO Auto-generated constructor stub
	}
	public boolean checkLottoNumber(Lotto lotto) {
		// 일반적인 로직처리를 진행
		// DB처리->dao필요
		boolean result = false; // 당첨여부
		int randomNumber = dao.selectLottoNumber(); // dao를 이용해서 당첨번호를 알아온다.
		
		log.debug("내가 선택한 로또번호 : " + lotto.getLottoNum());
		log.debug("로또 당첨번호 : " + randomNumber);
		if(randomNumber==lotto.getLottoNum()) {
			result=true;
		}
		
		return result;
	}
}
