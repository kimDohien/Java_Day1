package day24;

import java.io.Serializable;

import lombok.Data;

@Data


public class Student implements Serializable{
	private static final long SerialVersionUID = 0;
	
	private String name;
	private int grade,classNum,number;
	
	public Student(String name, int grade, int classNum, int number) {
		this.name = name;
		this.grade = grade;
		this.classNum = classNum;
	}

	@Override
	public String toString() {
		return grade+"학년"+" | "+classNum+"반"+" | "+number+"번"+" | "+name;
	}
	
	
}
