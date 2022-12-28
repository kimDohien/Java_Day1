package example.db.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import example.db.StudentVO;
import example.db.StudentVO2;
import example.db.dao.StudentDAO;



public class MainController {
	private SqlSession session;
	private StudentDAO studentDao;
	
	private Scanner scan = new Scanner(System.in);
	
	public MainController(SqlSession session) {
		this.session = session;
		studentDao = session.getMapper(StudentDAO.class);
		
	}

	
	public void run() {
		/*학생 추가
		 * 학생 수정
		 * 학생 조회
		 * 프로그램 종료
		 */
	int menu =0;
	int exit =4;
	do {
		try {
		printMenu();
		menu = scan.nextInt();
		scan.nextLine();
		runMenu(menu);
		}catch(InputMismatchException e) {
			System.out.println("잘못된 타입을 입력");
			scan.nextLine();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		}while(menu!= exit);
	}
	
	private void runMenu(int menu) {
		switch(menu){
			case 1:
				insertStudent();
				break;
			case 2:
				updateStudent();
				
				break;
			case 3:
				selectAllStudent();
				break;
			case 4:
				System.out.println("프로그램 종료");
				break;
			default: System.out.println("잘못된 메뉴");
		}
		
	}
	

	private void selectAllStudent() {
	ArrayList<StudentVO> list = studentDao.selectAllStudent();
//	ArrayList<StudentVO2> list = studentDao.selectAllStudent2(); //resultMap버전
	if(list.size()==0) {
		System.out.println("결과가 없습니다.");
		return;
	}
	for(StudentVO tmp : list) {
		System.out.println(tmp);
	}
//	for(StudentVO2 tmp : list) {
//		System.out.println(tmp);
//	}
	}


	private void updateStudent() {
		System.out.println("<추가할 학생 정보 입력>");
		System.out.println("학번 : ");
		String st_num = scan.nextLine();
		System.out.println("학기 : ");
		int st_semester= scan.nextInt();
		scan.nextLine();
		System.out.println("상태(재학/휴학/퇴학/자퇴) : ");
		String st_status= scan.nextLine();
		
		StudentVO std= studentDao.selectStudent(st_num); //학번으로 학생정보 가져옴
		if(std == null) {
			System.out.println("수정 실패");
		}
		std.setSt_semester(st_semester);
		std.setSt_status(st_status);
		
		if(studentDao.updateStudent(std) != 0) {
			System.out.println("[학생수정완]");
			session.commit();
		}else {
			System.out.println("!학생 수정 실패");
		}
		
	}

	private void insertStudent() {
		System.out.println("<추가할 학생 정보 입력>");
		System.out.println("학번 : ");
		String st_num = scan.nextLine();
		System.out.println("이름 : ");
		String st_name= scan.nextLine();
		System.out.println("학기 : ");
		int st_semester= scan.nextInt();
		scan.nextLine();
		System.out.println("상태(재학/휴학/퇴학/자퇴) : ");
		String st_status= scan.nextLine();
		System.out.println("지도교수 번호 : ");
		String st_pr_num= scan.nextLine();
		StudentVO std = new StudentVO(st_num,st_name,st_semester,st_status,st_pr_num);
		if(studentDao.insertStudent(std) != 0) {
			System.out.println("[학생추가완]");
			session.commit();
		}else {
			System.out.println("!학생 추가 실패");
		}
	}

	private void printMenu() {
		System.out.println("===MENU===");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 조회");
		System.out.println("4. 프로그램 종료");
		System.out.println("-----------");
		System.out.println("번호 입력 > ");
		
	}

}
