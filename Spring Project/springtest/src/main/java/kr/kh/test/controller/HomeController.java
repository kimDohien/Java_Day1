package kr.kh.test.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.test.service.MemberService;
import kr.kh.test.utils.MessageUtils;
import kr.kh.test.vo.MemberOKVO;
import kr.kh.test.vo.MemberVO;


@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	String contextPath = "/test";

	
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
	public ModelAndView signupPost(ModelAndView mv , MemberVO member, HttpServletResponse response) {
		boolean isSignup = memberService.signup(member); //회원가입 성공했는지 물어보기	
		if(isSignup) {
			//성공했다고 알림 메시지(추후 구현 예정)
			MessageUtils.alertAndMovePage(response, "회원가입에 성공했습니다", contextPath, "/");
			mv.setViewName("redirect:/"); //성공하면 메인페이지
		}else {
			//실패했다고 알림 메시지(추후 구현 예정)
			MessageUtils.alertAndMovePage(response, "회원가입에 실패했습니다", contextPath, "/");
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
	public ModelAndView loginPost(ModelAndView mv, MemberVO member,HttpServletResponse response) {
		MemberVO user = memberService.login(member);
		//회원정보가 있으면
		//인증한 회원들만 로그인 하도록
		if(user != null && user.getMe_authority() > 0) {	
			//mv.addObject를 하는 이유는 인터셉터를 하기 위해
			mv.addObject("user",user);
			mv.setViewName("redirect:/"); 
			MessageUtils.alertAndMovePage(response, "로그인에 성공했습니다", contextPath, "/");
		//회원정보가 없으면
		}else {
			if(user != null) {
				//인증 안된 회원이라고 메시지
				MessageUtils.alertAndMovePage(response, "이메일 인증을 완료해야 로그인 완료가능", contextPath, "/login");
			}else {
				MessageUtils.alertAndMovePage(response, "로그인에 실패했습니다.", contextPath, "/login");
			}
			mv.setViewName("redirect:/login");
		}
		return mv;
	}
	
	@RequestMapping(value= "/logout", method = RequestMethod.GET)
	public ModelAndView logoutPost(ModelAndView mv, HttpSession session, 
			HttpServletResponse response) {
		if(session != null) {
			session.removeAttribute("user");
			MessageUtils.alertAndMovePage(response, "로그아웃에 성공했습니다.", 
					contextPath, "/");
		}
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@RequestMapping(value = "/email/authentication", method =RequestMethod.GET)
	public ModelAndView emailAuthentication(ModelAndView mv , MemberOKVO mok,HttpServletResponse response ) {	
		boolean res = memberService.emailAuthentication(mok); 
		if(res) {
			//인증 성공 메시지
			MessageUtils.alertAndMovePage(response, "이메일 인증 성공", contextPath, "/");
		}else {
			//인증 실패 메시지
			MessageUtils.alertAndMovePage(response, "이메일 인증 실패", contextPath, "/");
		}
		mv.setViewName("redirect:/");//리다이렉트메인
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value="/check/id", method = RequestMethod.POST)
	public Map<String, Object> checkId(@RequestBody MemberVO user){
		HashMap<String, Object> map = new HashMap<String, Object>();
		boolean res = memberService.checkId(user);
		map.put("res",res);
		return map;
	}

	
}
