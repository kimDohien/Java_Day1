package kr.kh.spring.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.spring.service.BoardService;
import kr.kh.spring.vo.CommentVO;
import kr.kh.spring.vo.MemberVO;

@RestController //ajax를 이용한경우 레스트컨트롤러를 하면 reponsbleBody를 안붙여도됨
public class CommentController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/comment/insert", method=RequestMethod.POST)
	public Map<String, Object> boardList(@RequestBody CommentVO comment,
			HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = boardService.insertComment(comment, user);//null체크를 서비스에게 일시킴
		map.put("result",res); //결과가 나오면 전송
		return map;
	}
}
