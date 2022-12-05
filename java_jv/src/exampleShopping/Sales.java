package exampleShopping;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.Data;
@Data
public class Sales {
	//객체하나하나가 한제품을 몇개팔았는지 언제팔았는지에대한 정보를 기록하는 클래스
	
	//<필요한 정보>
	//제품 정보 ,수량 ,타입(구매/판매), 총 금액,일시
	private Product product;
	private int amount,price;
	private Date date;
	private SalesType type; //SalesType대신 String써도됨
	
	public Sales(Product product, int amount, int price, String date, SalesType type) {
		this.product = product;
		this.amount = amount;
		this.price = price;
		SimpleDateFormat f = new SimpleDateFormat("yyy-MM-dd");
		try {
			this.date = f.parse(date);
		} catch (ParseException e) {
			this.date =null;
		}
		this.type = type;
	}

	public void calculate(String type) { //price계산
		if(product == null)
			return;
		int price=0;
		
		if(SalesType.valueOf(type)==SalesType.구매)
			price= product.getBuyPrice() * amount;
		else if(SalesType.valueOf(type)==SalesType.판매)
			price = product.getBuyPrice()*amount;
		
		this.price = price;
		
		
	}
	public String getDateStr() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		if(date == null)
			return " "; //날짜가 없으면 빈문자열로 출력
		return f.format(date);
	}

	@Override
	public String toString() {
		return " 분류 :  " +product.getType()+" | 제품명 :  " + product.getTitle() + type.toString() 
					+" | 수량 : "+ amount + " | 가격 :" + price + " | 일시 : " + getDate() ;
		//getDate를 오버라이딩해서 예쁘게 나오게 하려고함...
		//type.toString을 하려는것은 구매,판매를 구분하려하기 위해
	}
	
	
}
enum SalesType{
	판매, 구매
}
