package day14;

import java.util.ArrayList;

import lombok.Data;
@Data
public class Student { //studentmanagertest와 이어지는 student 클래스 만듬
	

	
	//필드 : 학년,반,번호,이름,성적들
	private int grade;
	private int classNum;
	private int num;
	private String name;
	private ArrayList<Score> scoreList = new ArrayList<Score>();
	
	
	/**
	 * 학생 정보에 성적을 추가하는 메소드 
	 * @param 추가할 성적
	 * @return 추가 여부
	 * 
	 */
	
	public boolean addScore(Score score) {
		if(score == null) {
			throw new RuntimeException("성적 정보가 없어서 추가할수 없습니다.");//예외처리
		}
		
		//학생의 성적 정보들 중에서 과목, 학기가 같은 성적 정보가 없으면 추가
		boolean res = scoreList.contains(score);
		if(res) { 
			return false;
		}
		scoreList.add(new Score(score));
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
		Student other = (Student) obj;
		if (classNum != other.classNum)
			return false;
		if (grade != other.grade)
			return false;
		if (num != other.num)
			return false;
		return true;
	}




	//기본생성자
	public Student() {
	}
	
	//학년,반,번호,이름를 이용한 생성자
	public Student(int grade, int classNum, int num, String name) {
//		super();
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
		
	}
	
	//학년,반,번호를 이용한 생성자
	public Student(int grade, int classNum, int num) {
//		super(); //얘의 부모는 object이기에 지금은 피료없음
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
	}


	public void printScore() {
		for(Score tmp : scoreList) {
			System.out.println(tmp);
		}
		
	}
}
