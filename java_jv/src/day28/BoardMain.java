package day28;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class BoardMain {
	private static Scanner scan = new Scanner(System.in);
	private static List<Member> memberList = new ArrayList<Member>();
	private static List<Board> boardList = new ArrayList<Board>();
	private static List<String> categoryList = new ArrayList<String>();
	//Arrays.asList("공지","자유")는 고정리스트이다.
	private static Member user ; //로그인한 회원정보를 user에 담음
	/*
	 * 게시글 관리 프로그램
	 * -회원가입
	 * 	-처음 가입한 회원이 관리자 , 그 외 회원은 일반회원
	 * -로그인
	 * -게시글 등록/수정/삭제 =>회원만 가능
	 * -카테고리 관리(공지,자유게시판)
	 * -카레고리 추가/수정/삭제 =>관리자만 가능 ??? 
	 * 
	 * ⊙기능
	 * 	→회원관리
	 * 	 -로그인
	 * 	 -회원가입
	 * 	→게시글 관리
	 * 	 -게시글 등록(회원만 가능)
	 * 	 -게시글 수정(회원+작성자 본인)
	 * 	 -게시글 삭제(회원+작성자 본인)
	 * 	 -게시글 목록(모두)
	 * 	  -게시글 검색
	 * 	  -게시글 확인
	 * 	 -카테고리 관리(회원+관리자만)
	 * 	  -카테고리 추가
	 * 	  -카테고리 수정
	 *    -카테고리 삭제
	 * 	→종료
	 */	

	public static void main(String[] args) {
		int menu = -1;
		loadMember("member.txt");
		loadBoard("board.txt");
		loadCategory("category.txt");
		do {
			try {
				printMenu();
				menu = scan.nextInt();
				scan.nextLine();//위에서 입력한 엔터 처리
				printBar();
				runMenu(menu);
			}catch(InputMismatchException e) {
				scan.nextLine();//잘못된 문자열들을 비워 줌
				printStr("[숫자를 입력하세요]");
			}catch(Exception e) {
				printStr(e.getMessage());
			}
		}while(menu!=4);
		saveMember("member.txt");
		saveBoard("board.txt");
		saveCategory("category.txt");
	}//☆

	private static void loadBoard(String filename) {
		try(ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream(filename))){ //이렇게 하면 지알아서 닫아줌
			
			//※다른 load와 다른점
			int count = ois.readInt();
			Board.setCount(count);
			
			while(true) {
				Board board = (Board)ois.readObject(); //읽어옴
				boardList.add(board);//리스트에 하나씩 추가
			}
			}catch(ClassNotFoundException e) {
				printStr("!불러오기 실패!");
			}catch(EOFException e) {
				printStr("[불러오기 성공]");
			}catch(IOException e) { //IOE가 EOFE안에 포함 되기때문에 밑에 적어줘야한다.
				printStr("!불러오기 실패!");
			}
	}

	private static void saveBoard(String filename) {
		try(ObjectOutputStream oos 
				= new ObjectOutputStream(new FileOutputStream(filename))){ //이렇게 하면 지알아서 닫아줌
			//※다른 save와 차이점
			oos.writeInt(Board.getCount()); //getCount라는메소드를 통해서 여지까지 몇번의 게시글이 만들어졌는지 확인
			
			for(Board board : boardList){//저장할게 있다면 향산되 for문 이용
				oos.writeObject(board);
				}
			System.out.println("[저장 완료]");
			}catch(IOException e) {
				printStr("!저장 실패!");
		}
	}

	private static void saveCategory(String filename) {//카테고리save
		try(ObjectOutputStream oos 
				= new ObjectOutputStream(new FileOutputStream(filename))){ //이렇게 하면 지알아서 닫아줌
			for(String category : categoryList){//저장할게 있다면 향산되 for문 이용
				oos.writeObject(category);
				}
			System.out.println("[저장 완료]");
			}catch(IOException e) {
				printStr("!저장 실패!");
		}
	}

	private static void loadCategory(String filename) {//카테고리load
		try(ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream(filename))){ //이렇게 하면 지알아서 닫아줌
			while(true) {
				String category = (String)ois.readObject(); //읽어옴
				categoryList.add(category);//리스트에 하나씩 추가
			}
			}catch(ClassNotFoundException e) {
				printStr("!불러오기 실패!");
			}catch(EOFException e) {
				if(categoryList.size()==0)
					categoryList = new ArrayList<String> (Arrays.asList("공지","자유"));
				printStr("[불러오기 성공]");
			}catch(IOException e) { //IOE가 EOFE안에 포함 되기때문에 밑에 적어줘야한다.
				printStr("!불러오기 실패!");
			}
	}

	private static void saveMember(String filename) {//멤버 save
		if(memberList.size()==0)//저장할게 없다..
			return;
		try(ObjectOutputStream oos 
				= new ObjectOutputStream(new FileOutputStream(filename))){ //이렇게 하면 지알아서 닫아줌
			for(Member member : memberList){//저장할게 있다면 향산되 for문 이용
				oos.writeObject(member);
				}
			System.out.println("[저장 완료]");
			}catch(IOException e) {
				printStr("!저장 실패!");
		}
	}

	private static void loadMember(String filename) {//멤버load
		try(ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream(filename))){ //이렇게 하면 지알아서 닫아줌
			while(true) {
				Member member = (Member)ois.readObject(); //읽어옴
				memberList.add(member);//리스트에 하나씩 추가
			}
			}catch(ClassNotFoundException e) {
				printStr("!불러오기 실패!");
			}catch(EOFException e) {
				printStr("[불러오기 성공]");
			}catch(IOException e) { //IOE가 EOFE안에 포함 되기때문에 밑에 적어줘야한다.
				printStr("!불러오기 실패!");
			}
		
	}

	private static void runMenu(int menu) {//기능실행
		switch(menu) {
		case 1:
			memberMenu();
			break;
		case 2://게시글 관리
			boardMenu();
			break;
		case 3://
			categoryMenu();
			break;
		case 4:
			System.out.println("[ 종료합니다 ]");
			break;
		default:
			throw new RuntimeException("[ 잘못된 메뉴입니다 ]");
			//런타임이 아닌예외로 하면 계속 예외처리르 해줘야함
		}
	}

	private static void categoryMenu() { //메인 - case 3(카테고리 관리)
		//관리자 체크 => 관리자가 아니며 메인메뉴로
		if(!isAdmin()) {
			return; }
		//입력받음
		int subMenu =0;
		do {
			//관리자가 맞다면 서브메뉴 출력
			printSubMenu(3);
		//서브메뉴 선택 및 선택한 서브 메뉴에 맞는 기능 실행 
			subMenu = scan.nextInt();
			scan.nextLine();
			printBar();
			runCategoryMenu(subMenu);
		}while(subMenu!=5);
		
	}

	private static void runCategoryMenu(int subMenu) {//카테고리runMenu
		switch(subMenu) {
		case 1://1.카테고리 추가
			insertCategory();
//			System.out.println(categoryList); //확인용
			break;
		case 2://2.카레고리 수정
			updateCategory();
//			System.out.println(categoryList); //확인용
			break;
		case 3:	//3.카테고리 삭제
			deleteCategory();
			break;
		case 4://4.카테고리 확인
			printCategory();
			break;
		case 5://5.이전
			printStr("[이전메뉴 이동]");
			break;
		default:
			System.out.println("[잘못된 메뉴입니다]");
		}
		
	}

	private static void printCategory() {//카테고리 - case4(확인)
		//모든 카테고리 출력(반복문이용)
		if(categoryList.size()==0) {
			printStr("!등록된 카테고리가 없습니다!");
			return;
		}
		for(int i =0; i<categoryList.size(); i++) {
			System.out.println(i+1 +". "+categoryList.get(i));
		}
	}

	private static void deleteCategory() {//카테고리 - case3(삭제)
		//삭제할 카테고리명 입력
		System.out.println("삭제하려는 카테고리 명 : ");
		String category = scan.nextLine();
		printBar();
		//기존 카테고리에 있으면 삭제
//		if(categoryList.contains(category)) { //있는지 확인하고 삭제해도됨
//			categoryList.remove(category);}
		if(categoryList.remove(category)) {
			printStr("[카테고리를 삭제했습니다]");
			return;
		}
		printStr("!등록되지 않는 카테고리입니다!");
	}

	private static void updateCategory() {//카테고리 - case2(수정)
		//수정할 카테고리명 입력
		System.out.println("수정하려는 카테고리 명 : ");
		String category = scan.nextLine();
		printBar();
		//기존 카테고리에 없으면 
		if(!categoryList.contains(category)) {
			printStr("!등록되지 않은 카테고리 입니다!");
		}
		//새 카테고리명 입력
		System.out.println("새 카테고리 명 : ");
		String newcategory = scan.nextLine();
		printBar();
		//수정
		if(!categoryList.contains(newcategory)) {
			categoryList.remove(category);//기존 카테고리 삭제
			categoryList.add(newcategory);//새 카테고리 추가
			printStr("[카테고리 수정에 성공하였습니다]");
			return;
		}
		printStr("!이미 등록된 카테고리 입니다!");
		
	}

	private static void insertCategory() {//카테고리 - case1(추가)
		//새 카테고리 명 입력
		System.out.println("카테고리 명 : ");
		String category = scan.nextLine();
		printBar();
		//기존 카테고리에 있는지 확인하여 없으면 추가
		if(categoryList.indexOf(category)==-1) {
			//없으면 카테고리 리스트에 추가
			categoryList.add(category);
			printStr("[새 카테고리를 추가했습니다]");
			return;
		}
		printStr("!이미 존재하는 카테고리 입니다!");
	}

	private static boolean isAdmin() { //카테고리 관리자 체크
		if(user == null || user.getAuthority()!=Authority.ADMIN) {
			printStr("!관리자가 아닙니다.해당 기능을 이용할수 없습니다!");
			return false;
		}
		return true;
	}

	private static void boardMenu() { //게시글 - case 2(게시글관리)
		int subMenu =0;
		do{
		//서브메뉴를 출력
		printSubMenu(2);
		//서브메뉴 선택 및 
		subMenu=scan.nextInt();
		scan.nextLine();
		printBar();
		//선택한 서브메뉴에 맞는 기능 실행
		runBoardMenu(subMenu);
		}while(subMenu!=5);
	}

	private static void runBoardMenu(int subMenu) {//게시글 case2(기능 모음)
		switch(subMenu) {
		case 1://1.게시글 등록
			insertBoard();
			break;	
		case 2 ://2.게시글 수정
			updateBoard();
			break;
		case 3://3.게시글 삭제
			deleteBoard();
			break;
		case 4://4.게시글 목록
			printBoard();
			break;
		case 5://5. 이전
			printStr("[이전메뉴 이동]");
			break;
		default :
			System.out.println("!잘못된 메뉴 입니다!");
		}
		System.out.println(boardList);
	}

	private static void printBoard() { //게시글 case4
		int detailMenu =0;
		do {
		//디테일 메뉴 출력
		printDetailMenu();
		//메뉴번호 선택
		detailMenu = scan.nextInt();
		scan.nextLine();
		printBar();
		//메뉴번호에따른 기능 실행
		runPrintMenu(detailMenu);
			//서브 메뉴 선택 & 기능 실행
				
		}while(detailMenu!=4);
	}

	private static void runPrintMenu(int detailMenu) {//게시글 case4 기능실행
		switch(detailMenu) {
		case 1://게시글 목록 확인
			//모든 게시글 확인
			printBoradListAll(); //람다식 이용
			break;
		case 2://게시글 검색
			//검색어 입력 후 게시글 확인
			printBoradSearch(); //람다식 이용
			break;
		case 3://게시글 확인
			//게시글 번호를 입력
			printBoardDetail();
			//입력한 게시글이 있으면 확인
			break;
		case 4://4.이전
			System.out.println("[이전메뉴 이동]");
			break;
		default:
			System.out.println("!잘못된 메뉴 입니다!");
		}
	}

	private static void printBoardDetail() {//게시글 case4(case3-게시글 확인)
		//확인할 게시글 번호 입력 
		System.out.println("확인할 게시글 번호 입력: ");
		int num = scan.nextInt();
		scan.nextLine();
		//index를 통해 해당게시글과 같은 번호찾기
		int index = boardList.indexOf(new Board(num));
		//해당 게시글이 존재하지 않거나, 작성자가 회원과 같지 않으면 삭제 못함
		if(index == -1) {
			printStr("!등록되지 않거나 삭제된 게시글 입니다!");
			return;
		}
		//게시글을 보면 조회수 증가
		Board board = boardList.get(index);
		int views = board.getViews(); 
		board.setViews(views+1);
		//삭제하는 글 출력
//		boardList.get(index).print();
		printBar();
	}
	
	private static void printBoradSearch() {//게시글 case4(case2-게시글 검색)
		System.out.println("검색어 : ");
		String search = scan.nextLine();
		printBoardList(b->b.getTitle().contains(search.trim())); //trim은 글자 앞뒤부분 공백 제거
		
	}

	private static void printBoradListAll() { //게시글 case4(case1-모든게시글 확인)
		printBoardList(b->true);
	}

	private static void printBoardList(Predicate<Board> p) {
		if(boardList.size() == 0) {
			printStr("!등록된 게시글이 없습니다!");
			return;
		}
		for(Board tmp : boardList) {
			if(p.test(tmp))
			System.out.println(tmp); //이렇게하면 board클래스에 toString 호출된다. 그렇기때문에 투스트링 생성 
		}
	}

	private static void printDetailMenu() { //게시글 case 4(메뉴 출력)
		System.out.println("===Detail Menu===");
		System.out.println("1.게시글 목록 확인");
		System.out.println("2.게시글 검색");
		System.out.println("3.게시글 확인");
		System.out.println("4.이전메뉴");
		System.out.println("-----------------");
		System.out.println("번호 입력 : ");
		
	}

	private static void deleteBoard() {//게시글 case3 (게시글 삭제)
		//회원체크
		if(checkLogin(false)) {
			return;	
		}
		//삭제할 게시글 번호 입력 
		System.out.println("삭제할 게시글 번호 입력: ");
		int num = scan.nextInt();
		scan.nextLine();
		//index를 통해 해당게시글과 같은 번호찾기
		int index = boardList.indexOf(new Board(num));
		//해당 게시글이 존재하지 않거나, 작성자가 회원과 같지 않으면 삭제 못함
		if(index == -1) {
			printStr("!등록되지 않거나 삭제된 게시글 입니다!");
			return;
		}
		//작성자 체크 =>회원(로그인한 사용자)가 아니면 게시글 삭제X
		Board board = boardList.get(index);
		if(board.getWriter().equals(user.getId())) {
			printStr("작성자가 아닌 사용자는 수정할수 없습니다");
			return;
		}
		//해당 게시글 삭제
		boardList.remove(index);
	}

	private static void updateBoard() {//게시글 case2 (게시글 수정)
		//회원체크
		if(checkLogin(false)) {
			return;	
		}
		//수정할 게시글 번호 입력 
		System.out.println("수정할 게시글 번호 입력: ");
		int num = scan.nextInt();
		scan.nextLine();
		int index = boardList.indexOf(new Board(num));
		//해당 게시글이 존재하지 않거나, 작성자가 회원과 같지 않으면 수정 못함
		if(index == -1) {
			printStr("!등록되지 않거나 삭제된 게시글 입니다!");
			return;
		}
		//작성자 체크 =>회원(로그인한 사용자)가 아니면 게시글 수정X
		Board board = boardList.get(index);
		if(board.getWriter().equals(user.getId())) {
			printStr("작성자가 아닌 사용자는 수정할수 없습니다");
			return;
		}
	
		//게시글 정보(제목,내용) 입력
		System.out.print("제목 : ");
		String title = scan.nextLine();
		System.out.print("내용 : ");
		String content = scan.nextLine();
		//게시글을 수정
		board.update(title, content);
		
	}

	private static void insertBoard() {//게시글 case1 (게시글추가)
		//회원 체크 =>회원(로그인한 사용자)가 아니면 게시글 등록X
		if(checkLogin(false)) {
			return;	
		}
		//카테고리 출력
		printCategory();
		printBar();
		//게시글 정보(제목,내용,카테고리) 입력
		String category = null;
		do{
			if(category != null)
				printStr("!등록되지 않은 카테고리 입니다!");
			System.out.println("카테고리 : ");
			category = scan.nextLine();
		}while(!categoryList.contains(category));
		System.out.print("제목 : ");
		String title = scan.nextLine();
		System.out.print("내용 : ");
		String content = scan.nextLine();
		//게시글을 등록
		Board board = new Board(title,content,user.getId(),category);
		boardList.add(board);
		printStr("[게시글이 등록되었습니다]");
	}

	private static void memberMenu() {//회원 - case 1(회원관리)
		//로그인 체크 => 로그인 한 사람은 로그인/회원가입 시도를 할수 없게 하기 위해서
		if(checkLogin(true))//로그인했는지를 확인하는거기때문에 true로 적어줌
			return;
		int subMenu =0;
		//로그인이 안되어있으면 서브메뉴(로그인,회원가입) 출력
		do{
			printSubMenu(1);
		//서브메뉴 선택 및 선택한 서브메뉴에 맞는 기능 실행 => 반복
		 subMenu = scan.nextInt();
		 scan.nextLine();
		 subMenu =runMemberMenu(subMenu);
			
		}while(subMenu !=3);
	}

	private static int runMemberMenu(int subMenu) { //회원메뉴
//		Member member = null; //참조변수는 null로 초기화하는게 좋음
		switch(subMenu) {
		//매개변수를 안넣는 이유는 필드로 다 만들어놨기때문
		case 1://1.회원가입
			signUp();
			break;
			
		case 2://2.로그인
			logIn();
			//로그인 성공하면 서브메뉴를 3으로 수정하여 자동으로 메인으로 이동하게 함
			if(user != null) //로그인이 성공
				return 3;//성공하면 3으로 돌려줌
			break;

		case 3://3.이전메뉴로 이동
			printStr("[이전 메뉴로 돌아갑니다]");
			break;
		default:
			printStr("[잘못된 메뉴를 선택하였습니다]");
		}
		return subMenu;
	}

	private static void logIn() {//로그인 메소드
		//회원 정보 입력(ID,PassWord)
		System.out.println("< 로그인 정보 입력 >");
		Member member = inputMember(); 
	//일치하는 회원이 있으면 회원정보를 가져온다(로그인 성공)
		int index = memberList.indexOf(member);
		if(index == -1) {
			printStr("!로그인 실패!");
			return;
		}
		user = memberList.get(index);
		printStr("[로그인 성공]");
	}

	private static void signUp() { //회원가입 메소드
		//회원정보 입력
		System.out.println("< 회원 정보 입력 >");
		Member member = inputMember();//입력한정보를 객체로 돌려줌
		//가입된 아이디인지 체크
		 if(isMember(member)) {
			 printStr("[이미 가입된 아이디입니다]");
			 return;
		 }
		 //가입된 아이디가 아니면 회원가입 진행
		 	//멤버리스트에 추가
		 	memberList.add(member);
		 	printStr("[회원가입이 완료되었습니다]");
//		System.out.println(memberList); //확인용
		
	}

	private static boolean isMember(Member member) { //아이디 있는지 없는지 확인 메소드
		if(member == null)//예외처리
			return false;
		if(memberList ==null)//예외처리
			memberList = new ArrayList<Member>();
		//로그인이 아니기에 아이디만 체크
		if(memberList.size()==0)
		return false;
		for(Member tmp : memberList) {
			if(tmp.getId().equals(member.getId())) { //같은 아이디가 있으면 트루로 반환
				return true;
			}
		}
		return false;
	}

	private static Member inputMember() {//아이디,비번,권한 입력 메소드
		System.out.println("ID : ");
		String id = scan.nextLine();
		System.out.println("PassWord : ");
		String pw = scan.nextLine();
		Authority authority = memberList.size() == 0? Authority.ADMIN : Authority.MEMBER;
		//처음가입한경우 멤버리스트가 0명이면 관리자권한, 아니라면 멤버로 설정
		return new Member(id,pw,authority);
	}

	private static boolean checkLogin(boolean res) {//해당기능 이용가능한지 확인할수있는 메소드
		//res가 true이면 위에if만 체크, res가 false 이면 밑에if부분만 체크
		if(user != null && res) {//null이 아니면 = user가 로그인함
			printStr("[!로그인한 사용자는 해당 기능을 이용할수 없습니다!]");
			return true;
		}if(user == null && !res) {
			printStr("[로그인 하지 않은 사용자는 해당기능을 이용할수 없습니다.]");
			return true;
		}
		return false;
	}
	
	private static void printSubMenu(int menu) { //모든 서브메뉴 출력문
		switch(menu) {
		case 1:
			System.out.println("===회원 관리 메뉴===");
			System.out.println("1.회원가입");
			System.out.println("2.로그인");
			System.out.println("3.이전메뉴로 이동");
			break;
		case 2:
			System.out.println("===게시글 관리 메뉴===");
			System.out.println("1.게시글 등록");
			System.out.println("2.게시글 수정");
			System.out.println("3.게시글 삭제");
			System.out.println("4.게시글 목록");
			System.out.println("5.이전메뉴");
			break;
		case 3:
			System.out.println("===카테고리 관리 메뉴===");
			System.out.println("1.카테고리 추가");
			System.out.println("2.카테고리 수정");
			System.out.println("3.카테고리 삭제");
			System.out.println("4.카테고리 확인");
			System.out.println("5.이전메뉴");
			break;
		}
		printBar();
		System.out.println("메뉴선택 : "); //공통으로 들어갈 부분이니까 switch문 밖에 빼줌
	}

	private static void printMenu() {//메인메뉴 출력
		System.out.println("===MENU===");
		System.out.println("1.회원관리");
		System.out.println("2.게시글 관리");
		System.out.println("3.카테고리 관리");
		System.out.println("4.종료");
		System.out.println("메뉴선택 : ");
	}

	private static void printStr(String str) { //입력문구 출력 메소드
		System.out.println(str);
		System.out.println("◆--------------◆");
	}

	private static void printBar() { //입력문구 출력 바 메소드
		System.out.println("◆--------------◆");
	}
}//★
