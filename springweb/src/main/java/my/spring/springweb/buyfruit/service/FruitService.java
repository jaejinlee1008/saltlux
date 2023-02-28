package my.spring.springweb.buyfruit.service;

import org.springframework.stereotype.Service;

import my.spring.springweb.buyfruit.vo.Fruit;

@Service
public class FruitService {


	public void plusApple(Fruit fruit) {
		
		fruit.setApple();
	}
	
	public void plusBanana(Fruit fruit) {
		
		fruit.setBanana();
	}

	public void plusHalabong(Fruit fruit) {
	
		fruit.setHalabong();
	}

}
