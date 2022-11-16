package exampleAccountWork;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;



public class AccountServiceImp implements AccountService {
	
	
	@Override
	public Item inputItem(Scanner scan) throws ParseException {
		//①(구분,목적,내용,금액,일시를 입력)
		System.out.println("구분(수입/지출) : ");
		String type = scan.next();
		System.out.println("분류(식비/교통비.. : ");
		String purpose = scan.next();
		scan.nextLine();//위에서 입력한 엔터처
		System.out.println("내용 : ");
		String content = scan.nextLine();
		System.out.println("금액(정수만 입력) : ");
		int money = scan.nextInt(); 
		System.out.println("일시(2022-11-16) : ");
		String date = scan.next();
		return new Item(type,purpose,content,money,date);
	}

	@Override
	public void insertItem(ArrayList<Item> list, Item item) {
		//②내역 리스트에 내역을 추가
		list.add(item);
		//날짜를 기준으로 정렬
		Collections.sort(list, new Comparator<Item>() {
		
			@Override
			public int compare(Item o1, Item o2) {
				if(o1 == null )
					return 1;
				if(o2 == null)
					return -1;
				return o1.getDate().compareTo(o2.getDate());
			}
		});
		
	}
	

	@Override
	public void printItem(ArrayList<Item> list) {
		if(list.size()==0) {
			System.out.println("기록된 내역이 없습니다.");
			return;
		}
		for(Item item : list) {
			System.out.println(item);
		 }
		
	}

	@Override
	public boolean updateItem(ArrayList<Item> list, int index, Item item) {
		if(index < 0|| index >= list.size()) //예외처리
			return false;
		list.set(index,item);
		return true;
	}
	
	@Override
	public String inputDate(Scanner scan) throws ParseException {
		System.out.println("일시 입력(ex.2022-11-16) : ");
		String date=scan.next();
		
	
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		f.parse(date); 	//잘못입력하면 예외가 발생해서 이 다음기능시 실행안됨. 예외를 발생할수 있는 상황이면 예외를 발생시킴
		return date;
	}

	
	@Override
	public int selectItem(ArrayList<Item> list, String date, Scanner scan) {
		
		//해당 일자에 기록된 내역들을 출력(동일한 날짜가 여러개이기때문에 그중 하나 선택)
		//날짜가 같은 내역들의 번지를 정수형 리스트에 저장
		ArrayList<Integer> indexList = new ArrayList<Integer>();
		
		//날짜가 같은 내역들을 출력
		for(int i=0; i<list.size();i++) {
			if(list.get(i).getDateStr().equals(date))
				indexList.add(i); //번지를 저장함.
		}
		if(indexList.size()==0) { //예외발생
			throw new RuntimeException("예외 발생 : 해당 일시에는 내역이 없습니다.");
		}
		
		//날짜가 같은 내역들을 출력
		for(int i=0; i<indexList.size();i++) {
			System.out.println(i+1+"번 내역");
			list.get(indexList.get(i)).print();
		}
		//수정할 내역 선택
		System.out.println("내역 선택 : ");
		int index= scan.nextInt() - 1; //실제 번지는 0번지 부터니까 -1을 해줘야한다.
		
		if(index < 0 || index>= indexList.size()) //예외발생
			throw new RuntimeException("예외 발생 : 내역을 잘못 선택했습니다.");
		
		return indexList.get(index);
	}

	@Override
	public boolean deleteItem(ArrayList<Item> list, int index) {
		if(index < 0 || index >=list.size())//예외발생
			throw new RuntimeException("예외발생 : 내역을 잘못 선택했습니다.");
		list.remove(index);
		return true;
	}
	
	
	@Override
	public void printMenu() {
		System.out.println("=======메뉴=======");
		System.out.println("1.내역 추가");
		System.out.println("2.내역 확인 ");
		System.out.println("3.내역 수정 ");
		System.out.println("4.내역 삭제 ");
		System.out.println("5.종료 ");
		System.out.println("=================");
		System.out.println("번호 입력 > ");
	}
	

