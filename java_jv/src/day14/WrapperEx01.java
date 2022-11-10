package day14;

public class WrapperEx01 {

	public static void main(String[] args) {
		//※일반정수나 일반실수 사용가능하지만 null조심할것.

		int num1= 1;
		Integer num2 = num1; //int를 Integer로 받는것을 boxing이라고 함
		//num2=null;//초기화
		int num3 = num2;//Iteger을 다시 int로 받는것을 unboxing이라고 함
		
		//num2인 Integer 객체를 int로 언박싱 하는 경우 num2 null일수 있어서 조심해야한다.
		System.out.println(num3);
		//num2는 참조변수 이기 때문에 null을 저장할수 있는데 num3은 그렇게 하지 못해서 에러가 난다..
		
		
		//<문자열을 정수로>
		String str = "1234";
		int num4 = Integer.parseInt(str); //문자열을 정수로 바꾸는parseInt
		System.out.println(num4+1);
		
		
		//<정수를 문자열로>
		int num5 = 123;
		String str2 = Integer.valueOf(num5).toString(); 
		System.out.println(str2+1);
		//ⓐ강사님 방법↓
		String str3 = ""+num5;
		System.out.println(str3+1);
		
		
	}

}
