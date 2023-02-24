package my.spring.springweb.sample02.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

//@Setter
//@Getter
//@NoArgsConstructor
@AllArgsConstructor
//@ToString

@Data //위의 4개의 annotation을 모두 포함하는 annotation
public class User {
	private String userName;
	private int userAge;
	private String userDept;
	private String userAddress;
}
