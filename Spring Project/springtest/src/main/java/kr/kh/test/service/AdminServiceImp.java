package kr.kh.test.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kr.kh.test.dao.BoardDAO;
import kr.kh.test.vo.BoardTypeVO;

@Service
public class AdminServiceImp implements AdminService{


	@Autowired
	BoardDAO boardDao;

	@Override
	public ArrayList<BoardTypeVO> getboardTypeListAll() {
		int adminAuthority = 9; //관리자 권한
		return boardDao.selectBoardTypeList(adminAuthority);
	}

	@Override
	public boolean insertBoardType(BoardTypeVO bt) {
		if(!checkBoardType(bt))
			return false;
		int res = boardDao.insertBoardType(bt);
		return res != 0; //0이 아니면 true, 0이면 false
		//위 두 코드를 return boardDao.insertBoardType != 0;
	}

	@Override
	public boolean updateBoardType(BoardTypeVO bt) {
		if(!checkBoardType(bt))
			return false;
		//기본 게시판 번호 체크
		if(bt.getBt_num() < 1)
			return false;
		
		return boardDao.updateBoardType(bt) != 0;
	}
	
	//boardTypeVO 체크 (bt_num)제외
	private boolean checkBoardType(BoardTypeVO bt) {
		System.out.println(bt);
		//bt null체크
		if(bt == null)
			return false;
		
		//<게시판 타입체크>
		if(bt.getBt_type() == null ||
			(bt.getBt_type().equals("일반") && 
			bt.getBt_type().equals("이미지")))
			return false;
		
		//게시판 읽기 권한 체크
		if(bt.getBt_r_authority() !=0 && 
			bt.getBt_r_authority() !=1 &&
			bt.getBt_r_authority() !=9)
			return false;
		
		//게시판 쓰기 권한 체크
		if(bt.getBt_w_authority() !=1 &&
			bt.getBt_w_authority() !=9)
			return false;
		
		//게시판명 체크(null체크)
		if(bt.getBt_name() == null || bt.getBt_name().trim().length() == 0)
			return false;
		//게시판명 중복 체크
		//다오에게 게시판명을 주면서 게시판정보를 가져오라고 시킨다
		BoardTypeVO dbbt = boardDao.selectBoardTypeByName(bt.getBt_name());
		//가져온 게시판 정보가 있는 경우
		//1. 서로 다른 게시판인데 이름이 중복되는 경우(중복이므로 false)
		//2. 같은 게시판인 경우(자기자신이므로 true)
		if(dbbt != null && bt.getBt_num() != dbbt.getBt_num())
			return false;
		return true;
	}


	

}
