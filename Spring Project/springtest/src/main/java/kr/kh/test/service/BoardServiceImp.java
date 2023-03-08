package kr.kh.test.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.test.dao.BoardDAO;
import kr.kh.test.utils.UploadFileUtils;
import kr.kh.test.vo.BoardTypeVO;
import kr.kh.test.vo.BoardVO;
import kr.kh.test.vo.FileVO;
import kr.kh.test.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService {

		@Autowired
		BoardDAO boardDao;

		String uploadPath= "D:\\uploadfiles";
		
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
//			System.out.println(board); //확인
			
			//게시글등록 실패
			if(isOk == 0)
				return false;
			//첨부파일 추가
			if(files == null || files.length ==0)
				return true;
			//반복문으로 첨부파일을 하나씩 꺼내서 작업
			for(MultipartFile file : files) {
				if(file==null || file.getOriginalFilename().length()==0)//비어있는 파일은 추가 하지 않도록 예외처리
					continue;
				//첨부파일 서버에 업로드
				try {
					String path = UploadFileUtils.uploadFile(uploadPath,
							file.getOriginalFilename(),
							file.getBytes());
					FileVO fileVo = new FileVO(board.getBo_num(),path,file.getOriginalFilename());
					//첨부파일 객체 생성
					boardDao.insertFile(fileVo);
				}catch(Exception e) {
					e.printStackTrace();
					return true;
				}
				
			}
			return true;

		}

		
		
}
