package kr.kh.test.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.test.service.MemberService;
import kr.kh.test.vo.MemberVO;

public class LoginRedirectInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	MemberService memberService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(user != null) {
			String url = (String)session.getAttribute("prevURL");
			if(url != null) {
				response.sendRedirect(url);
				session.removeAttribute("prevURL");
				
				return false;
			}
		}
		
		return true;
	}
}
