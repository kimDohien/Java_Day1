package exampleShopping;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class SalesServiceImp implements SalesService {

	@Override
	public Sales inputSales(String saleType) {
		//입력받는 정보
		Scanner scan= new Scanner(System.in);
		System.out.println("일시 : ");
		String date = scan.nextLine();
		System.out.println("분류 : ");
		String type = scan.nextLine();
		System.out.println("제품명 : ");
		String title = scan.nextLine();
		System.out.println("수량 : ");
		int amount = scan.nextInt();
		if(amount<=0)//구매가 0개이하일때 return값은 없음. 으로 처리
			return null;
		Product product = new Product(type,title,0,0);
		//객체를 만들고
		Sales sales = new Sales(product, amount, 0, date, SalesType.valueOf(saleType));
		//객체를 리턴
		return sales;
	}
	
	
	@Override //년월일 매출결과 확인
	public void printSales(List<Sales> salesList,Predicate<Sales> p) {
		if(salesList == null || salesList.size()==0) {
			System.out.println("!결과가 없습니다!");
			return;
		}
		int count = 0;
		int buyPrice=0;
		int sellPrice=0;
		for(Sales sales : salesList) {
			if(p.test(sales)) {
				System.out.println(sales);
				count++;
				
				if(sales.getType()==SalesType.구매)
					buyPrice += sales.getPrice();
				else 
					sellPrice += sales.getPrice();
			}
		}
		if(count ==0) {
			System.out.println("!결과가 없습니다!");
		}else {
			System.out.println("구매금액 : " +buyPrice);
			System.out.println("판매금액 : "+ sellPrice);
			System.out.println("매출 정산 : "+ (sellPrice - buyPrice));
		}
	}


	@Override
	public void printByYear(List<Sales> salesList) {
		Scanner scan = new Scanner(System.in);
		System.out.println("연도 : ");
		String year= scan.nextLine();
		String date = year;
		printSales(salesList,s->{
			String salesDate = s.getDateStr().substring(0,date.length()); //날짜 가져오는부분을 0번지부터 4개 추철
			return salesDate.equals(date);
		});
	}
	
	

	@Override
	public void printByMonth(List<Sales> salesList) {
		Scanner scan = new Scanner(System.in);
		System.out.println("연도 : ");
		String year= scan.nextLine();
		System.out.println("월 : ");
		String month = scan.nextLine();
		//2022-01 => 월을 받았을때 한자리인경우에는 아펭 0을 붙여주기 위함
		String date = year + "-"+(month.length()<2 ?"0"+ month : month); 
		printSales(salesList,s->{
			String salesDate = s.getDateStr().substring(0,date.length());  
			return salesDate.equals(date);
		});
		
	}


	@Override
	public void printByDay(List<Sales> salesList) {
		Scanner scan = new Scanner(System.in);
		System.out.println("연도 : ");
		String year= scan.nextLine();
		System.out.println("월 : ");
		String month = scan.nextLine();
		System.out.println("일 : ");
		String day = scan.nextLine();
		//2022-01 => 월을 받았을때 한자리인경우에는 아펭 0을 붙여주기 위함
		String date = year + "-" + (month.length()<2 ?"0"+ month : month) + (day.length()<2?"0"+day:day); 
		printSales(salesList,s->{
			String salesDate = s.getDateStr().substring(0,date.length());  
			return salesDate.equals(date);
		});
		
		
	}
}
