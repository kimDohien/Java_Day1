package day_11;

public class PolymorphismEx01 {

	public static void main(String[] args) {
		//다형성예제
		
		connectToComputer(new Mouse());
		connectToComputer(new KeyBoard());
		connectToComputer(new Speaker());
	}
	
	//상속사용하지 않고 각각 필요한 개수만큼 만들어도됨 =>굉장히 노가다
//	public static void connectToComputer(Mouse obj) {
//		System.out.println("마우스와 연결되었습니다.");
//	}
//	public static void connectToComputer(KeyBoard obj) {//오버로딩
//		System.out.println("키보드와 연결되었습니다.");
//	}
//	public static void connectToComputer(Speaker obj) {//오버로딩
//		System.out.println("스피커와 연결되었습니다.");
//	}
	
/*매개변수의 다형성 => 메소드 오버로딩을 줄여줌
 * 매개변수로 부모 클래스의 객체를 전달하여, 같은 부모를 가진 자식 클래스 객체를 매개변수로 활용할수 있게 하는것
 * 	
 */

public static void connectToComputer(UsbProduct obj) {
	System.out.println(obj.type + "와 연결되었습니다.");
	}

}


class UsbProduct{
	public String type;
}
//extends UsbProduct 상속
class Mouse extends UsbProduct {
	{
	type ="마우스";
	}
} 
class KeyBoard extends UsbProduct {
	{
		type ="키보드";
		}
}
class Speaker extends UsbProduct {
	{
		type ="스피커";
		}
}
