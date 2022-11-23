package day22;

import lombok.Data;
@Data
public class StudentLog {
	//학생 일지 클래스(StudentLog) : 이름,생년월일, 출결
	private Student std;
	private String state;
	
	public StudentLog(String name,String birth, String state) {
		std = new Student(name,birth);
		this.state = state;
	}
	
	public StudentLog(Student std, String state) {
		this.std = new Student(std);
		//참조변수는 =을 통해하면 공유되기때문에 문제가 될수있어서 깊은복사를 함.
		this.state = state;
	}

}
