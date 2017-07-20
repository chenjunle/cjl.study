package study.springmvc4.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer{

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(MyWebConfig.class);
		context.setServletContext(servletContext);
		Dynamic dynamic = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(context));
		dynamic.addMapping("/");
		dynamic.setLoadOnStartup(1);
	}

}
