package my.spring.springweb.sample02.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private String name;
	private String phone;
	private String id;
	private String password;
	
	
}
