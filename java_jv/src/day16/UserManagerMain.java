package day16;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import day15.Word;

public class UserManagerMain {

	public static void main(String[] args) {
		/*회원 정보를 관리하는 프로그램을 작성하세요.
		 * - 회원 정보는 아이디,비번,이름, 나이, 주민번호 로 구성
		 * - 기능1: 회원 추가
		 * - 기능2: 회원 검색
		 * - 기능3: 회원 수정
		 * - 기능4: 회원 삭제
		 * 
		 */

		
		int menu =-1;
		Scanner scan = new Scanner(System.in);
		ArrayList<UserManager> memberList = new ArrayList<UserManager>(); //회원 리스트
		do {//종료할때까지 반복
			
			//메뉴출력
			printMenu();
			
			try {//예외발생
			//메뉴를 선택(입력)	
			menu = scan.nextInt();
			
			//선택된 메뉴에 따른 기능 실행
			runMenu(menu, memberList);
		}catch(InputMismatchException e) {
			System.out.println("-------------");
			System.out.println("예외발생 : 정수를 입력하세요");
			System.out.println("-------------");
			scan.nextLine(); 
			
		}catch (Exception e) {
				System.out.println("-------------");
				System.out.println(e.getMessage());
				System.out.println("-------------");
			}
			
			
		}while(menu !=5 /*메뉴가 5가 아닐때*/ );
		
		
	}
	


	private static void runMenu(int menu, ArrayList<UserManager> memberList) {
		Scanner scan = new Scanner(System.in);
		switch(menu) {
		case 1:
			//회원 추가
			if(insertMember(memberList)) {
				printStr ("입력하신 회원 정보를 추가했습니다.");
			}else { //출력
				printStr("입력하신 ID가 이미 존재합니다.");
			}
		break;
		
		case 2:
		//회원 검색
			UserManager serchTmp = searchMember(memberList);
			if(serchTmp == null) {
				printStr("ID 또는 PassWord가 잘못되었습니다.");
			}else {
				System.out.println(serchTmp); //회원정보출력
			}
			
		break;
		
		case 3:
		//회원 수정
			UserManager updateTmp = searchMember(memberList);
			
			//일치하지 않으면 건너뜀.
			if(!updateMember(memberList,updateTmp)) {
				printStr("ID 또는 PassWord가 잘못되었습니다.");
			}else {
				printStr("회원정보가 수정되었습니다.");
			}
		break;
		
		case 4:
		//회원 삭제
			
			//④회원 삭제
			UserManager deleteTmp = searchMember(memberList);

			//리스트에 일치하는 회원정보가 있으면 삭제한다.
			//방법1.
//			if(deleteTmp != null){//null이 아니라면 일치한다는거임.
//				 memberList.remove(deleteTmp);
			//방법2.
			if(memberList.remove(deleteTmp)) {
				printStr("삭제가 완료되었습니다.");
			}else {
				printStr("아이디 또는 비밀번호가 잘못되었습니다.");
			}
		break;
		
		case 5:
			System.out.println("프로그램을 종료합니다.");
		break;
		
		default :
			System.out.println("번호를 잘못 입력하였습니다.");
		}
		
	}
	
	//③회원 수정
	public static boolean updateMember(ArrayList<UserManager> memberList, UserManager updateTmp) {
		//정보가 일치하지 않으면 건너뛴다.
		if(updateTmp == null) {
			return false;
		}
		Scanner scan = new Scanner(System.in);
	//일치하는 회원정보가 있으면 비번,이름,나이,주민번호 를 입력받음
		System.out.println("수정할 회원 정보를 입력하세요.");
		System.out.println("비밀번호 : ");
		String pass = scan.next();
		System.out.println("이름 : ");
		String name = scan.next();
		System.out.println("나이 : ");
		int age =scan.nextInt();
		System.out.println("주민등록번호 : ");
		String rrn = scan.next();	
		
	//입력받은 회원정보를 이용하여 updateTmp를 수정
		updateTmp.update(pass,name,age,rrn);
		return true;
	}


	
	//②회원 검색
	private static UserManager searchMember(ArrayList<UserManager> memberList) {
		Scanner scan = new Scanner(System.in);
		System.out.println("검색할 회원 정보를 입력하세요 >");
		//회원아이디를 입력받음
		System.out.println("ID : ");
		String id = scan.next();
		
		//비번 입력
		System.out.println("PassWord : ");
		String pass = scan.next();
		
		//아이디 비번을 이용하여 객체를 만든다.(usermanager에서 아디,비번 생성자 생성후 입력함)
		UserManager member = new UserManager(id, pass);
		
		//회원 리스트에서 아이디가 같은 회원 정보를 가져옴
		int index = memberList.indexOf(member);
		if(index == -1) { 
			//indexOf가 번지찾는것인데 번지를 못찾으면 -1을 내뱉는다. 그말은 찾고자 하는 값이 없다는것.
			return null ; //-1이며 건너뛴다.
		}
		UserManager tmp = memberList.get(index);
		
		//가져온 회원 정보의 비번과 입력한 비번을 비교하다르면 종료
		if(!tmp.getPass().equals(member.getPass())) {//비교한 비번이 리스트 비번과 다르면
			return null;
		}
		//회원정보 출력을 main에서 함.
		return tmp;
	}

	
	//①회원 추가
	private static boolean insertMember(ArrayList<UserManager> memberList) {
		Scanner scan = new Scanner(System.in);
		//회원정보 입력
		System.out.println("추가하려는 회원정보 입력(아이디,비번,이름,나이,주민번호) > ");
		System.out.println("아이디 : ");
		String id = scan.next();
		System.out.println("비밀번호 : ");
		String pass = scan.next();
		System.out.println("이름 : ");
		String name = scan.next();
		System.out.println("나이 : ");
		int age =scan.nextInt();
		System.out.println("주민등록번호 : ");
		String rrn = scan.next();
		
		//입력한 정보를 이용한 객체생성
		UserManager member = new UserManager(id, pass, name, age, rrn);
		//회원 리스트에 이미 가입된 아이디이면 안내문구 출력후 종료
		if(memberList.contains(member)) { /*회원리스트에 객체가 존재하면*/
			//출력 문구를 위에 메인에 써줌
			return false; 
		}
		
		//리스트에 위에 만들어놓은 멤버 객체 추가
		memberList.add(member);
		System.out.println(memberList);
			//출력 문구를 위에 메인에 써줌
		return true;
	}
	public static void printStr(String str) {
		System.out.println("--------------------------");
		System.out.println(str);
		System.out.println("--------------------------");
	}


	//메뉴
	private static void printMenu() {
		System.out.println("<메뉴>");
		System.out.println("1.회원 추가");
		System.out.println("2.회원 검색");
		System.out.println("3.회원 수정");
		System.out.println("4.회원 삭제");
		System.out.println("5.프로그램 종료");
		System.out.println("-------------");
		System.out.println("메뉴 입력 : ");
		
	}

	

	
	
}






