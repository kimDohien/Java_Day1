package day9;

public class ThisEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test03 t1 = new Test03();
		
		Test03 t2 = new Test03(10);
		
	}

}
/* this : 객체 본인(me)을 나타내는 참조변수
 *  -주로 매개변수의 이름과 멤버변수의 이름이 같으면서, 메소드 안에서 같이 사용되는 경우 사용한다.
 *  =>ⓐ메소드에서 매개변수의 이름과 필드의 이름이 같으면 변수를 호출했을때 매개변수가 불려진다.
 *  -메소드명이 길때 자동완성을 위해서 사용
 *  
 *  this() : 해당 클래스(me)의 생성자를 호출 , 생성자에서 첫번째 줄에 추가!
 *  
 */

class Test03{
	private int num;
	public void setNum(int num) { 
		this.num=num; //ⓐ this : 매개변수의 이름과 필드의 이름을 구분짓는다.
		
	}
	public int getNum() {
		return num;
	}
	public void print() {
		System.out.println(this.getNum());
	}
	
	public Test03() {
		this(10);//this(10)을 호출하면 밑에Test03이 호출된다.
		//this();로 쓰면 나 자신에게 빠져서 무한루프가 된다.
		num=20;
	}
	public Test03(int num) {
		this.num=num;
	}

}