package my.spring.springweb.sample09;

import java.nio.charset.Charset;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.spring.springweb.sample09.vo.User;

@RestController //@RestController로 지정하면 모든 method에 @ResponseBody가 붙는다
@RequestMapping(value="body")
public class ResponseBodyController {

	@RequestMapping(value="text/{id}", produces="text/plain; charset=UTF-8")
//	@ResponseBody
	public String method01(@PathVariable String id) {
		
		return "<h1>이것은 소리없는 아우성" + id + "</h1>";
	}
	
	@RequestMapping(value="textObject/{id}", produces="text/plain; charset=UTF-8")
//	@ResponseBody
	public ResponseEntity<String> method02(@PathVariable String id) {
		
		String msg="<h1>이것은 소리없는 아우성" + id + "</h1>";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text","html",
				Charset.forName("UTF-8")));
		// 결국 responseEntitiy가 덮어 씌우기 때문에 produces속성에 어떤 값이 써있든 상관없이 헤더에 쓰인 값으로 출력됨
		
		return new ResponseEntity<String>(msg,headers,HttpStatus.OK);
	}
	
	@RequestMapping(value="json/{name}", produces="application/json; charset=UTF-8")
//	@ResponseBody
	public User method03(@PathVariable String name) {
		
		User user = new User();
		user.setName(name);
		user.setAddr("서울");
		
		return user;
	}
}