	@Override
	public void runMenu(ArrayList<Item> list, int menu, Scanner scan) throws ParseException {
		switch(menu) {
		case 1 ://추가
			//내역정보 입력
			//가계부에 내역을 추가
			insertItem(list,inputItem(scan));
			break;
			
		case 2 ://확인(전체확인)
			//서브메뉴 선택
			int subMenu = scan.nextInt();
			runPrint(list,subMenu,scan);
			break;
			
		case 3 ://수정
			//수정할 년 월 일 을 입력(ex.2022-11-16)
			String date = inputDate(scan);
			
			//수정할 내역 전체 입력
			//날짜가 같은 내역들의 번지를 정수형리스트에 저장
			int index = selectItem(list,date,scan);
			
			//수정할 내역 전체를 입력함
			Item item = inputItem(scan);
			
			//입력된 내용으로 수정
//			updateItem(list,index,item); 이렇게 호출해야한다.
			updateItem(list, index, item);
			
			break;
			
		case 4 ://삭제
			//수정할 년 월 일 을 입력(ex.2022-11-16)
			System.out.println("일시 입력(ex.2022-11-16) : ");
			//중복된 date이름 때문에 오류가난다. 해결방법1. 스위치문 위에 date선언, 해결방법2.그냥 이름 다르게함
			String date1=scan.next(); 
			
			//해당 일자에 기록된 내역들을 출력
			
			//삭제할 내역 선택
			int index1 = selectItem(list,date1, scan);
			//내역 삭제
			deleteItem(list,index1);
			break;
			
		case 5 ://종료
			//프로그램 종료한다는것은 반복문(AccountBook클래스) 밖에 적어놨으니까..따로 적지않아도 ㄱㅊ
			break;
			
		default : System.out.println("메뉴 입력이 잘못되었습니다.");
			
		
		}
	
	}

	@Override
	public void printItem(ArrayList<Item> list, int... dates) {
		String date = "";
		
		for(int tmp : dates) {
			date +="-"+ (tmp < 10 ? "0"+tmp : tmp);
		}
		date = date.substring(1); //연도 앞에 -를 제거하기 위해
		int size = date.length();
		for(Item item : list) {
			if(item.getDateStr().substring(0, size).equals(date)) {
				System.out.println(item);
			}
		}
		
	}


	@Override
	public int inputYear(Scanner scan) {
		System.out.print("연도 입력 : ");
		int year = scan.nextInt();
		if(year <0)
			throw new RuntimeException("예외발생 : 연도를 잘못입력했습니다.");
		return year;
	}

	@Override
	public int inputMonth(Scanner scan) {
		System.out.print("월 입력 : ");
		int month = scan.nextInt();
		if(month <0 || month>12)
			throw new RuntimeException("예외발생 : 월을 잘못입력했습니다.");
		
		return month;
	}

	@Override
	public int inputDay(Scanner scan) {
		System.out.print("일 입력 : ");
		int day = scan.nextInt();
		if(day <0 || day > 31)
			throw new RuntimeException("예외발생 : 일을 잘못입력했습니다.");
		
		return day;
	}

	@Override
	public void printSubMenu() {
		System.out.println("=========확인 메뉴========");
		System.out.println("1.전체 확인");
		System.out.println("2.년도 확인");
		System.out.println("3.월 확인");
		System.out.println("4.일 확인");
		System.out.println("========================");
		System.out.println("메뉴 선택 : ");
		
	}

	@Override
	public void runPrint(ArrayList<Item> list,int subMenu,Scanner scan) {
		
		int year,month,day;
		//메뉴에 따른 기능 실행
		switch(subMenu) {
		case 1:
			printItem(list);
			break;
		case 2:
			year = inputYear(scan);
			printItem(list, year);
			break;
		case 3:
			year = inputYear(scan);
			month = inputMonth(scan);
			printItem(list, year,month);
			break;
		case 4:
			year = inputYear(scan);
			month = inputMonth(scan);
			day = inputDay(scan);
			printItem(list, year,month,day);
			break;
		default:
			System.out.println(" ");
		}
		
		
	}


	
	
}
		

	

