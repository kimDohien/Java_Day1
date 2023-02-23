package kr.kh.test.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.test.service.AdminService;
import kr.kh.test.service.AdminServiceImp;
import kr.kh.test.utils.MessageUtils;
import kr.kh.test.vo.BoardTypeVO;

@Controller
public class AdminController {
	
	@Autowired 
	AdminService adminService;
	String contextPath = "/test";
	
	@RequestMapping(value= "/admin/board/type/list")
	public ModelAndView adminBoardTypeList(ModelAndView mv) { 
		ArrayList<BoardTypeVO> boardTypeList = adminService.getboardTypeListAll();
		mv.addObject("btList",boardTypeList);
		mv.setViewName("/admin/boardTypeList");
		return mv;
	}
	
	@RequestMapping(value = "/admin/board/type/insert", method = RequestMethod.POST)
	public ModelAndView adminBoardTypeInsert(ModelAndView mv,BoardTypeVO bt,HttpServletResponse response, HttpServletRequest request) {
		//게시판 정보 확인 작업
		/* System.out.println(bt); */
		//서비스에게 게시판 정보를 주면서 등록하라고 요청
		//타입 등록여부 = adminService.insertBoardType(게시판정보) 
		boolean isInsert = adminService.insertBoardType(bt);
		if(isInsert) {
			//등록 알림 메시지
			MessageUtils.alertAndMovePage(response, "게시글등록 성공했습니다", request.getContextPath(), "/admin/board/type/list");
		}else {
			// 실패 알림 메시지
			MessageUtils.alertAndMovePage(response, "게시글등록 실패했습니다", request.getContextPath(), "/admin/board/type/list");
		}
		mv.setViewName("redirect:/admin/board/type/list");
		return mv ;
	}
}

