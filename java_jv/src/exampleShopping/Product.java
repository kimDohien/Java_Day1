package exampleShopping;

import lombok.Data;

@Data
public class Product {
	private String type;
	private String title;
	private int amount;
	private int buyPrice;
	private int sellPrice;
	
	public Product(String type, String title, int buyPrice, int sellPrice) { //amount제외 => 수량은 구매후에 추가해야하기때문
		this.type = type;
		this.title = title;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
	}
	
	public void addAmount(int amount) {//amount가 양수면 수량 올라감, 음수면 수량 내려감
		this.amount +=amount; 
	}

	@Override
	public String toString() {
		return "[ 분류 : " + type + " | 제품명 : " + title + " | 총수량 : "+amount+ " | 판매가 : " + buyPrice + " | 구매가 :  " + sellPrice + "]";
	}

	//분류랑 제품명 같으면 추가되지 못하도록 하려고 hashcode/equals 추가
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	
	public Product(Product p) { //깊은복사를 위해 생성자 생성. this에 있는것을 p에 덮어씀
		this.type = p.type;
		this.title = p.title;
		this.amount = p.amount;
		this.buyPrice = p.buyPrice;
		this.sellPrice = p.sellPrice;
	}
	
	
}
