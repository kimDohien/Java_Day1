package day20;

import java.text.DecimalFormat;

import lombok.Data;

@Data
public class BookManager {

	
	public BookManager(String bookName, String writer, int money, String publish, String type) {
		this.bookName = bookName;
		this.writer = writer;
		this.publish = publish;
		this.type = type;
		this.money = money;
		++count;
		num=count;
	}
	public String print() {
		return "---------------------\n"
				+num+"."+ "\n"
				+"제목 : "+bookName+ "\n"
				+"저자 : "+ writer+ "\n"
				+"출판사 : "+publish+ "\n"
				+"분류 : "+type+ "\n"
				+"가격 : "+getMoneyStr()+ "\n"
				+"---------------------";
	}
	
	public String getMoneyStr() {
		DecimalFormat df = new DecimalFormat("###,###");  //DecimalFormat은 10진수 포맷
		return df.format(money);
	}
	
	private static int count=0;
	private String bookName,writer,publish,type;
	private int money,num;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookManager other = (BookManager) obj;
		if (num != other.num)
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		return result;
	}
	
	
	
	
}
