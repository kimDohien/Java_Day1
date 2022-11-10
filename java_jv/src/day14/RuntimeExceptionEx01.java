package day14;

import lombok.Data;

public class RuntimeExceptionEx01 {

	public static void main(String[] args) {
		/*RuntimeException은 코드상 에러표시가 안나고 실행시 예외가 발생할수있음
		 * 예외처리가 필수가 아님.
		 */
		
		// ArtihmeticException 발생. 이유 : 0으로 나누면 안됨
		int num1 = 1, num2 = 0;
//		System.out.println(1/0);
//		System.out.println(1%0);
//		=>에러

//		System.out.println(num1/num2);
//		System.out.println(num1%num2);
//		=>에러
		
		Parent p = null; //java.lang.NullPointerException 에러 뜸
//		p.print(); //객체를 만들고 바로 null을 입력하면 노란줄이 뜸
//		exceptionTest(p); 
//		int []arr1 = new int[-1]; //예외발생 => 배열의 크기가 음수라서
		int size= -1;
		
		int []arr2 = new int[5];//ArrayIndexOutOfBoundsException 오류 발생 . 접근 할수 없는 번지에 접근시도.
//		arr2[5]=5;
		
		Parent p1 = new Parent(); //ClassCastException 발생. 강제 클래스 변환이 불가능해서
		Child c = (Child)p1;
		
		}

	public static void exceptionTest(Parent a) {
		//a가 null인 경우 NullPointerException 에러 뜸
	a.print();
	
	
	}

}
@Data
class Parent{
	private int num;
	public void print() {
		System.out.println(num);
	}
	
}

class Child extends Parent{}
