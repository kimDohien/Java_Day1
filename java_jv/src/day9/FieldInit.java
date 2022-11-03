package day9;

public class FieldInit {

	public static void main(String[] args) {
		
		Test04 t= new Test04(4);
		t.print();

	}

}
class Test04{
	private int num1; //1.기본 초기값으로 초기화
	private int num2 =2; //2.명시적 초기화
	private int num3 =2; //2.명시적 초기화
	private int num4 =2; //2.명시적 초기화
	
	{//중괄호 쓰면 초기화블록
		num3 = 3; //3.초기화 블록
		num4 = 3; //3.초기화 블록
	}
	public Test04(int num4) {
		this.num4 = num4; //4.생성자 초기화
	}
	public void print() {
	
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		System.out.println("num3 : " + num3);
		System.out.println("num4 : " + num4);
		
	}
}