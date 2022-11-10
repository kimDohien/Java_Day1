package day14;

public class TryCatchEx01 {

	public static void main(String[] args) {
		
		/*try{
		 * 		예외가 발생할수 있는 코드 (자식)
		 * }catch(예외클래스1 e){ (부모)
		 * 		예외 처리;
		 * }catch(예외클래스2 e){
		 * 		예외 처리;
		 * }finally{
		 * 		실행문;
		 * }
		 * -try, catch는 필수
		 * -catch는 1개이상 필요
		 *  ㄴcatch가 여러개인 경우 : 위에 있는 예외 클래스는 아래 클래스의 조상클래스가 오면 안된다.
		 *  ex) 예외클래스1에 RuntimeException이 오고,
		 *  	예외클래스2에 ArithmeticException이 오면 안됨
		 * -finally는 선택(없거나 1개 있거나. 여러번 불가능..only 한번)
		 * 
		 * 
		 */
		
		

		
//		try {
//			System.out.println(1/0);
//		}catch(ArithmeticException  e) { //순서를 ArithmeticException를 위에쓰고 
//			System.out.println("0으로 나누면 안됩니다.");
//		}catch(RuntimeException e) { //RuntimeException을 밑에 써줘야한다.
//			System.out.println("실행 시 예외가 발생했습니다.");
//		}
//		
		exception();
		
	}
	public static void exception() {
	try {
		System.out.println(1/0);
	}catch(ArithmeticException  e) { //순서를 ArithmeticException를 위에쓰고 
		System.out.println("0으로 나누면 안됩니다.");
		return;
	}catch(RuntimeException e) { //RuntimeException을 밑에 써줘야한다.
		System.out.println("실행 시 예외가 발생했습니다."); 
	}finally {//finally는 return이 실행되도 출력이됨
		System.out.println("메소드 종료");
	}System.out.println("HI :)"); //return이 실행되면 출력이 안된다.
		
	}

}
