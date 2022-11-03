package day9;

public class AbstractionEx01 {

	public static void main(String[] args) {
		
		Student std1 = new Student(1,1,1,"김도현");
		std1.updateScore(50,30,45);
		std1.print();
		

		
		
	}
	
	
	
}
/*학생 성적 관리 프로그램에서 필요한 학생 클래스를 만들어 보세요
 * 학생은 학년,반,번호,이름
 * 성적은 국어,영어,수학 성적만 관리. 각 과목은 100점 만점을 기준으로 관리
 * 학생 정보 출력 기능
 * 성적을 수정하는 기능
 * -국어
 * -영어
 * -수학
 * -국어,영어,수학(한꺼번에 수정)
 * 학생 정보의 초기값
 * -학년 : 1, 반 :1, 번호 :1, 이름 :빈문자열, 성적 :0
 * 
 * */
class Student{
	private int grade,room,num;
	private String name;
	private int kor, eng, math;
	
	public void print() {
		System.out.println(grade+"학년 "+room+"반 "+num+"번 "+name);
		System.out.println("국어 : "+kor +","+"영어 : "+eng +","+"수학 : "+ math );
			
	}
	public void updateKor(int kor1) {//②
		kor= kor1;
	}
	public void updateEng(int eng1) {
		eng = eng1;
		
	}
	public void updateMath(int math1) {
		math = math1;
	}
	public void updateScore(int kor1, int eng1,int math1) {// ①
		updateKor(kor1);
		updateEng(eng1);
		updateMath(math1);
	}
	public Student() {
		grade =1;
		room =1;
		num =1;
		name ="";
	}
	//생성자 만들기(우클릭->source->)
	public Student(int grade1, int room1, int num1, String name1) {
		super();
		grade = grade1;
		room = room1;
		num = num1;
		name = name1;
	}
	
	
	
}