package db.day3.service;

import java.util.Scanner;

import db.day3.DBConnector;
import db.day3.dao.StudentMapper;
import db.day3.vo.StudentVO;

public class StudentServiceImp implements StudentService{

	private DBConnector dbConnector;
	private StudentMapper studentDao;
	private Scanner scan = new Scanner(System.in);
	
	public StudentServiceImp(DBConnector dbConnector) {
		studentDao = new StudentMapper(dbConnector);
	}

	public void insertStudent() {
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
		studentDao.insertStudent(std);
		
	}

	public void updateStudent() {
		System.out.println("<수정할 학생 정보 입력>");
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
		studentDao.updateStudent(std);
		
	}

}
