package day22;

import lombok.Data;

@Data
public class Student {
	//학생(Student)클래스 : 이름 , 생년월일
	private String name,birth;

	public Student(String name, String birth) {
		this.name = name;
		this.birth = birth;
	}

	public Student(Student std) {
		this.name = std.name;
		this.birth = std.birth;
	}

	public void update(String name, String birth) {
		this.name = name;
		this.birth = birth;
		
	}

}
