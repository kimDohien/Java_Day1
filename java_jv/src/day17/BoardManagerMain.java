package day17;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class BoardManagerMain {
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		/*게시글 관리 프로그램을 작성하세요
		 * 1.게시글 작성
		 * 2.게시글 조회
		 * 3.게시글 수정
		 * 4.게시글 삭제
		 * 5.프로그램 종료
		 * 
		 * -게시글은 번호,제목,내용,작성자,작성일,조회수로 구성
		 * -게시글 전체 조회는 나중에 작성된 게시글이 상단에 조회
		 * -게시글 상세 조회는 게시글 번호를 입력하여 게시글 내용을 확인
		 * -게시글 상세조회를 하면 조회수 1 증가
		 * -게시글 수정은 게시글 번호를 선택하여 해당 게시글의 제목,내용을 수정
		 * -게시글 삭제는 게시글 번호를 선택하면 해당 게시글을 삭제
		 * 
		 */

		ArrayList<BoardManager> postList = new ArrayList<BoardManager>();
		int menu=0;
		Scanner scan = new Scanner(System.in);
		do {
			printMenu();
			//메뉴번호 입력
			menu=scan.nextInt();
			//메뉴실행
			runMenu(menu,postList);
			
		}while(menu !=5);
		
		
		
		
	}

	private static void runMenu(int menu, ArrayList<BoardManager> postList) {
		
		switch(menu) {
		case 1://게시글 작성
			//콘솔에서 입력받아 게시글 객체 생성
			BoardManager insertTmp = inputBoard();
			//게시글을 목록에 추가
			writePost(postList, insertTmp);
			
			break;
			
		case 2://게시글 조회
			printBoard(postList, menu);
			
			break;
			
		case 3://게시글 수정
			//게시글 번호 입력
			System.out.print("수정할 게시글 번호 :");
			int num2 = scan.nextInt();
			
			//번호와 일치하는 게시글을 가져옴
			int index = postList.indexOf(new BoardManager(num2));
			if(index == -1) {
				printStr("일치하는 게시글이 없습니다.");
				return; //반복문이 아니기때문 return으로 적어야함
			}
			BoardManager tmp = postList.get(index);
			
			//일치하는 게시글이 있으면 제목, 내용을 입력
			System.out.println("제목 : ");
			String title = scan.next();
			scan.nextLine();
			System.out.println("내용 : ");
			String content = scan.next();
			scan.nextLine();
			
			//입력받은 제목, 내용으로 게시글을 수정
			tmp.update(title,content);
			break;
			
		case 4://게시글 삭제
			
			//게시글 번호 입력
			System.out.print("삭제할 게시글 번호 : ");
			int num = scan.nextInt();
			//게시글 번호에 맞는 게시글 삭제
			//게시글 번호를 이용하여 게시글 객체를 생성하여 삭제처리 한다
			if(postList.remove(new BoardManager(num))) {
				printStr("게시글이 삭제되었습니다.");
			}else {
				printStr("일치하는 게시글이 없습니다.");
			}
			break;
			
		case 5:
			printStr("프로그램 종료");
			break;
			
		default:
			System.out.println("메뉴를 잘못 입력하였습니다.");
			
		}
		
	}
	
	//case 2 
	public static void printBoard(ArrayList<BoardManager> postList, int menu) {
		printSubMenu(menu);
		//서브메뉴 선택
		int subMenu = scan.nextInt();
		
		//서브메뉴에 따른 기능 실행
		switch(subMenu) {
		case 1 ://전체조회
			printAll(postList);
			break;
			
		case 2://상세조회
			//번호 입력
			System.out.println("게시글 번호 : ");
			int num = scan. nextInt();
			printDetail(postList, num);
			break;
			
		default : 
			printStr("잘못된 메뉴입니다.");
		}
	}
	
		//서브메뉴
	public static void printSubMenu(int menu) {
		switch(menu) {
		case 2:
			//서브메뉴 출력
			System.out.println("§<조회 메뉴>§");
			System.out.println("1. 전체 조회");
			System.out.println("2. 상세 조회");
			System.out.println("-------------");
			System.out.println("메뉴 선택 > ");
			
			break;
		}
	}
	
		//게시물 조회(전체)
		public static void printAll(ArrayList<BoardManager> postList) {
			if(postList ==null || postList.size()==0) {
				printStr("등록된 게시물이 없습니다.");
				return;
			}
			//전체조회(향상된for문 이용)
			for(BoardManager tmp : postList) {
				System.out.println(tmp);
			}
		
	}
		//게시물 조회(상세)
		public static void printDetail(ArrayList<BoardManager> postList,int num) {
			//해당 번호와 맞는 게시물 조회
			int index = postList.indexOf(new BoardManager(num)); //인티저 넘버와 보드매니저를 비교해서 찾는것.
			if(index== -1) {
				printStr("없는 게시글 번호입니다.");
				return;
			}
			//게시글 조회수 증가
			postList.get(index).updateViews();
			//게시글 출력
			System.out.println(postList.get(index).print());
		}
		
		
		
		//ⓐ게시글 작성
	public static BoardManager inputBoard() {
		//게시글 정보 입력(제목,내용,작성자)
		System.out.println("제목 : ");
		String title = scan.next();
		scan.nextLine();
		System.out.println("내용 : ");
		String content = scan.next();
		scan.nextLine();
		System.out.println("작성자 : ");
		String writer = scan.next();
		
		//목록에 게시글 추가
		return new BoardManager(title, content, writer);
	}

	//ⓐ게시글 작성
	private static void writePost(ArrayList<BoardManager> postList,BoardManager board) {
		//목록에 추가
		postList.add(0,board); //0번지에 board를 추가
		
		System.out.println("게시물을 등록했습니다.");
	}
	
	private static void printMenu() {
		System.out.println("<MENU>");
		System.out.println("1.게시글 작성");
		System.out.println("2.게시글 조회");
		System.out.println("3.게시글 수정");
		System.out.println("4.게시글 삭제");
		System.out.println("5.프로그램 종료");
		System.out.println("--------------");
		System.out.println("번호 입력 > ");
		
	}
	public static void printStr(String str) {
		System.out.println("----------------");
		System.out.println(str);
		System.out.println("----------------");
	}
}
