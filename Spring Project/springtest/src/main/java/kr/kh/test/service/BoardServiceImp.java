package kr.kh.test.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.test.dao.BoardDAO;
import kr.kh.test.vo.BoardTypeVO;
import kr.kh.test.vo.MemberVO;
import kr.kh.test.vo.BoardVO;

@Service
public class BoardServiceImp implements BoardService {

		@Autowired
		BoardDAO boardDao;

		@Override
		public ArrayList<BoardTypeVO> getBoardType(MemberVO user) {
			if(user == null || user.getMe_authority() == 0)
				return null;	
			return boardDao.selectBoardTypeList(user.getMe_authority());
		
		}

		@Override
		public boolean insertBoard(BoardVO board, MemberVO user, MultipartFile[] files) {
			if(user == null || user.getMe_authority() == 0)
			if(board == null || 
					board.getBo_title().trim().length()==0 ||
					board.getBo_title().trim().length()==0 ||
					board.getBo_bt_num() == 0
					)
				return false;
			
			board.setBo_me_id(user.getMe_id()); //게시글 작성자로 회원아이디 추가
			int isOk = boardDao.insertBoard(board);//다오에게 정보주고 일 시킴
			
			if(isOk == 0)
				return false;
			
			return true;

		}

		
		
}
