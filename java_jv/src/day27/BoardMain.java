package day27;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardMain {
	/*
	 * 게시글 관리 프로그램
	 * -회원가입
	 * 	-처음 가입한 회원이 관리자 , 그 외 회원은 일반회원
	 * -로그인
	 * -게시글 등록/수정/삭제 =>회원만 가능
	 * -카테고리 관리(공지,자유게시판)
	 * -카레고리 추가/수정/삭제 =>관리자만 가능 ??? 
	 */
	
	//관리자를 어떻게 권한하는지
	//로그인한사람만 어떻게 게시글을 쓸수있는가..?
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<board> boardList = new ArrayList<board>();
		ArrayList<boardMember> members = new ArrayList<boardMember> ();
		ArrayList<category> cg = new ArrayList<category>();
		int menu =0;
		do {
			printMenu();
			menu = scan.nextInt();
			runMenu(menu,members,boardList,cg);
			
		}while(menu!=5);
	}
	
	private static void runMenu(int menu, ArrayList<boardMember> members,ArrayList<board> boardList,ArrayList<category> cg) {
		switch(menu) {
		case 1://회원가입
			joinMember(members);
			break;
		case 2://로그인
			if(login(members)) {
				System.out.println("로그인 되었습니다.");
			}else {
				System.out.println("다시 로그인해 주세요.");
			}
			break;
		case 3://게시글 등록/수정/삭제
			Post(boardList,menu);
			break;
		case 4://카테고리 관리
			category(cg, menu);
			break;
		case 5:
			System.out.println("종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴 입력");
		}
		
	}
	
	private static void category(ArrayList<category> cg,int Menu) {//카테고리 관리
		printSubMenu2();
		int subMenu2 = scan.nextInt();
		switch(subMenu2) {
		case 1://공지
			System.out.println("<NOTICE>");
			break;
		case 2: //자유게시판
			System.out.println("<FREE BOARD>");
			break;
		case 3:
			System.out.println("종료");
			break;
		default:
			System.out.println("잘못된 메뉴 입니다.");	
		}
	}

	private static void printSubMenu2() { //카테고리 메뉴 출력
		System.out.println("==Category Menu==");
		System.out.println("1.공지");
		System.out.println("2.자유게시판");
		System.out.println("3.종료");
		System.out.println("번호 입력 : ");
		
	}

	private static void Post(ArrayList<board> boardList,int Menu) { //게시글 관리
		printSubMenu();
		int subMenu =scan.nextInt();
		switch(subMenu) {
		case 1://등록
			board insertTmp = inputBoard();
			writePost(boardList,insertTmp);
			break;
		case 2 ://수정
			updatePost(boardList);
			break;
		case 3://삭제
			deletePost(boardList);
			break;
		case 4://종료
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}
	
	private static void deletePost(ArrayList<board> boardList) {//게시글 삭제
		System.out.println("삭제할 게시글을 입력하세요 ");
		int num = scan.nextInt();
		
		if(boardList.remove(new board(num))){
			System.out.println("[게시글이 삭제되었습니다]");
		}else {
			System.out.println("!게시글 삭제에 실패하였습니다!");
		}
	}

	private static void updatePost(ArrayList<board> boardList) {//게시글 수정
		System.out.println("수정할 게시글을 번호를 입력하세요 ");
		int num = scan.nextInt();
		
		int index = boardList.indexOf(new board(num));
		if(index  == -1) {
			System.out.println("일치하는 게시글이 없습니다.");
			return;
		}
		board tmp = boardList.get(index);
		
		//일치하는 게시글이 있으면 수정
		System.out.println("제목 : ");
		String title = scan.next();
		scan.nextLine();
		System.out.println("내용 : ");
		String contents = scan.next();
		scan.nextLine();
		scan.next();
		
		tmp.update(title,contents);
			
		}

	private static void writePost(ArrayList<board> boardList,board board) { //게시글 입력 추가
		boardList.add(board);
		System.out.println("[게시물을 등록했습니다]");
	}
	
	private static board inputBoard() { //게시글 입력
		System.out.println("제목 : ");
		String title = scan.next();
		scan.nextLine();
		System.out.println("내용 : ");
		String contents = scan.next();
		scan.nextLine();
		
		return new board(title,contents);
		
	}

	private static void printSubMenu() { //게시글 관리 서브메뉴 출력
		System.out.println("===Post Menu===");
		System.out.println("1.게시글 등록");
		System.out.println("2.게시글 수정");
		System.out.println("3.게시글 삭제");
		System.out.println("4.종료");
		System.out.println("번호입력 > ");
	}
	

	private static boolean login(ArrayList<boardMember> members) { //로그인
		System.out.println("< LOGIN >");
		System.out.println("ID : ");
		String id = scan.next();
		System.out.println("PassWord : ");
		String pw = scan.next();
		
		boardMember member = new boardMember(id,pw);
		
		int index = members.indexOf(member);
		if(index == -1) {
			return false;
		}
		boardMember tmp = members.get(index);
		if(!tmp.getPw().equals(member.getPw())) {
			return false;
		}
		return true;
	}		
		
	private static void joinMember(ArrayList<boardMember> members) { //회원가입
		System.out.println("회원가입할 ID,PassWord 입력");
		System.out.println("ID : ");
		String id = scan.next();
		System.out.println("PassWord : ");
		String pw = scan.next();
		
		boardMember member = new boardMember(id,pw);
		members.add(member);
	}
	
	
	private static void printMenu() {//메뉴출력
		System.out.println("===MENU===");
		System.out.println("1.회원가입");
		System.out.println("2.로그인");
		System.out.println("3.게시글 관리");
		System.out.println("4.카테고리 관리");
		System.out.println("5.종료");
		System.out.println("메뉴선택 : ");
	}
	
}
