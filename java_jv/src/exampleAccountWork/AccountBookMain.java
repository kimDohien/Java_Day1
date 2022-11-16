package exampleAccountWork;

import java.text.ParseException;
import java.util.Scanner;

public class AccountBookMain {

	public static void main(String[] args) throws ParseException {
		//이 클래스에서 가계부 실행
		AccountBook ab = new AccountBook(new Scanner(System.in));
		//accountbook이라는 클래스 객체를 만들어서..run실행한다.
		ab.run();
	

	
	}
}

