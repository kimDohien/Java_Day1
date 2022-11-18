package day20;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class PhoneListMain {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		/*<전화번호를 관리하는 프로그램>
		 * 1.전화번호 추가(성, 이름, 직장, 전화번호들..[여러개추가가능])
		 * 2.전화번호 수정
		 *  -이름으로 검색(성+이름)
		 *  -검색된 사람들 중에서 선택
		 *  -성,이름을 수정할건지
		 *   기존 등록된 전화번호를 수정할건지,
		 *   새 전화번호를 등록할건지 선택하여 동작
		 * 3.전화번호 삭제
		 *  -이름으로 검색(성+이름)
		 *  -검색된 사람들 중에서 선택
		 *  -선택된 사람의 연락처 삭제
		 * 4.전화번호 조회
		 *  -이름으로 검색
		 *  -검색된 사람들 중에서 선택
		 *  -선택된 사람의 연락처를 출력
		 */

		ArrayList<phoneNumber> phoneList = new ArrayList<phoneNumber>();
		int menu = 0;
		do {
			//<메뉴 출력>
			printMenu();
			//<메뉴 선택>
			menu=scan.nextInt();
			//<선택된 메뉴 실행>
			ruenMenu(menu,phoneList);
		}while(menu!=4);
		
		
		
	}//main끝
	
	
	private static void ruenMenu(int menu, ArrayList<phoneNumber> phoneList) {
		Scanner scan = new Scanner(System.in);
		String name,job,phoneNum,num,answer;
		switch(menu) {
		case 1 : //1번 - 추가
			//정보 입력
			System.out.println("성명 : ");
			name = scan.next();
			System.out.println("직업 : ");
			 job = scan.next();
			 //전화번호 반복처리 =>phoneNumber
			 	do {
				 System.out.println("휴대폰 번호(직장:010-xxxx-xxxx) : ");
				 phoneNum = scan.next();
				 
				 System.out.println("전화번호를 더 추가 하시겠습니까? Y/N");
				 answer = scan.next();
			 	}while( answer !="N");
			//입력된 정보 개체만들기
			phoneNumber phone = new phoneNumber(name,job,phoneNum);
			//개체 리스트에 저장
			phoneList.add(phone);
			System.out.println(phone);
		
			
		 break;
		 
		case 2://2번 - 수정
			//수정할 사람 이름 검색()
			System.out.println("성명 : ");
			name = scan.next();
			//이름이 포함된 전화번호부를 검색하여 출력
			printPhoneList(phoneList,p->p.getName().contains(name));
			//수정할 전화번호부를 선택
		
			
			//서브메뉴출력
			printUpadateMenu();
			//서브메뉴 선택
			int subMenu=0;
			subMenu = scan.nextInt();
			//성,이름 수정할건지,번호수정할건지,새연락처등록 할건지 선택
			runSubMenu(phoneList,subMenu);
			
			
		 break;
		 
		case 3://3번 - 삭제
			//삭제할 사람 이름 검색(섬명)
			System.out.println("성명 : ");
			name = scan.next();
			//검색된 사람들 중에서 선택
			printPhoneList(phoneList,p ->p.getName().contains(name));
			//삭제할 번호 선택
			
			
			//선택된 사람의 연락처 삭제
			 
		 break;
		 
		case 4://4번 - 조회
			//이름으로 검색
			System.out.println("성명 : ");
			name = scan.next();
			//검색된 사람들 중에서 선택
			printPhoneList(phoneList,p->p.getName().contains(name));
			//연락처 선택
			 num = scan.next();
			//선택된 사람의 연락처를 출력
			
		 break;
		 
		 default :
			 System.out.println("잘못된 메뉴 번호입니다.");
		}

	}
	
	
	
	
	private static void runSubMenu(ArrayList<phoneNumber> phoneList, int subMenu) {
		String name,job,phoneNum,newPhoneNum;
		
		switch(subMenu){
		case 1: //성,이름 수정
			//이름 직장 입력
			System.out.println("이름 : ");
			name = scan.next();
			System.out.println("직장");
			job = scan.next();
			//이름,직장을 수정
			
			
			
			break;
		case 2: //번호 수정
			//기존전화번호들을 출력
			
			//수정할 전화번호 선택
			
			//이름,번호 입력
			System.out.println("수정 번호 입력(ex.직장:010-xxxx-xxxx) : ");
			
			//선택한 이름,번호를 수정
		
			break;
			
		case 3://새 연락처 등록
			//이름,번호를 입력
			System.out.println("수정 번호 입력(ex.직장:010-xxxx-xxxx) : ");
			phoneNum = scan.next();
			//새전화번호 추가
			System.out.println("새 전화번호 입력(ex.직장:010-xxxx-xxxx) : ");
			newPhoneNum = scan.next();
			
			break;
		default: 
			}
		
	}
	
	
	
	
	public static void printPhoneList(ArrayList<phoneNumber> phoneList, Predicate<phoneNumber> p) {
		int count =0;
		for(phoneNumber tmp : phoneList) {
			if(p.test(tmp)) {
				System.out.println(tmp);
				count++;
			}
		}
		if(count ==0 ) {
			System.out.println("검색결과가 없습니다.");
		}
	}

	private static void printUpadateMenu() {
		System.out.println("<수정 메뉴>");
		System.out.println("1.성명,직장 수정");
		System.out.println("2.기존 번호 수정");
		System.out.println("3.새연락처 등록");
	}

	private static void printMenu() {
		System.out.println("< PHONE MENU >");
		System.out.println("1.전화번호 추가");
		System.out.println("2.전화번호 수정");
		System.out.println("3.전화번호 삭제");
		System.out.println("4.전화번호 조회");
		System.out.println("----------------");
		System.out.println("번호 입력 > ");
		}

}//class끝
