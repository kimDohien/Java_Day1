package exampleShopping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingProgram {
	static Scanner scan = new Scanner(System.in);
	private List<Product> productList = new ArrayList<Product>();//product리스트도 호출
	private ProductController pc = new ProductController(productList, null); //컨트롤러 호출(제품관리하는 productList매개변수 추가. 미리연결)
	private List<Sales> salesList = new ArrayList<Sales>(); //판매리스트 필요
	private SalesController sc = new SalesController(salesList, productList);
	public void run() {//run은 한번실행, 그 안에서 종료버튼을 누를때까지 반복
		int menu = 0;
		final int exit =7; //초반에 임시로 붙여준거
		do {
			try {
			printMenu();
			menu = inputInt();
			exeMenu(menu); //exe메뉴( 메소드 메뉴 )
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}while(menu!=exit);
	}

	private void exeMenu(int menu) {//여기를 컨트롤러를 통해 호출
		//모든 일을controllr에게 일을 시킴
		switch(menu) {
		case 1 :
			pc.insertProduct();
//			System.out.println(productList);//출력확인용
			break;
		case 2:
			pc.updateProduct();
			break;
		case 3:
			pc.deleteProduct();
			break;
		case 4: //구매기능
			sc.sales("구매");
//			System.out.println(salesList); //출력확인용
//			System.out.println(productList); //출력확인용
			break;
		case 5://판매기능
			sc.sales("판매"); //항상 판매가 재고보다 많으면 안된다.
			break;
		case 6://매출액
			sc.print();
			break;
		case 7:
			break;
		default:
			
		}
		
	}

	private int inputInt() {
		int num = scan.nextInt();
		scan.nextLine();
		return num;
	}

	private void printMenu() {
		System.out.println("====메뉴====");
		System.out.println("1.제품 등록");
		System.out.println("2.제품 수정");
		System.out.println("3.제품 삭제");
		System.out.println("4.제품 구매");
		System.out.println("5.제품 판매");
		System.out.println("6.매출액 확인");
		System.out.println("7.프로그램 종료");
		System.out.println("==========");
		System.out.println("메뉴 선택 : ");
		
		
	}
}
