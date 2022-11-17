package day19;

import java.util.function.Consumer;

public class LambdaEx02 {

	// 람다식 : 인터페이스의 메소드를 오버라이딩 해주는 역할
	public static void main(String[] args) {
		Sum sum = (a,b)-> a+b ;
		System.out.println(sum.run(1, 2));
		
//	-------------------------------------------------
		Print<String> print = num->System.out.println(num); 
					//매개변수 하나인경우 괄호 생략 가능
		print.run1("10");
//		-------------------------------------------------
		
		Consumer<String> print2 = str->System.out.println(str);
		print2.accept("10");
		
	
		}
	}


//람다식을 하려면 인터페이스 필요
interface Sum{
	double run(double a,double b); 
	
}
//-------------------------------------------------
interface Print<T>{ //제네릭 타입에 따라서 다양한 객체들을 넘겨줄수 있다.
	//T는 타입이 아니라 이름이다,, 매겨변수가 여러개 들어간다 치면 <T ,G,..>쓰면 됨
	void run1(T num);
}
//-------------------------------------------------
