package exampleShopping;

import java.util.List;
import java.util.Scanner;

public class SalesController {
	private List<Sales> salesList;
	private List<Product> productList; //제품 정보 필요=>제품을 구매하거나 판매할때 제품정보가 필요하기때문.
	private ProductService ps; //
	private SalesService ss;//일을 시켜줄꺼니까
	
	public SalesController(List<Sales> salesList, List<Product> productList) {
		this.salesList = salesList;
		this.productList = productList;
		ps = new ProductServiceImp();
		ss = new SalesServiceImp();
	}

	public void sales(String type) { //구매,판매
		//제품 정보 입력(타입, 제품명, 수량)
//		Sales sales = ss.inputSales();//salesService에 구매할 제품 정보 입력을 통해 객체 만들어줌
//		sales.setType(SalesType.valueOf("구매")); //만들어진 객체의 타입을 구매로 하면 됨.
		Sales sales = ss.inputSales(type); //간단하게 이렇게 적어도 괜찮다.
		
		//입력한 제품 정보를 가져온다
		Product product = ps.getProduct(productList, sales.getProduct()); //가져오고
		if(product == null){//구매하려는 제품이 없는경우 예외처리
			System.out.println(type+"정보를 잘못 입력했습니다.");
			return;
		}
		
		sales.setProduct(new Product(product));
		int amount =sales.getAmount();
		amount = type.equals("구매") ? amount : -amount;
		
		//재고정리
		ps.productStock(product, amount);
		
		//매출 금액을 계산
		sales.calculate("구매");//총금액을 계산
		
		//전체 매출에 현재 매출 정보를 추가
		salesList.add(sales);
		System.out.println("[제품 : "+type +"이 완료되었습니다]");
	}

	public void print() {//매출확인
		int subMenu = 0;
		final int exit =4;
		Scanner scan = new Scanner(System.in);
		do {
			printSubMenu();
			subMenu = scan.nextInt();
			scan.nextLine();
			exePrintMenu(subMenu);
		}while(subMenu!=exit);
		
	}

	private void exePrintMenu(int subMenu) {
		switch(subMenu) {
		case 1:
			ss.printByYear(salesList);
			break;
		case 2:
			ss.printByMonth(salesList);
			break;
		case 3:
			ss.printByDay(salesList);
			break;
		case 4:
			System.out.println("[이전으로 돌아갑니다]");
			break;
		default:
			System.out.println("!메뉴를 잘못 선택했습니다!");
		}
		
	}

	private void printSubMenu() {
		System.out.println("===SubMenu===");
		System.out.println("1.년별");
		System.out.println("2.월별");
		System.out.println("3.일별");
		System.out.println("4.이전");
		System.out.println("=============");
		System.out.println("메뉴 선택 : ");
		
		
	}


	
}
