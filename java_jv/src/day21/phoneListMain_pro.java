package day21;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;



public class phoneListMain_pro {
	
	static Scanner scan = new Scanner(System.in); 
	//Static을 붙여주는 이유 : 
	
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
	
	int menu =0;
	ArrayList<phoneBook_pro> list = new ArrayList<phoneBook_pro>();
	//반복
	do {
		//<메뉴 출력>
		printMenu();
		
		try{ 
			//<메뉴 선택>
			menu = scan.nextInt();
			//<선택된 메뉴 실행>
			runMenu(menu,list);
		}catch(RuntimeException e) {
			System.out.println(e.getMessage());
			System.out.println("--------------");
		}
		
		}while(menu!=5);
	
	}
	
	//<메뉴실행>
	private static void runMenu(int menu, ArrayList<phoneBook_pro> list) {
		switch(menu) {
		//1.번호 추가 (추가 기능을 insertPhoneBook 메소드 에 저장)
		case 1:
			if(insertPhoneBook(list)) { //if안에 넣었다는것은 return타입을 boolean으로 하기위해. 추가가 실패할수도 있기때문ㅇ
				System.out.println("전화번호 추가하였습니다.");
			}else {
				System.out.println("전화번호 추가하지 못하였습니다.");
			}
		
			break;
			
		case 2:
		//2. 번호 수정
			if(updatePhoneBook(list)) {
				System.out.println("★수정이 완료되었습니다.★");
			}else {
				System.out.println("!!수정하지 못하였습니다!!");
			}
			
			break;
		
		case 3:
		//3. 번호 삭제 (삭제가 될수도 있고 안될수도 있기에 if문 써줌)
			if(deletePhoneBook(list)) {
				System.out.println("연락처를 삭제했습니다.");
			}else {
				System.out.println("전화번호를 삭제하지 못하였습니다.");
			}
			
			break;
		
		case 4:
		//4. 번호 조회
			printSearchNumber(list); //얘는 실패할수가 없기에 if문 안쓰고 바로.
			
		
			break;
		case 5:
		//5. 프로그램 종료
			System.out.println("프로그램 종료");
			System.out.println("================");
			break;
		default : 
			System.out.println("없는 메뉴입니다.");
			System.out.println("=================");
		}
	}//★main끝★
	
	
	private static boolean updatePhoneBook(ArrayList<phoneBook_pro> list) {
		//이름을 입력
		scan.nextLine();
		System.out.println("이름 입력 : ");
		String name = scan.nextLine();
		//이름이 포함된 전화번호부를 검색하여 출력(번호와 함께)
		ArrayList<Integer> indexs = searchPhoneBook(list, p->p.getName().contains(name));
		//수정할 전화번호부를 선택
		printIndexsNumber(list, indexs);
		System.out.println("수정할 전화번호부 선택 : ");
		int selectIndex = scan.nextInt()-1;//보여주는번호 와 번지는 다르기 때문에 -1해줘야함.
		if(selectIndex < 0 || selectIndex > indexs.size()){//예외처리
			throw new RuntimeException("잘못 선택했습니다.");
		}
		//서브 메뉴 출력
		printSubMenu();
		//서브 메뉴 선택
		
		int subMenu = scan.nextInt(); 
		//서브 메뉴 실행
		int index = indexs.get(selectIndex);
		return runSubMenu(subMenu,list.get(selectIndex));
	}
	
	
	//<서브메뉴 실행>
	private static boolean runSubMenu(int subMenu, phoneBook_pro pb) { //pb는 그냥 임의로 정해준거고 pb는 수정한 객체가 들어갈 곳임.
		if(pb == null) {//예외처리
		return false;
		}
		
		switch(subMenu) {
		//1. 이름, 직장 수정
		case 1:
			//이름 직장 입력
			scan.nextLine();//엔터제거
			System.out.println("이름 : ");
			String name = scan.nextLine();
			System.out.println("직장 : ");
			String company = scan.nextLine();
			//이름, 직장을 수정
			pb.update(name,company); //update메소드 만듬
		break;
		
		//2. 기존 전화번호 수정
		case 2:
			
			//기존 전화번호들를 출력
			pb.printPhoneNumbers();
			//수정할 전화번호를 선택
			System.out.println("번호 입력 : ");
			int index = scan.nextInt()-1;
			//이름, 번호를 입력
			scan.nextLine();
			System.out.println("이름 : ");
			String pName = scan.nextLine();
			System.out.println("전화번호 : ");
			String number =scan.nextLine(); 
			//선택한 전화번호 이름, 번호를 수정
			pb.getPnList().get(index).update(pName, number); //update메소드 생성
			
		break;
		//3. 새 전화번호 추가
		case 3:	
			scan.nextLine();//공백처리
			//이름 번호를 입력
			ArrayList<phoneNumber_pro> pnList = inputPhoneNumbers(); //inputPhoneNumbers메소드 가져옴
			//새 전화번호를 추가
			pb.getPnList().addAll(pnList);
		break;
		
		default: 
			System.out.println("잘못된 메뉴입니다.");
			System.out.println("==============");
			return false;
		}
		return true;
	}

	
	//<서브메뉴 출력>
	private static void printSubMenu() {
		scan.next();
		System.out.println("===SubMenu===");
		System.out.println("1. 이름, 직장 수정");
		System.out.println("2. 기존 전화번호 수정");
		System.out.println("3. 새 전화번호 추가");
		System.out.println("-----------------");
		System.out.println("번호 입력 : ");
		
	}

	private static void printIndexsNumber(ArrayList<phoneBook_pro> list, ArrayList<Integer> indexs) {
		if(indexs == null || indexs.size()==0 || list == null || list.size()==0) {
			throw new RuntimeException("검색 결과가 없습니다.");//당장 시급하게 코드를 바꿀필요없지만,,예외처리를 해줘야할때 쓰는 런타임을 씀
		}
		
		for(int i = 0 ; i<indexs.size();i++) {//있으면 출력
			int index = indexs.get(i);
			System.out.println(i+1+". "+list.get(index));
		}
		System.out.println("===================");
		
	}
	
	private static void printSearchNumber(ArrayList<phoneBook_pro> list) {
		//이름을 입력
		scan.nextLine();
		System.out.println("이름 입력 : ");
		String name = scan.nextLine();
		//이름이 포함된 전화번호부를 검색하여 출력(번호와 함께)
		ArrayList<Integer> indexs = searchPhoneBook(list,p->p.getName().contains(name));
		//확인된 번지에 있는 번호들을 출력(번호와 함께)
		printIndexsNumber(list,indexs);
		//조회할 전화번호부를 선택 
		System.out.println("조회할 전화번호부 선택 : ");
		int selectIndex = scan.nextInt()-1;
		if(selectIndex < 0 || selectIndex > indexs.size()){//예외처리
			return ;
		}
		//전화번호 조회
		list.get(selectIndex).print();//예쁘게 출력을 위해 print메소드 만듬.=>phoneBook클래스에 생성됨.
	}

	
	//<case3.전화번호 삭제>
	private static boolean deletePhoneBook(ArrayList<phoneBook_pro> list) {
		//이름을 입력
		scan.nextLine(); //엔터처리
		System.out.println("이름 입력: ");
		String name = scan.nextLine();
		//이름이 포함된 전화번호부를 검색하여 번지를 확인 
		ArrayList<Integer> indexs = searchPhoneBook(list, p->p.getName().contains(name));//번지들 검색
		//확인된 번지에 있는 번호들을 출력(번호와 함께)
		printIndexsNumber(list,indexs);
		//삭제할 전화번호부를 선택
		System.out.println("삭제할 전화번호부를 선택하세요 : ");
		int selectIndex = scan.nextInt()-1;
		if(selectIndex < 0 || selectIndex > indexs.size())//예외처리
			return false;
		//전화번호를 삭제
		int deleteIndex = indexs.get(selectIndex);
		return list.remove(deleteIndex) != null; 
		//해당번지에서 삭제를 시도하고 삭제 성공하면 삭제한 객체정보를 알려줌(null이 아닌게..) return이 그렇다고 함.
		
	}

	
	//<case3.전화번호부 번지 확인>
	private static ArrayList<Integer> searchPhoneBook(ArrayList<phoneBook_pro> list, Predicate<phoneBook_pro> p ) {
			ArrayList<Integer> indexs = new ArrayList<Integer>(); //번지들 저장하기위해 리스트 만들어줌
			for(int i = 0; i<list.size();i++) {
				if(p.test(list.get(i))) //테스트를 했을때 참이면 주소 번지를 저장..
					indexs.add(i);
			}
		return indexs;
	}

	
	//<case 1.핸드폰번호 추가>
	private  static phoneNumber_pro inputPhoneNumber() {
		//전화번호를 입력(직장 :번호) =>PhoneNumber
		System.out.println("이름(직장,집 등.. ):");
		String pName = scan.nextLine();
		System.out.println("휴대폰 번호(예.010-xxxx-xxxx) : ");
		String number =scan.nextLine(); 
		
		return new phoneNumber_pro(pName,number);
	}
	
	
	//<case1.전화번호 추가 입력 반복문>
	private static ArrayList<phoneNumber_pro> inputPhoneNumbers(){
		ArrayList<phoneNumber_pro> pnList = new ArrayList<phoneNumber_pro>();
		do {
				//입력받은 이름,번호를 이용하여 phoneNumber_pro객체를 만들고,
				phoneNumber_pro pn = inputPhoneNumber();
				//만들어진 phoneNumber_pro객체를 phoneNubmer_pro리스트에 추가
				pnList.add(pn);
				//전화번호를 더 입력할건지 물어봄
				System.out.println("핸드폰번호를 더 추가하시겠습니까?(y/n) : ");	
		}while(scan.nextLine().charAt(0)!='n'); //변수선언 안하고 바로 입력 비교하는법
		return pnList;
	}
	

	//<case 1. 전화번호 추가>
	private static boolean insertPhoneBook(ArrayList<phoneBook_pro> list) {
		//성명,직장 입력
		scan.nextLine();
		System.out.println("성명:");
		String name = scan.nextLine();
		System.out.println("직장 : ");
		String company =scan.nextLine(); 
			//반복
		ArrayList<phoneNumber_pro> pnList;
		try {
			//전화번호들을 입력
			pnList = inputPhoneNumbers();
		}
		catch(RuntimeException e) {
			return false;
		}
		//성명,직장,전화번호들(phoneNumber_pro리스트)를 이용하여 phoneBook_pro에 객체를 생성
		phoneBook_pro pb = new phoneBook_pro(name,company,pnList);
		//list에 phoneBook객체를 추가
			list.add(pb);	
			System.out.println(list);
		return true; 
	}

	//<메뉴출력>
	private static void printMenu() {
		System.out.println("=======MENU======");
		System.out.println("1.전화번호 추가");
		System.out.println("2.전화번호 수정");
		System.out.println("3.전화번호 삭제");
		System.out.println("4.전화번호 조회");
		System.out.println("5.프로그램 종료");
		System.out.println("=================");
		System.out.println("메뉴선택 : ");
		
	}
	
	
	
	

}
