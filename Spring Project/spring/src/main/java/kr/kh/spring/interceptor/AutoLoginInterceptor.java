package kr.kh.spring.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.kh.spring.service.MemberService;
import kr.kh.spring.vo.MemberVO;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter  {
	
	@Autowired
	MemberService memberService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(user == null) { //회원 정보가 있는지 확인 (null이면 로그인 안되어있는것)
			Cookie cookie = WebUtils.getCookie(request, "springCookie"); //쿠키를 가져옴
			if(cookie != null) { //쿠키가 null이 아니라면 로그인 시도. (쿠키가 없으면 로그인 시도 안됨)
				String me_session_id = cookie.getValue();
				user = memberService.getMemberBySession(me_session_id); //
				if(user != null) { //회원정보가 있으면 회원정보 저장
					session.setAttribute("user",user);
				}
			}
		}
		
		return true;
	}
}