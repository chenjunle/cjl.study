package study.startpom.hello.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="cjl.hello")
public class HelloProperties {

	private static final String defaultName = "world";
	
	private String name = defaultName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
