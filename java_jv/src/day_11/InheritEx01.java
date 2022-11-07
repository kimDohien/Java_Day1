package day_11;

public class InheritEx01 {

	public static void main(String[] args) {
		/*상속
		 * A is a B (~은 ~이다)로 표현이 가능하면 상속을 한다.
		 * A가 자식클래스(상속을 받은클래스) , B가 부모클래스(상속을 하는 클래스)
		 * 
		 * ex)
		 * 스마트폰은 폰이다 = >상속O
		 * 스마트폰은 카메라이다 =>상속X
		 * 폰은 스마트폰이다 =>상속X
		 * 현대차는 자동차이다.=>상속O
		 * 
		 * 
		 * 부모를 가르키는 애는 super,와 super()이다. 
		 */
		
		
		Child1 c = new Child1();
		c.print();
		
	}

}

class Child1 extends Parents1{ //한명의 부모만 와야한다. <단일상속>
	public Child1() {
		super(1,2,3); //슈퍼는 첫번째 줄에 써야한다.
		
//		num1 = 10; 접근제한자가 private이어서 자식클래스에서 사용하지 못한다.
		num2 = 20; //접근제한자가 디폴트 이어서 같은 패키지에 있기 때문에 가능.
					//상속여부와 상관이 없다.
		num3 = 30; //접근제한자가 protected이여서 자식클래스에서 사용할수 있다.
	}				//다른패키지 이어도 사용가능하다.
	
	public void print() {
		//부모클래스의 객체와 똑같음.
//		System.out.println(num1);
//		System.out.println(num2);
//		System.out.println(num3);
		super.print();
		//부모클래스를 호출하고 싶을때 super을 사용.
		System.out.println("자식 클래스의 메소드입니다.");
	}
	
}


class Parents1{
	private int num1 =1;
	int num2=2;
	protected int num3 = 3;
	
	public void print() {
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
	}
	//생성자 추가
	public Parents1(int num1, int num2, int num3) {
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		
	}
	
}
