package day27;

public class ThreadEx02 {

	public static void main(String[] args) {
	Runnable runnable = new NewThread2();
	Thread t= new Thread(runnable);
	t.start(); //run이라는 메소드를 호출
	Thread thisThread = Thread.currentThread();
	for(int i =0; i<10 ; i++) {
		System.out.println(thisThread.getName()+"쓰레드 실행");
		try {
			Thread.sleep(1000);//1000ms = 1초간 멈춘다.
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
	}
	
	}

}

class NewThread2 implements Runnable{ //NewThread라는 새로운 클래스를 만듦
	@Override
	public void run() {
		for(int i =0 ; i<10; i++) {//10번출력
			//콘솔에 쓰레드 이름과 쓰레드실행을 1초마다 한번씩 찍어줌(10번 될때까지)
			System.out.println(/*this.getName()+*/"쓰레드 실행"); //getName을 쓸수 없다.
			try {
				Thread.sleep(1000);//1000ms = 1초간 멈춘다.
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	
	}
}