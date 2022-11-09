package day13;

import lombok.Data;
@Data
public class Student2 { //studentmanagertest와 이어지는 student 클래스 만듬
	

	
	//필드 : 학년,반,번호,이름,성적들
	private int grade;
	private int classNum;
	private int num;
	private String name;
	private Score [] scoreList;
	private int maxSize; //최대 저장할수있는 성적 수
	private int count; //현재 저장된 성적 수(현재 성적이 몇개 저장되어있는지)
	
	
	/**
	 * 학생 정보에 성적을 추가하는 메소드 
	 * @param 추가할 성적
	 * @return 추가 여부
	 * 
	 */
	
	public boolean addScore(Score score) {
		if(score == null) {//socre가  null이면 if문을 벗어난다
			return false;
		}
		
		//배열의 성적들이 꽉 찼을때,,
		if(count == maxSize) {//count가  maxsize와 같으면 if문을 벗어난다
			return false;
		}
		//학생의 성적 정보들 중에서 과목, 학기가 같은 성적 정보가 없으면 추가
		for(int i =0; i< count; i++) { 
			if(score.equals(scoreList[i])) { 
				return false; 
			}
		}
		scoreList[count]=new Score(score); //좋은 방식은 아님,,(?)
		count++;
		return true;
	}
	
	
	
	
	/*메소드 : getter/setter(private 으로 작성해서외부에서 접근하지못하게 하기위해)
	*		 equals() (학년,반,번호가 있는지 중복확인)
	*		 to string() (객체를 쉽게 문자열로 만들기 위해서)
	*/		 
	
	
	
	
	
	//toString
	@Override
	public String toString() {
		return"["+ grade + "학년 "+ classNum + "반 "+num+"번호 "+name+"]";
	}
	
	/*생성자 : 초기화 ctrl+space를 통해서 기본생성자 만들수있음.
	*학년,반,번호,이름이 필요한 생성자(학생정보 추가시 활용할)
	*학년,반,번호가 필요한 생성자(성적 추가시 학생이 있는지 없는지 판별할때 활용)
	*/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classNum;
		result = prime * result + grade;
		result = prime * result + num;
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student2 other = (Student2) obj;
		if (classNum != other.classNum)
			return false;
		if (grade != other.grade)
			return false;
		if (num != other.num)
			return false;
		return true;
	}




	//기본생성자
	public Student2() {
	}
	
	//학년,반,번호,이름를 이용한 생성자
	public Student2(int grade, int classNum, int num, String name) {
//		super();
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
		
		maxSize = 30;
		scoreList = new Score[maxSize];
	}
	
	//학년,반,번호를 이용한 생성자
	public Student2(int grade, int classNum, int num) {
//		super(); //얘의 부모는 object이기에 지금은 피료없음
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		
		maxSize = 30;
		scoreList = new Score[maxSize];
		
	}




	public void printScore() {
		for(int i =0; i<count; i++) {
			System.out.println(scoreList[i]);
		}
		
	}
}
