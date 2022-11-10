package day14;

public class ExceptionEx01 {

	public static void main(String[] args) {
		/*printStackTrace() 
		 * > 예외가 발생했을 때 실행된 메소드들을 차례대로 역순으로 출력
		 * > 발생한 예외와 예외 메세지도 같이 출력
		 * getMessage () 
		 * > 예외가 발생한 이유를 출력
		 * > 사용자가 발생시킨 예외라면 생성자에 넘겨준 문자열이 출력된다
		 * 
		 */
		try {
			throwException();
		}catch(Exception e) {
			//printStackTrace ,getMessage() 를 사용한다.
			e.printStackTrace(); 
			System.out.println(e.getMessage());
		}
		

	}
	public static void throwException() throws Exception{
		throw new Exception("예외발생");
		
		
	}
}

//오류값 밑에서부터 읽어줘야함
//at day14.ExceptionEx01.throwException(ExceptionEx01.java:17)
//at day14.ExceptionEx01.main(ExceptionEx01.java:7)