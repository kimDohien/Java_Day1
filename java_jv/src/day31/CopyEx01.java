package day31;

import lombok.Data;

public class CopyEx01 {

	public static void main(String[] args) {
		//1.얕은복사
		Test t1 = new Test(10,20,"김도현");
		Test t2 = t1;
		System.out.println("t1 : "+ t1);
		System.out.println("t2 : " + t2);
		System.out.println("---------------");
		t1.setNum1(30);//t1을 30으로 바꾼다음
		t1.getSub().setName("이용진");
		System.out.println("t1 : " + t1);
		System.out.println("t2 : "+ t2);
		
		
		//깊은복사
		Test t3 = new Test(10,20,"김도현");
		Test t4 = new Test(t3);//에러가 나는 이유는 생성자가 없기때문이다. 생성자 만들어줌
		System.out.println("---------------");
		System.out.println("t3 : "+ t3);
		System.out.println("t4 : " + t4);
		System.out.println("---------------");
		t3.setNum1(30);
		t3.getSub().setName("이용진");
		System.out.println("t3 : "+ t3);
		System.out.println("t4 : " + t4);
	}
}

@Data
class Test{
	int num1, num2;//필드
	Sub sub; //클래스의 객체가 오는경우
	public Test(int num1, int num2,String name) {//생성자
		this.num1 = num1;
		this.num2 = num2;
		this.sub= new Sub(name);
	}
	
	public Test(Test t) {
		this.num1 = t.num1; 
		this.num2 = t.num2;
//		this.sub = t.sub; //한쪽이 변하면 같이 변함. 
		
		//<깊은 복사를 하려면 필드가 참조변수인 경우, 생성자를 이용하여 복사해야됨>
//		this.sub = new Sub(t.sub);//새 객체 만듬
		this.sub = new Sub(t.sub.getName());//기존생성자에 이름을 직접 가져와서 새로운 객체를 만들어 넘겨주던지..
	}
}

@Data
class Sub{
	String name;
	public Sub(String name) {
		this.name= name;
	}
	public Sub(Sub sub) {
		this.name= name;
	}
}
