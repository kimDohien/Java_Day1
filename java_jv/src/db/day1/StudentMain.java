package db.day1;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentMain {
	static Scanner scan = new Scanner(System.in);
	static StudentDB stdDB; //필드를 통해서 편하게 메소드 만드려고 클래스를 static으로
	static ArrayList<Student1> list = new ArrayList<Student1>();
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost/university";
		String id = "root"; 
		String pw = "root";
//		StudentDB stdDB = null;
		
		try {
			stdDB = new StudentDB(url, id, pw);
			
		} catch (Exception e) {
			System.out.println("!DB연결 실패!");
			System.out.println("[프로그램 종료]");
			return;
		}
		//메뉴실행
		int menu =0;
		load();
		do {
			printMenu();
			menu = scan.nextInt();
			scan.nextLine();
			runMenu(menu);
		}while(menu !=3);
	
	}//메인끝

	private static void load() {
		try {
			list = stdDB.selectAllStudent();
		} catch (SQLException e) {
			System.out.println("!로딩 실패!");
		}
		
	}

	private static void runMenu(int menu) { //메뉴실행
	switch(menu) {
	case 1 :
		insertStudent();
		break;
	case 2:
		printStudentList();
		break;
	case 3:
		System.out.println("[종 료]");
		break;
	default : 
		System.out.println("!잘못된 메뉴입니다!");
	}
}

	private static void insertStudent() {
		System.out.println("등록할 학생 정보를 입력하세요");
		System.out.println("학번 : ");
		String st_num = scan.nextLine();
		System.out.println("이름 : ");
		String st_name = scan.nextLine();
		System.out.println("학기 : ");
		int st_semester = scan.nextInt();
		scan.nextLine();
		System.out.println("상태(재학/휴학/자퇴/퇴학) : ");
		String st_status = scan.nextLine();
		System.out.println("교수번호 : ");
		String st_pr_num = scan.nextLine();
		try {
			stdDB.insertStudent(st_num, st_name,st_semester,st_status ,st_pr_num);
			Student1 std = new Student1(st_num, st_name,st_semester,st_status ,st_pr_num);
			list.add(std);
			Collections.sort(list,(o1,o2)->{ //학번순정렬
				return o1.getSt_num().compareTo(o2.getSt_num());
			});
		} catch (SQLException e) {
			System.out.println("!학생등록에 실패했습니다!");
		}
	}

	private static void printStudentList() { //학생정보출력
		if(list.size()==0 )
			System.out.println("[저장된 학생 정보가 없습니다]");
		for(Student1 std : list) { //이쁘게 출력 되고싶으면 tostring 오버라이딩 하면 됨
			System.out.println(std);
		}
	}

	private static void printMenu() { //메뉴출력
		System.out.println("===MENU===");
		System.out.println("1.학생 추가");
		System.out.println("2.학생 조회");
		System.out.println("----------");
		System.out.println("번호 입력 >");
	}
	
}//클래스끝
