package day9;

public class StaticEx01 {

	public static void main(String[] args) {
		
		KiaCar kc1 = new KiaCar("모닝");
		KiaCar kc2 = new KiaCar("레이");
		KiaCar kc3 = new KiaCar("k3");
		kc1.print();
		kc2.print();
		kc3.print();
		kc1.name ="k5";
//		kc1.logo ="Kia"; 가능은 하지만 일반적이지 않다.
		KiaCar.logo="Kia";
		System.out.println("----------");
		kc1.print();
		kc2.print();
		kc3.print();
		
				
	}

}

class KiaCar{
	public static String logo = "KIA"; //static은 공유
	public String name;
	public KiaCar(String name) {
		this.name = name;
	}
	public void print() {
		System.out.print(logo);
		System.out.println(" : " + name);
	}
	public static void printLogo() {
		System.out.print(logo);
// 		System.out.println(" : " + name); 
//		name에러 발생
//		name은 객체필드이기 때문에 static이 붙은 메소드에서는 호출할수없다.
	}
}