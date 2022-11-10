package day14;

public class ThrowEx01 {

	/*throws : 메소드가 실행됐을때 발생할수 있는 예외를 표시
	 * 		   여러개 예외 가능 
	 * 		   RuntimeException과 자식 예외 클래스들은 생략 가능
	 * 		   그 외 예외 클래스들은 생략 불가능
	 * throw : 예외를 발생시켜주는것 . 조건에 따라 의도적으로 예외를 발생시킴
	 * 		   예외 객체를 던져준다..(?)
	 * 		   throw를 통해 예외가 발생하면 메소드를 빠져 나옴
	 */
	public static void main(String[] args) {
//		System.out.println(mod(1,0));
		try {
		throwTest(); //반드시 예외처리 해줘야함
		}catch(Exception e) {
			System.out.println("예외 발생");
		}
	}
	//나머지구하는 기능을 메소드로 뺌
	public static int mod(int num1, int num2)throws ArithmeticException { 
		
		return num1/num2;
	}
	
	//무조건 예외 발생시키게 만들어준거임
	public static void throwTest() throws Exception { //throws Exception를 써줘서 예외 오류 해결
		throw new Exception();
	}
}
