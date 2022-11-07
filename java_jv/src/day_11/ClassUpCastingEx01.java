package day_11;

public class ClassUpCastingEx01 {

	public static void main(String[] args) {
		/*업캐스팅
		 * 자식클래스(kiacar)객체를 부모클래스(car)객체에 저장
		 * 업캐스팅은 자동으로 동작
		 */
//		Car car = new KiaCar(4,"K5",0x00ff00,"123가4567");
//		car.print();
		
		
		//car 하나의 배열로 여러타입의 객체들을 관리할수있다.
		Car [] carList = new Car[5];
		carList[0] = new KiaCar(4,"K5",0x00ff00,"123가4567");
		carList[1] = new HyundaiCar(3,"Sonata",0xff0000,"456자7891");
		
	}

}
