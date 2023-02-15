package kr.kh.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class BoardController {

		@RequestMapping(value = "/board/list",method =RequestMethod.GET)
		public ModelAndView login(ModelAndView mv) {
			
			mv.setViewName("/board/list");//연결
			return mv;
		}
}
