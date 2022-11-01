package day7;

public class ClassTestEx01 {

	public static void main(String[] args) {
		/* <인스턴스화(객체) 방법>
		 * 클래스명 객체명 = new 클래스명();
		 * 
		 */
		String str = new String("abc");
		Person Person1 = new Person();
//		person1.PNo("000101-2123456"); 원래는 이렇게 썼는데 밑에 set,get을 설정했기때문에 밑에처럼 변경해줘야함.
		/*주석으로 처리한 이유는 : pNo에 private을 추가하기 전에는 외부에서 접근이 가능했지만 
		*캡슐화를 통해 pNo의 접근제한자를 private로 설정하면 직접 접근이 불가능하다 . =>에러발생
		* 캡슐화된 pNo에 접근하려면 getter & setter를 통해 접근해야 한다.
		* */
		Person1.setpNo("000101-2123456");
		
//		System.out.println("주민번호 : "+ person1.pNo);
		System.out.println("주민번호 : "+ Person1.getpNo());
		System.out.println(str.charAt(1));//문자의 n번째 값을 가져온다

		
	}

}
//<class문법>

//class 클래스명 { 
//	  접근제한자 자료형 변수명; //이전체를 멤버변수 라고한다.
//
// 막으려면 접근제한자를 불여야함. 
// 
//}

/*
 * 접근제한자 종류 
 * - private 	: 본인 클래스(내부에서는 쓸수있지만 외부에서는 쓸수 없음), 내 클래스 안에서만 사용 가능
 * 					일반적으로 멤버변수는 private을 쓴다. 
 * - (default)	: '본인 클래스 + 같은 패키지' 안에서는 부를수 있음. 자료형 앞에 아무것도 안쓴것을 디폴트라고 함
 * - protected	: '본인 클래스 + 같은 패키지 + 자식클랙스' 
 * - public		: '본인 클래스 + 같은 패키지 + 자식클랙스 + 외부 클래스'=>전부 (아무나 다 접근 가능) 
 * 
 * 
 */
class Person{ //클래스 이름은 대문자로 써줘야함
	private String pNo;
	private String name;
	private char gender;
	private String address;
	private String phone;
	private int age;
	
	
	public String getpNo() {
		return pNo;
	}
	public void setpNo(String pNo) {
		this.pNo = pNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
	
