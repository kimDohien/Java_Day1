package day20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Predicate;

public class BookManagerMain_pro2 {
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
		
		int menu =0;
		ArrayList<BookPro> bookList = new ArrayList<BookPro>();
	//반복(출력,선택,기능실행)
		do {
		//메뉴 출력
			printMenu();
		//●메뉴를 선택
		menu = scan.nextInt();	
		printBar();
//		* char menu=scan.nex().charAt(0); 문자로 메뉴를 받고싶으면 char로 문자를 받으면 된다.
//		* case 옆에 문자열 " "로 받아야함
		
		//●메뉴실행
		runMenu(menu,bookList);
		
		}while(menu!=3);//메뉴가 종료메뉴가 아닐때까지 반복
		scan.close();
		
		
	}//main끝
	
	
	private static void runMenu(int menu, ArrayList<BookPro> bookList) {
		String title,author,publish,genre,isbn;
		int price;
		//선택한 메뉴에 따른 기능 실행
		switch(menu) {
		case 1://선택메뉴 1 도서추가
			//<추가할 도서정보 입력>
			BookPro book = createBook();
			
			//도서 추가
			if(!insertBook(bookList,book)){
				System.out.println("이미 등록된 ISBN 번호입니다.");
			}else {
				System.out.println("도서가 등록되었습니다.");
			}
			printBar();
			break;
			
		case 2://선택메뉴 2 도서조회
			
			//서브메뉴 출력
			printSearchMenu();
			//서브메뉴 선택
			int subMenu = scan.nextInt();
			printBar();
			//선택한 서브메뉴 실행
			runPrintMenu(subMenu,bookList);
			break;
 			//선택메뉴 3 프로그램종료 출력
		case 3:
			System.out.println("프로그램 종료");
			break;
			//선택 메뉴가 1,2,3이 아니면 잘못된 메뉴라고 출력
			}
		
	}
	
	public static void printBookList(ArrayList<BookPro> bookList, Predicate<BookPro> p) {
		int count =0;
		for(BookPro tmp : bookList) {
			if(p.test(tmp)) { 
				System.out.println(tmp);
				printBar();
				count ++;
			}
		}
		if(count ==0) {
			System.out.println("검색 결과가 없습니다.");
			printBar();
		}
	}

	private static void runPrintMenu(int subMenu , ArrayList<BookPro> bookList) {
		//서브메뉴 선택
		String title,author,publish,genre;
		int count=0 ;
		
		printBar();
		//선택한 서브메뉴 실행
		switch(subMenu){
			case 1 : //도서명 조회
				System.out.println("도서명을 입력하세요 >");
				scan.nextLine(); //엔터(공백)처리
				title = scan.nextLine();
				printBar();
				//해당 단어가 있으면 결과값이 나오게
				printBookList(bookList,b->b.getTitle().contains(title.trim()));
				break;
				
			case 2 ://저자 조회
				System.out.println("저자를 입력하세요 >");
				scan.nextLine(); //엔터(공백)처리
				author = scan.nextLine();
				printBar();
				//해당 단어가 있으면 결과값이 나오게
				printBookList(bookList,b->b.getAuthor().contains(author.trim()));
				break;
				
			case 3 ://출판사 조회
				System.out.println("출판사를 입력하세요 >");
				scan.nextLine(); //엔터(공백)처리
				publish = scan.nextLine();
				printBar();
				//해당 단어가 있으면 결과값이 나오게
				printBookList(bookList,b->b.getPublish().contains(publish.trim()));
				break;
				
			case 4 ://분류 조회
				System.out.println("분류를 입력하세요 >");
				scan.nextLine(); //엔터(공백)처리
				genre = scan.nextLine();
				printBar();
				//해당 단어가 있으면 결과값이 나오게
				printBookList(bookList,b->b.getGenre().contains(genre.trim()));
				break;
				
			case 5 ://조회 취소
				System.out.println("조회를 취소합니다.");
				printBar();
				break;
				
			default : 
				System.out.println("번호 잘못 입력");
				printBar();
		}
		
	}


	private static void printSearchMenu() {
		System.out.println("조회할 메뉴를 입력하세요 >");
		System.out.println("1.도서명 조회 ");
		System.out.println("2.저자로 조회 ");
		System.out.println("3.출판사 조회 ");
		System.out.println("4.분류 조회 ");
		System.out.println("5.취소");
		printBar();
		System.out.println("번호 입력 : ");
		
	}


	private static boolean insertBook(ArrayList<BookPro> bookList, BookPro book) {
		//isbn중복 체크해서 중복되면 건너뜀 (중복체크는 equals로 오버라이딩)
		//중복 : 리스트에 book객체가 포함되었다 라는 뜻 -> 포함되어있다를 알려주는 contains활용
		if(bookList.contains(book)) {
			return false;
		}
		//중복되지 않으면 추가
		bookList.add(book);
		Collections.sort(bookList,(o1,o2)-> o1.getIsbn().compareTo( o2.getIsbn()));
		//문자열은 -를 쓸수가 없어서compareTo로 적어준다.
		//정수이면 Collections.sort(bookList,(o1,o2)-> o1.getIsbn()-( o2.getIsbn())); 이렇게 적으면 된다.
		return true;
	}


	private static BookPro createBook() {
		System.out.println("추가할 도서 정보를 입력하세요 >");
		printBar();
		
		scan.nextLine(); //엔터처리
		System.out.println("도서명 : ");
		String title = scan.nextLine();
		System.out.println("저자(엮은이,옮긴이..) : "); //여러명이면 ,로 해서 띄어쓰기가 들어가기때문에 nextLine으로
		String author = scan.nextLine();
		System.out.println("가격 : ");
		int price = scan.nextInt();
		scan.nextLine();
		System.out.println("출판사 : ");
		String publish = scan.nextLine();
		System.out.println("장르(소설/에세이..) : ");
		String genre = scan.nextLine();
		System.out.println("ISBN : ");
		String isbn = scan.next();
		
		//<도서목록에 새 도서 추가>
		//위에서 입력받은 도서 정보를 이용하여 도서 객체 생성
		return new BookPro(title,author,publish,genre,isbn,price);
		//BookPro book을 바로 객체에서 받아 보내주도록 return으로 대체
	}


	//<메인메뉴>
	private static void printMenu() {
		System.out.println("<MENU>");
		System.out.println("1.도서 추가");
		System.out.println("2.도서 조회");
		System.out.println("3.종료");
		printBar();
		System.out.println("번호 입력 : ");
		
	}
	public static void printBar() {
		System.out.println("-----------------");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}//class끝
