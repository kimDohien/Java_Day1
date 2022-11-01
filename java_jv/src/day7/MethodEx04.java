package day7;

public class MethodEx04 {

	public static void main(String[] args) {
		
		int num =10; //int num은 밑에printNum(num)까지임
		printNum(num);
		
		Test t = new Test();
		printNum(num);
		printNum(num);
		printTest(t);
		printTest(t);
		
		
	}
	
	//main에 있는 num 와 printNum에 있는 num은 이름은 같지만 서로 다른 변수이다.
	//값을 복사 해서 가져온다. 
	//매개변수가 기본 자료형(int,float,char...)인 경우, printNum에서 숫자를 바꿔도 main에서 num은 안바뀐다.
	 
	
	public static void printNum(int num) { //int num은 메소드 안에서만 사용가능
		System.out.println(num);
		num=20;
	}
	//매개변수가 참조변수인 경우, 다른곳에서 숫자를 바꾸면 main에 있는 값도 바뀔수 있다.
	public static void printTest(Test t) { //원본값이 바뀔수있다.
		System.out.println(t.a);
		t.a=20;
	}
}
class Test{
	int a; //a라는 멤버변수
}