package my.spring.springweb.buyfruit.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Fruit {
	private int apple;
	private int banana;
	private int halabong;
	public void setApple() {
		this.apple += 1;
	}
	public void setBanana() {
		this.banana += 1;
	}
	public void setHalabong() {
		this.halabong += 1;
	}
	
	
}
