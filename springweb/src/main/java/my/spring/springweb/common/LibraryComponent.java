package my.spring.springweb.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;

// 수동으로 Bean을 Application context에 등록하려면
// @Bean을 사용해야함

@Configuration
public class LibraryComponent {
	
	@Bean
	public Gson getGson() {
		return new Gson();
	}
}
