package day22;

public class ThreadEx01 {
	public static void main(String[] args) {
		Thread t = Thread.currentThread(); 
		System.out.println("현재 쓰레드명 : "+ t.getName());
		
		Thread01 t1 = new Thread01();
		t1.start(); //run이라는 메소드를 실행하는게 아니라 start라는 메소드를 실행해줘야한다.
		for(int i = 0; i<10000;i++)
			System.out.print("|");
	}
}
class Thread01 extends Thread{
	//스레드라는 클래스안에 run이 구현이 안되어있으면 동작을 안한다. 그렇기때문에 오버라이드를 해줘야한다.
	
	@Override
	public void run() {
		for(int i =0 ; i<10000;i++)
			System.out.print("-");
	}
	
}