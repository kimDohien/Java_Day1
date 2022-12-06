package day32;

public class ExceptionEx01 {

	public static void main(String[] args) {
		try {
			test();
		} catch (ArithmeticException e) {
			System.out.println("예외발생 : " + e.getMessage());
		} catch (Exception e) {
			// 뒤에있는애가 앞에있는애의 자손클래스이면 안됨
			// 그래서 Exception은 뒤에 와야한다.
			System.out.println("예외발생 : " + e.getMessage());
		}
	}
	public static void test() throws Exception {
		throw new Exception("런타임 예외 발생");
	}
}
