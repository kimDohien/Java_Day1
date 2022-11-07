package day_11;

public class ClassDownCastingEx01 {

	public static void main(String[] args) {
		
		/*클래스 다운 캐스팅은 조건부로 가능
		 *안되는 경우 :  부모 클래스의 객체를 바로 자식 클래스의 객체에 저장하는 경우
		 * 
		 */
//		KiaCar kcar = (KiaCar)(new Car(4,"K5",0x00ff00,"123가4567","기아"));
//		//객체(new Car)을 감싸주고 앞에 입력.
//		kcar.print();

		
		/*
		 * 되는경우 : 자식클래스의 객체를 부모클래스의 객체에 저장한후, 
		 * 			다시 자식 클래스의 객체로 저장하는 경우
		 */
		//1.자식클래스의 객체를 만듬
		KiaCar kcar1= new KiaCar(4,"K5",0x00ff00,"123가4567");
	
		//2.만들어진 객체를 부모에 저장
		Car car = kcar1;
		KiaCar kcar2 = (KiaCar)car;
		kcar2.print();
		
		
		
		
		Car [] carList = new Car[5];
		carList[0] = new KiaCar(4,"K5",0x00ff00,"123가4567");
		carList[1] = new HyundaiCar(3,"Sonata",0xff0000,"456자7891");
		for(Car tmp : carList) {
			if(tmp ==null) {
				continue;
			}
			
			//차 종류에 맞게 기아면 수동으로 기능을 현대면 자동으로 트렁크가 열리게하기 위해 다운캐스팅을 함
			if(tmp instanceof KiaCar) {
				((KiaCar) tmp).hand();				
			}else if(tmp instanceof HyundaiCar) {
				((HyundaiCar)tmp).auto();
			}
		}
		
	}

}
