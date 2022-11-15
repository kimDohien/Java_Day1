package day17;

import java.util.HashMap;
import java.util.Scanner;

public class UserManagerMapMain {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int menu = 0; //0을 쓰는 이유는 1~5 사이의 숫자만 안쓰면 됨...
		
		//학생 추가,관리하기 위한map 만듬
		HashMap<String,Member> map = new HashMap<String, Member>();
		
		do {
			System.out.println("<메뉴>");
			System.out.println("1.회원 추가");
			System.out.println("2.회원 검색");
			System.out.println("3.회원 수정");
			System.out.println("4.회원 삭제");
			System.out.println("5.프로그램 종료");
			System.out.println("-------------");
			System.out.println("메뉴 입력 : ");
			
			menu = scan.nextInt();
			
			switch(menu) {
			case 1:
				if(addMember(map)) {
					System.out.println("회원 정보가 추가되었습니다.");
				}else {
					System.out.println("이미 추가된 ID 입니다.");
				}
				break;
				
			case 2:
				if(!searchMember(map)) {
					System.out.println("ID 또는 PassWord가 일치하지 않습니다.");
				}
				searchMember(map);
				
				break;
				
			case 3:
				if(updateMember(map)) {
					System.out.println("회원 정보 수정 완");
				}else {
					System.out.println("ID 또는 PassWord가 일치하지 않습니다.");
				}
				break;
				
			case 4:
				if(deleteMember(map)) {
					System.out.println("회원 정보 삭제 완");
				}else {
					System.out.println("ID 또는 PassWord가 일치하지 않습니다.");
				}
				break;
				
			case 5:
				System.out.println("프로그램 종료");
				break;
								
			default :
				System.out.println("잘못된 메뉴이오");
			}
			
		}while(menu != 5);
		
	
	}//메인 끝
	
	private static boolean deleteMember(HashMap<String, Member> map) {
		Scanner scan = new Scanner(System.in);
		System.out.println("삭제할 회원 정보를 입력하세요 >"); 
		//회원아이디를 입력받음
		System.out.println("ID : ");
		String id = scan.next();
		//비번 입력
		System.out.println("PassWord : ");
		String pw = scan.next();
		
		//멤버가 있는지 없는지 확인
		Member deleteTmp = map.get(id);//id로 검색
		if(deleteTmp == null) {
			return false;
		}
		if(deleteTmp.getPw().equals(pw)) {
			return false;
		}
		/*위에 중첩if 두개를 합치면 밑에처럼 적을수 있다. 
		 * if(deleteTmp == null || !deleteTmp.getPw().equals(pw)){
		 * continue;
		 * }
		 * ※or연산은 둘중 하나라도 참이면 참.그래서 왼쪽이 참일때 오른쪽 연산을 비교할 필요가 없다..
		 * 만약 바꿔서 쓴다면 nullpointexception이 뜬다.
		 * 논리연산을 쓸때는 때문에 순서를 꼭 지켜서 써줘야한다. 
		 */
		
		map.remove(id);
		return true;
		
	}

	//회원 수정
	private static boolean updateMember(HashMap<String, Member> map) {
		Scanner scan = new Scanner(System.in);
		System.out.println("검색할 회원 정보를 입력하세요 >"); 
		//회원아이디를 입력받음
		System.out.println("ID : ");
		String id = scan.next();
		//비번 입력
		System.out.println("PassWord : ");
		String pw = scan.next();
	
		Member updateTmp = map.get(id);
		if(updateTmp == null || updateTmp.getPw().equals(pw)) {
			return false;
		}
	
		System.out.println("수정할 회원 정보를 입력하세요.");
		System.out.println("new비밀번호 : ");
		String newPw = scan.next();
		System.out.println("이름 : ");
		String name = scan.next();
		System.out.println("나이 : ");
		int age =scan.nextInt();
		System.out.println("주민등록번호 : ");
		String residentNumber = scan.next();	
	
		//입력을 하고 업데이트tmp를 수정해줘야함 →update메소드 생성(Member클래스에)
		updateTmp.update(newPw,name, age, residentNumber);
		return true;
		
		}
	
	//16일차 처럼 재사용 하려면 아이디 따로 멤버 따로 보내줘야하는데,,그건 좀 불편해서..
	private static boolean searchMember(HashMap<String, Member> map) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("검색할 회원 정보를 입력하세요 >"); 
		//회원아이디를 입력받음
		System.out.println("ID : ");
		String id = scan.next();
		//비번 입력
		System.out.println("PassWord : ");
		String pw = scan.next();
		
		//아이디를 이용하여 회원정보를 가져온다.
		Member searchTmp = map.get(id);//맵을 통해 회원정보 가져옴
		
		//일치하는 회원정보가 없으면 건너뜀
		if(searchTmp == null) {
			return false;
		}
		
		//가져온 회원정보에서 비번이 같은지 확인하여 다르면 건너뜀
		if(!searchTmp.getPw().equals(pw)) {
			return false;
		}
		System.out.println(id+" : "+ searchTmp);
		return true;
	}

	
	//회원정보 추가
	private static boolean addMember(HashMap<String, Member> map) {
		Scanner scan = new Scanner(System.in);
		if(map ==null) {
			throw new RuntimeException("Map이 null입니다.");
			
		}
		System.out.println("추가하려는 회원정보 입력(아이디,비번,이름,나이,주민번호) > ");
		System.out.println("아이디 : ");
		String id = scan.next();
		System.out.println("비밀번호 : ");
		String pw = scan.next();
		System.out.println("이름 : ");
		String name = scan.next();
		System.out.println("나이 : ");
		int age =scan.nextInt();
		System.out.println("주민등록번호 : ");
		String residentNumber = scan.next();
		
		//map에 있는지 확인
		Member addTmp = map.get(id); //key값을 주면 key값과 일치하는 value를 준다.
		//있으면 건너뜀
		if(addTmp != null) {//널이 아니라면 = 검색된 정보가 있다는것.이미 존재한다는 뜻
			return false;
		}
//		if(map.get(id)!=null) //위에 member addTmp~continue 까지로 줄여서 쓸수 있따. 
	
		//없으면 추가
		map.put(id, new Member(pw,name,residentNumber,age));
		return true;
	}

}//클래스 끝
