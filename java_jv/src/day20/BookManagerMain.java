package day20;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

import exampleAccountWork.Item;


public class BookManagerMain {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		/*
		 * 도서관리 프로그램을 작성하세요
		 * 도서정보 :
		 * - 도서명, 저자(여러명, 엮은이, 옮긴이 다 포함) , 가격, 출판사
		 * 기능
		 * -도서 추가
		 * 	-ISBN으로 정렬
		 * -도서 조회
		 * 	-도서명으로 조회
		 * 	-저자로 조회
		 * 	-출판사로 조회
		 * 	-분류로 조회
		 * 
		 */

		
		int menu = 0;
		ArrayList<BookManager> bookList = new ArrayList<BookManager>();
		
		do {
			printMenu();
			menu = scan.nextInt();
			runMenu(bookList,menu);
		}while(menu!=3);

	}
	//기능
	private static BookManager runMenu(ArrayList<BookManager> bookList, int menu) {
		switch(menu) {
		case 1 : //도서 추가
			inputBook(bookList);
			break;
			
		case 2://도서 조회
			printBook(bookList,menu);
			
		default : 
			System.out.println("번호를 잘못 입력하였습니다.");
		
		}
		return null;
	}
	
	
	
	
	//서브메뉴 메소드
	private static void printBook(ArrayList<BookManager> bookList, int menu) {
		printSubMenu(menu);
		int subMenu = scan.nextInt();
		String bookName,writer,publish,type;
		
		switch(subMenu) {
	case 1 : //도서명으로 조회
		scan.nextLine();
		System.out.println("도서명 입력: ");
		//도서 이름 입력
		bookName = scan.next();
		//그 도서의 내용 전체 출력
		printBooks(bookList,(s)->s.getBookName().equals(" "+bookName));
		break;
	
	case 2://저자로 조회
		scan.nextLine();
		System.out.println("저자 입력: ");
		//저자  입력
		writer = scan.next();
		//그 도서의 내용 전체 출력
		printBooks(bookList,(s)->s.getWriter().equals(" "+writer));
		break;	
	
	case 3://출판시로 조회
		scan.nextLine();
		System.out.println("출판사 입력: ");
		//출판사 입력
		publish = scan.next();
		printBooks(bookList,(s)->s.getPublish().equals(" "+publish));
		break;	
		
	case 4://분류로 조회
		scan.nextLine();
		System.out.println("분류 입력: ");
		//분류 입력
		type = scan.next();
		printBooks(bookList,(s)->s.getType().equals(" "+type));
		break;	
		
	default :
		System.out.println("번호를 잘못 입력하였습니다.");
		
		break;
		}
		
	}
	
	
	public static void printBooks(ArrayList<BookManager> bookList, Predicate<BookManager> p) {
		for(BookManager book : bookList) {
			if(p.test(book)) {
				System.out.println(book);
			}
		}
	}
	
	private static void printSubMenu(int menu) {
		switch(menu) {
		case 2:
			System.out.println("조회할 메뉴를 입력하세요 >");
			System.out.println("1.도서명 조회 ");
			System.out.println("2.저자로 조회 ");
			System.out.println("3.출판사 조회 ");
			System.out.println("4.분류 조회 ");
			System.out.println("-----------------");
			System.out.println("번호 입력 : ");
			break;
		}
	}
		
		
	
	
	public static boolean inputBook(ArrayList<BookManager> bookList) {
		
		System.out.println("책 정보를 입력하세요 > ");
		System.out.println("도서명 : ");
		String bookName = scan.next();
		System.out.println("저자(엮은이,옮긴이..) : ");
		String writer = scan.nextLine();
		scan.nextLine();
		System.out.println("가격 : ");
		int price = scan.nextInt();
		System.out.println("출판사 : ");
		String publish = scan.next();
		scan.nextLine();
		System.out.println("분류(소설/에세이..) : ");
		String type = scan.next();
		scan.nextLine();
		
		BookManager book = new BookManager(bookName,writer,price,publish,type);
		if(bookList.contains(book)) {
			return false;
		}
		bookList.add(book);
		System.out.println("책이 등록되었습니다.");
		return true;
	}
	

	//메뉴
	private static void printMenu() {
		System.out.println("<MENU>");
		System.out.println("1.도서 추가");
		System.out.println("2.도서 조회");
		System.out.println("3.종료");
		System.out.println("-----------------");
		System.out.println("번호 입력 : ");
	}

}
