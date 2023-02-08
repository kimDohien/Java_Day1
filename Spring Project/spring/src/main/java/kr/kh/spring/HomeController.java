package kr.kh.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
//	http://localhost:8080/spring/
	
	@RequestMapping(value = "/")
	public ModelAndView home(ModelAndView mv,String name, Integer age) {
		System.out.println(name);
		mv.addObject("name1", name) ;//(화면에서 불릴 이름 , 보내는 이름)
		mv.addObject("age",age); //(앞 이름, 뒤 이름) 을 맞춰줘야 한다.
		mv.setViewName("home");//연결
		return mv;
	}
	@RequestMapping(value = "/board/{num}")
	public ModelAndView board(ModelAndView mv, @PathVariable("num")Integer num1) {
		System.out.println("게시글 번호 : "+ num1);
		mv.setViewName("home");
		return mv;
	}
	@RequestMapping(value = "/test")
	public ModelAndView test(ModelAndView mv, InfoVO info) {
		mv.addObject("info1",info);
		mv.setViewName("home2");
		return mv;
	}
	@RequestMapping(value = "/login")
	public ModelAndView login(ModelAndView mv, LoginVO login) {
		System.out.println(login);
		mv.addObject("login1",login);
		mv.setViewName("login");
		return mv;
	}
}
