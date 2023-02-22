package kr.kh.test.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.test.vo.MemberOKVO;
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
	
	
	
	
	@RequestMapping(value= "/login", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView mv) {
		mv.setViewName("/member/login");
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, MemberVO member) {
		MemberVO user = memberService.login(member);
		//회원정보가 있으면
		//인증한 회원들만 로그인 하도록
		if(user != null && user.getMe_authority() > 0) {	
			//mv.addObject를 하는 이유는 인터셉터를 하기 위해
			mv.addObject("user",user);
			mv.setViewName("redirect:/"); 
		//회원정보가 없으면
		}else {
			if(user != null) {
				//인증 안된 회원이라고 메시지
			}
			mv.setViewName("redirect:/login");
		}
		return mv;
	}
	
	@RequestMapping(value= "/logout", method = RequestMethod.GET)
	public ModelAndView logout(ModelAndView mv,HttpSession session) {
		session.removeAttribute("user");
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@RequestMapping(value = "/email/authentication", method =RequestMethod.GET)
	public ModelAndView emailAuthentication(ModelAndView mv , MemberOKVO mok ) {	
		boolean res = memberService.emailAuthentication(mok); 
		if(res) {
			//인증 성공 메시지
		}else {
			//인증 실패 메시지
		}
		mv.setViewName("redirect:/");//리다이렉트메인
		return mv;
	}
	
	
}
