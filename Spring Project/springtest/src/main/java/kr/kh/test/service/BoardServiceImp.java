package kr.kh.test.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.test.dao.BoardDAO;
import kr.kh.test.pagination.Criteria;
import kr.kh.test.utils.UploadFileUtils;
import kr.kh.test.vo.BoardTypeVO;
import kr.kh.test.vo.BoardVO;
import kr.kh.test.vo.FileVO;
import kr.kh.test.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	BoardDAO boardDao;

	String uploadPath = "D:\\uploadfiles";

	@Override
	public ArrayList<BoardTypeVO> getBoardTypeList(MemberVO user) {
		if (user == null || user.getMe_authority() == 0)
			return null;
		return boardDao.selectBoardTypeList(user.getMe_authority());

	}

	@Override
	public boolean insertBoard(BoardVO board, MemberVO user, MultipartFile[] files) {
		if (user == null || user.getMe_authority() == 0)
			if (board == null || board.getBo_title().trim().length() == 0 || board.getBo_title().trim().length() == 0
					|| board.getBo_bt_num() == 0)
				return false;

		board.setBo_me_id(user.getMe_id()); // 게시글 작성자로 회원아이디 추가
		int isOk = boardDao.insertBoard(board);// 다오에게 정보주고 일 시킴
//			System.out.println(board); //확인

		// 게시글등록 실패
		if (isOk == 0)
			return false;
		// 첨부파일 추가
		insertFileList(board.getBo_num(),files);
		return true;

	}

	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		if (cri == null)
			cri = new Criteria();
		// 위 if문을 cri = cri == null ? new Criteria() : cri;
		return boardDao.selectBoardList(cri);
	}

	@Override
	public int getBoardTotalCount(Criteria cri) {
		cri = cri == null ? new Criteria() : cri;
		return boardDao.selectTotalCountBoard(cri);
	}

	@Override
	public BoardVO getBoardAndUpdateView(int bo_num) {
		int res;
		res = boardDao.updateViews(bo_num);// 조회수증가하도록
		if (res == 0)
			return null;
		return boardDao.selectBoard(bo_num);
	}

	@Override
	public ArrayList<FileVO> getFileList(int bo_num) {
		return boardDao.selectFileList(bo_num);
	}

	@Override
	public boolean deleteBoard(int bo_num, MemberVO user) {
		if (user == null)
			return false;
		BoardVO board = boardDao.selectBoard(bo_num);
		if (board == null)
			return false;
		if (!board.getBo_me_id().equals(user.getMe_id()))
			return false; // 여기까지가 삭제4번

		ArrayList<FileVO> fileList = boardDao.selectFileList(bo_num);// 6번
		deleteFileList(fileList);
		int res = boardDao.deleteBoard(bo_num);
		if (res == 0)
			return false;
		return true;
	}
	
	private void insertFileList(int bo_num, MultipartFile[] files) {
		if (files == null || files.length == 0)
			return;
		// 반복문으로 첨부파일을 하나씩 꺼내서 작업
		for (MultipartFile file : files) {
			if (file == null || file.getOriginalFilename().length() == 0)// 비어있는 파일은 추가 하지 않도록 예외처리
				continue;
			// 첨부파일 서버에 업로드
			try {
				String path = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
				FileVO fileVo = new FileVO(bo_num, path, file.getOriginalFilename());
				// 첨부파일 객체 생성
				boardDao.insertFile(fileVo);
			} catch (Exception e) {
				e.printStackTrace();
				
			}

		}
	}
	private void deleteFileList(ArrayList<FileVO> fileList) {
		if (fileList == null || fileList.size() == 0) {
			return;
		}
		for (FileVO file : fileList) {
			UploadFileUtils.removeFile(uploadPath, file.getFi_name());
			boardDao.deleteFile(file.getFi_num());// 6번끝
		}
	}

	@Override
	public BoardVO getBoard(int bo_num) {
		return boardDao.selectBoard(bo_num);
	}
	
}
