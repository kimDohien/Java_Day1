package day19;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PredicateEx01 {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student(1, 1, 2, "a", 100, 90, 50));
		list.add(new Student(1, 2, 1, "b", 65, 80, 40));
		list.add(new Student(1, 1, 4, "c", 75, 40, 60));

		/*
		 * 1학년 1반 학생들을 출력하는 코드를 작성하세요 
		 * 1학년 3반 학생들을 출력하는 코드를 작성하세요 
		 * 1학년 학생들을 출력하는 코드를 작성하세요
		 */

		// 1학년 학생들 출력

		print(list, 1, 1);
		System.out.println("-------------");
		print(list, 1, 2);
		System.out.println("-------------");
		printA(list,(s)->s.getGrade() ==1 && s.getClassNum()==1);
		printA(list,(s)->s.getGrade() ==1);
		printA(list,(s)->s.getName().charAt(0)=='홍');
	}

	public static void print(ArrayList<Student> list,int grade,int classNum) {
	for (Student tmp : list) {
		if(tmp.getGrade()== grade && tmp.getClassNum() == classNum) {
			System.out.println(tmp);
			}
		
		}
	}

	public static void print(ArrayList<Student> list, int grade) {
		for (Student tmp : list) {
			if (tmp.getGrade() == grade) {
				System.out.println(tmp.getName());
			}

		}
	}
		//람다식
		public static void printA(ArrayList<Student> list,Predicate<Student> p) {
			for (Student tmp : list) {
				if (p.test(tmp)) {
					System.out.println(tmp);
				}

			}
		}
	
	}

