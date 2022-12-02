package day30;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*기능
 * -게시글 등록
 * -게시글 수정
 * -게시글 삭제
 * -게시글 목록
 * -게시글 확인
 * 	-댓글 등록
 * 	-댓글 확인
 * 	-이전
 * -프로그램 종료
 */
public class BoardMain {
	static Scanner scan = new Scanner(System.in);
	private static List<Board> boardList = new ArrayList<Board>();
	private static List<Comment> commentList = new ArrayList<Comment>();
	
	public static void main(String[] args) {
		//메뉴를 출력하고, 입력한 메뉴가 프로그램 종료가 아니면 반복하는 코드작성
		int menu =0;
		do {
			printMenu();
			menu = scan.nextInt();
			scan.nextLine();
			runMenu(menu);
		}while(menu!=6);
/*		while(menu!=6) { //초기화값은 6이 아닌것만 해주면됨.
*			printMenu();
*			menu = scan.nextInt();
*		}
*/
	}//★
	
	private static void runMenu(int menu) {//기능실행메뉴
		switch(menu) {
		case 1://게시글 등록
			insertBoard();
			break;
		case 2://게시글 수정
			updateBoardList();
			break;
		case 3://게시글 삭제
			deleteBoardList();
			break;
		case 4://게시글 목록
			printBoardList(boardList);
			break;
		case 5://게시글 확인
			printBoard();
			break;
		case 6://종료
			System.out.println("[프로그램을 종료합니다]");
			break;
		default:
			System.out.println("!잘못된 메뉴입니다!");
		}
	}
	
	public static void printMenu() {//메뉴 출력
		System.out.println("===MENU===");
		System.out.println("1.게시글 등록");
		System.out.println("2.게시글 수정");
		System.out.println("3.게시글 삭제");
		System.out.println("4.게시글 목록");
		System.out.println("5.게시글 확인");
		System.out.println("6.프로그램 종료");
		System.out.println("-----------");
		System.out.println("번호 입력 : ");
	}
	
	private static void insertBoard() {//게시글 case1(등록)
		//게시글 정보입력
		System.out.println("<게시글 등록>");
		int num = inputBoardNum();
		
		//게시글 객체생성
		Board board = inputBoard(num);
		//게시글 중복번호 확인
		if(boardList.contains(board)) {
			System.out.println("[이미 존재하는 번호 입니다]");
		}
		//게시글 추가
		boardList.add(board);
//		System.out.println(boardList); //확인용
	}
	
	//-------------------------------------
	
	public static int inputBoardNum() {
		System.out.println("번호 : ");
		int num = scan.nextInt();
		scan.nextLine();
		return num;
		}
	
	public static Board inputBoard(int num) {
		System.out.println("제목 : ");
		String title =scan.nextLine();
		System.out.println("내용 : ");
		String contents = scan.nextLine();
		System.out.println("작성자 : ");
		String writer = scan.nextLine();
		//게시글 객체생성
		return new Board(num,title,contents,writer);
//		System.out.println(boardList); //확인용
	}
	
	//-------------------------------------
	
	public static boolean updateBoard(List<Board>boardList,Board board) {
		if(boardList.size()==0) 
			return false;
			int index = boardList.indexOf(board);
			if(index == -1)
				return false;
			boardList.set(index, board);
			return true;
		}
	
	public static void updateBoardList() {
		int num = inputBoardNum();//입력받은 넘버
		Board board= inputBoard(num);//넘버를 보드를 넘겨준다.
		if(updateBoard(boardList, board)) {
			System.out.println("게시글 수정완료");
		}else{
		System.out.println("!게시글 수정실패!");
		}
	}
		
	//-------------------------------------
	
	public static boolean deleteBoard(List<Board>boardList,int num) {
		Board board = new Board(num);
		return boardList.remove(board);
	}
	
	public static void deleteBoardList() {
		int num = inputBoardNum();
		if(deleteBoard(boardList, num)) {
			System.out.println("삭제 완료");
		}else{
			System.out.println("!게시글 삭제실패!");
			}
	}
	
	//-------------------------------------
	
	public static void printBoardList(List<Board>boardList) {
		//forEach메소드를 통해서 한줄로 쉽게 만들수있다.
//		boardList.forEach(b->System.out.println(b));
		if(boardList == null||boardList.size()==0) {
			System.out.println("!등록된 게시물이 없습니다!");
		}
		for(Board tmp : boardList) {
			System.out.println(tmp);
		}
	}
	
	//-------------------------------------
	
	public static void printBoard() { //댓글
		int num = inputBoardNum();
		Board board= new Board(num);
		int index = boardList.indexOf(board);
		if(index ==-1) {
			System.out.println("!등록되지 않았거나 삭제된 게시글입니다!");
			return;
		}	
		board = boardList.get(index);
		board.print();
		
		int subMenu =0;
		do {
		subMenu();
		subMenu = scan.nextInt();
		scan.nextLine();
		runPrintSubMenu(subMenu,num);
		}while(subMenu !=3);
	}
	
	public static void runPrintSubMenu(int subMenu,int boardNum) {//댓글 기능
		switch(subMenu) {
		case 1:
			insertCommentList(boardNum);
			break;
		case 2:
			printCommentList(boardNum);
			break;
		case 3:
			System.out.println("[이전메뉴 이동]");
			break;
		default:
		 System.out.println("!잘못된 메뉴입니다!");
		}
	}
	
	public static void printCommentList(int boardNum) {
		if(commentList.size()==0) {
			System.out.println("등록된 댓글 없음");
			return;
		}
		commentList.forEach(b->{
			if(b.getBoardNum()==boardNum) {
				System.out.println(b);
			}
		});
	}
	
	public static boolean insertComment(List<Comment> commentList,Comment comment) {
		//해당댓글이 commentList에 있는지 없는지 확인
		int index = commentList.indexOf(comment);
		if(index!=-1) {
			System.out.println("!이미 등록된 댓글번호 입니다!");
		return false;
		}
		commentList.add(comment);
		System.out.println("[댓글 등록 완료]");
		return true;
	}
	
	public static void insertCommentList(int boardNum) {
		int num = inputBoardNum();
		
		System.out.print("작성자 : ");
		String writer = scan.nextLine();
		System.out.print("내용 : ");
		String contents = scan.nextLine();
		
		Comment comment =  new Comment(num,writer,contents,boardNum);
		if(insertComment(commentList, comment)){
			System.out.println("댓글 등록이 완료됐습니다.");
		}else {
			System.out.println("!이미 댓글 등록이 됐습니다!");
		}
	}

	public static void subMenu() {
		System.out.println("===Sub MENU===");
		System.out.println("1.댓글 등록");
		System.out.println("2.댓글 확인");
		System.out.println("3.이전");
		System.out.println("--------------");
		System.out.println("번호 입력 : ");
	}
	
}//★
