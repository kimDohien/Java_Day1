package kr.kh.test.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.test.vo.MemberVO;
import kr.kh.test.service.MemberService;


@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv,Integer num) {
		String id = memberService.selectMemberName(num);
		mv.setViewName("/main/home");
		return mv ;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signup(ModelAndView mv) {
		mv.setViewName("/member/signup");
		return mv ;
	}	
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv , MemberVO member) {
		boolean isSignup = memberService.signup(member); //회원가입 성공했는지 물어보기	
		if(isSignup) {
			//성공했다고 알림 메시지(추후 구현 예정)
			mv.setViewName("redirect:/"); //성공하면 메인페이지
		}else {
			//실패했다고 알림 메시지(추후 구현 예정)
			mv.setViewName("redirect:/signup");//연결실패
			return mv;
		}	
		return mv;
	}
	

	
}
