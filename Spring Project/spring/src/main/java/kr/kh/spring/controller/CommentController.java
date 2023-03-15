package kr.kh.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.pagination.PageMaker;
import kr.kh.spring.service.BoardService;
import kr.kh.spring.vo.CommentVO;
import kr.kh.spring.vo.MemberVO;

@RestController //ajax를 이용한경우 레스트컨트롤러를 하면 reponsbleBody를 안붙여도됨
public class CommentController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/comment/insert", method=RequestMethod.POST)
	public Map<String, Object> commentInsert(@RequestBody CommentVO comment,
			HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = boardService.insertComment(comment, user);//null체크를 서비스에게 일시킴
		map.put("result",res); //결과가 나오면 전송
		return map;
	}
	
	
	@RequestMapping(value = "/comment/list/{co_bo_num}", method=RequestMethod.POST)
	public Map<String, Object> commentList(@RequestBody Criteria cri,
			@PathVariable("co_bo_num") int co_bo_num) {
		Map<String, Object> map = new HashMap<String, Object>();
		cri.setPerPageNum(4); //한댓글페이지에 댓글 2개..로 설정
		ArrayList<CommentVO> list = boardService.getCommentList(cri, co_bo_num);//댓글목록을 가져오는 작업
		//pageMaker만들어줌
		int totalCount = boardService.getTotalCountCommentList(co_bo_num);
		PageMaker pm = new PageMaker(totalCount, 5, cri); 
		
		map.put("list", list); //잘 가져왔으면 map에 담아서 보내줌
		map.put("pm", pm);
		return map;
	}
	
	
	@RequestMapping(value = "/comment/delete", method=RequestMethod.POST)
	public Map<String, Object> commentDelete(@RequestBody CommentVO comment,
			HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = boardService.deleteComment(comment,user);
		map.put("result", res);
		return map;
	}
	
	@RequestMapping(value = "/comment/update", method=RequestMethod.POST)
	public Map<String, Object> commentUdpate(@RequestBody CommentVO comment,
			HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = boardService.updateComment(comment,user);
		map.put("result", res);
		return map;
	}
}
