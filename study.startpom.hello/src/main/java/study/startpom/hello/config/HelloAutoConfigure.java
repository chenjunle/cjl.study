package study.startpom.hello.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import study.startpom.hello.properties.HelloProperties;
import study.startpom.hello.service.HelloService;

@Configuration
@EnableConfigurationProperties(HelloProperties.class)
@ConditionalOnClass(HelloService.class)
@ConditionalOnProperty(prefix="cjl.hello",value="enabled",matchIfMissing=true)
public class HelloAutoConfigure {

	@Autowired
	private HelloProperties helloProperties;
	
	@ConditionalOnMissingClass("HelloService")
	@Bean
	public HelloService helloService(){
		HelloService helloService = new HelloService();
		helloService.setMsg(helloProperties.getName());
		return helloService;
	}
	
}
