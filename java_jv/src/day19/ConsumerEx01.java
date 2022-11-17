package day19;

import java.util.ArrayList;
import java.util.function.Consumer;



public class ConsumerEx01 {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student(1,1,2,"김도현",100,90,50));
		list.add(new Student(1,3,1,"심유택",65,80,40));
		list.add(new Student(1,1,4,"심유현",75,40,60));
		
		print(list, (a) -> System.out.println(a));
		
		//상황에 따라서 다양하게 출력 형태를 바꿔줄수 있다.
		print(list, (a) -> {
			System.out.println("학년 : " +a.getGrade());
			System.out.println("반 : " +a.getClassNum());
			System.out.println("번호 : " +a.getNum());
			System.out.println("이름 : " +a.getName());
		});
		
	}

	public static void print(ArrayList<Student> list, Consumer<Student> con) {
		for(Student tmp : list) {
			con.accept(tmp);
		}
	}
}
