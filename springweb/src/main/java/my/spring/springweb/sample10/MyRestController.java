package my.spring.springweb.sample10;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/rest/user",produces="application/json")
public class MyRestController {
	
	Logger log = LogManager.getLogger("case3");
	
	@GetMapping
	public ResponseEntity<Map<String,String>> method01(String id, String name){
		
		log.debug("Get방식으로 호출됨");
		log.debug(id + "," + name);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("name", name);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application","json",
				Charset.forName("UTF-8")));
		// 결국 responseEntitiy가 덮어 씌우기 때문에 produces속성에 어떤 값이 써있든 상관없이 헤더에 쓰인 값으로 출력됨
		
		return new ResponseEntity<Map<String,String>>(map,headers,HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<?> method02(String id, String name){
		
		log.debug("Delete방식으로 호출됨");
		log.debug(id + "," + name);
		
		return null;
	}
}
