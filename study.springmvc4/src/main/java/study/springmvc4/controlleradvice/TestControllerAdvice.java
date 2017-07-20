package study.springmvc4.controlleradvice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class TestControllerAdvice {

	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public String exceptionHandler(Exception ex){
		return ex.getMessage();
	}
	
	@ModelAttribute
	public void addAttribute(Model model){
		model.addAttribute("msg", "来自星星的消息");
	}
	
	@InitBinder
	public void init(WebDataBinder binder){
		binder.setDisallowedFields("name");
	}
	
}
