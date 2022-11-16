package exampleAccountWork;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//가계부 클래스
public class AccountBook {
	ArrayList<Item> list = new ArrayList<Item>();
	AccountService accountService = new AccountServiceImp();
	Scanner scan; 
	
	public void run() throws ParseException {//실행
		System.out.println("가계부 프로그램 실행합니다");
		int menu =-1;
		do {
			try {
			accountService.printMenu();
			menu = scan.nextInt();
			accountService.runMenu(list, menu, scan); //list,menu,scan이 주어지면 작업실행
			}catch(ParseException e) {
				System.out.println("날짜 형태가 잘못되었습니다.");
			}catch(InputMismatchException e) {
				System.out.println("잘못된 타입을 입력했습니다.");
				scan.nextLine();
			}catch(RuntimeException e){
				System.out.println(e.getMessage());
			}
		}while(menu !=5);
		
		System.out.println("가계부 프로그램 종료합니다");
		
	}
	
	public AccountBook(Scanner scan) { //밖에서 연필을 쓰고 가져다주지 않으면 직접 생성자로 만들어서 함
		if(scan == null) {//이렇게 하면 스캐너를 계속 할당하지않고 걍 써도됨.
			this.scan = new Scanner(System.in);
		}else {
		this.scan= scan;
		}
	}

}
