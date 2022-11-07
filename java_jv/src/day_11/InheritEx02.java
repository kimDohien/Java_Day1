package day_11;

public class InheritEx02 {

	public static void main(String[] args) {
		
	KiaCar kcar = new KiaCar(4,"K5",0xff0000,"134가1815");
	kcar.powerOn();
	kcar.chageGear('D');
	for(int i=0; i<30 ; i++) {
		kcar.accel();
	}
	//자동차 상태확인
	kcar.print();
	for(int i=0; i<30 ; i++) {
		kcar.breaker();
	}
	kcar.chageGear('P');
	kcar.powerOff();
	//자동차 상태확인
	kcar.print();
	
	System.out.println("------------------");
	
	HyundaiCar hcar = new HyundaiCar(4,"쏘나타",0xff0000,"125가1815");
	hcar.powerOn();
	hcar.chageGear('D');
	//자동차 상태확인
	hcar.print();
	for(int i=0; i<30 ; i++) {
		hcar.accel();
	}

	
	for(int i=0; i<30 ; i++) {
		hcar.breaker();
	}
	hcar.chageGear('P');
	hcar.powerOff();
	hcar.print();

	
	}

}

/*
 * 자동차 클래스 , 타이어 클래스 
 * 기아자동차 클래스, 현대자동차 클래스 를 만들어보세요.
 * 
 * 자동차  
 * - 타이어,타이어 개수, 차종, 색상, 번호 ,전원(시동), 속력,기어,
 * - 기능 : 전원 켜기/끄기, 기어변경, 속력up/down
 * 
 * 타이어 
 * - 색상, 제조사, 크기, 종류(snow/일반), 상태
 * - 기능 : 상태출력
 * 기아자동차 - 제조사가 기아, 자동차 클래스를 상속받음
 * 현대자동차 - 제조사가 현대, 자동차 클래스를 상속받음
 * 
 */
class Tire {
	public String company;
	public int size;
	public boolean isSnow;
	public boolean isStop;
	public void print() {
		if(isStop) {
			System.out.println("정지");
		}else {
			System.out.println("굴러가는중");
		}
	}
}


class Car{
	public Tire[] tires;//타이어가 여러개니까 배열로해야한다
	public int tireCount;
	public String type;
	public int color;
	public String carNum;
	public boolean power;
	public int speed;
	public char gear;
	public String company;
	
	//생성자
	public Car(int tireCount, String type, int color, String carNum, String company) {
		this.tireCount = tireCount <= 0 ? 4 : tireCount;
		this.type = type;
		this.color = color;
		this.carNum = carNum;
		this.company = company;
		this.gear = 'p';
		tires = new Tire[tireCount];
	}
	//메소드 - 전원켜기/끄기, 기어변경, 소력업/다운
	public void powerOn() {
		power = true;
		}
	public void powerOff() {
		power = false;
		}
	public void chageGear(char gear) {//이거는 뭘로 해야할지 입력해줘야하기때문에 입력
		if(gear == 'P'&& speed !=0) {
			return;
		}
		this.gear =gear;
//		if(gear == 'p') {
//			if(speed == 0) {
//				this.gear = gear;
//			}
//		}else {
//			this.gear = gear;
//		}
	}	
	public void accel() {
		speed += 1;
	}
	public void breaker() {
		speed -= 1;
		if(speed<0) {
			speed = 0;
//			speed =speed <=0 ? 0 : speed -1; (위 3줄을 한줄로 줄여씀)
		}

	}
	public void print() {
		System.out.println("전원 : "+ (power ? "ON" : "OFF"));
		System.out.println("속력 : "+ speed);
		System.out.println("기어 : "+ gear);
		System.out.println("회사 : "+ company);
		System.out.println("차종 : "+ type);
	}
}
class KiaCar extends Car{

	public KiaCar(int tireCount, String type, int color, String carNum) {
		super(tireCount, type, color, carNum, "기아");
		
	}
	
}
class HyundaiCar extends Car{

	public HyundaiCar(int tireCount, String type, int color, String carNum) {
		super(tireCount, type, color, carNum, "현대");
		
	}
	
}