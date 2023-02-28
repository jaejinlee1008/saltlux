package my.spring.springweb.sample06.dao;

import java.util.Random;

import org.springframework.stereotype.Repository;

@Repository("lottoDao")
public class LottoDao {

	public LottoDao() {
		// TODO Auto-generated constructor stub
	}
	
	public int selectLottoNumber() {
		
		Random rand = new Random();
		return rand.nextInt(6) + 1; // 1~6까지의 정수형 난수를 발생
		

	}

}
