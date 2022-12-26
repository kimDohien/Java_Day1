package db.day2;

import java.sql.*;
import java.util.*;

import lombok.Data;

public class studentManager {
	//필드선언
	Connection con;
	static Scanner scan = new Scanner(System.in);
	static studentDAOImp studentDao; 
	
	public static void main(String[] args) {
		studentManager sm = new studentManager();
		
		
		String url = "jdbc:mysql://localhost/university";
		String id = "root", pw ="root";
		
		try {
			sm.connect(url,id,pw);
			studentDao = new studentDAOImp(sm.con);
		
			int menu = 0;
			do {
				printMenu();
				menu = scan.nextInt();
				scan.nextLine();
				runMenu(menu);

			}while (menu != 5);
			
		}catch(Exception e) {
			System.out.println("예외발생 : 프로그램 종료");
		}finally {
			sm.closeConnect();
		}
		
	}
	

	private static void runMenu(int menu) throws Exception {

		switch (menu) {
		case 1://조회
			printStudentList();
			break;
		case 2://추가
			insertStudent();
			break;
		case 3://수정
			updateStudent();
			break;
		case 4://삭제
			deleteStudent();
			break;
		case 5:System.out.println("[종료]"); 	break;
		default:
			System.out.println("!잘못된 메뉴입니다!");

		}
	}

	private static void updateStudent() {//수정
		int subMenu=0;
		printSubMenu();
		subMenu= scan.nextInt();
		scan.nextLine();
		System.out.println("학번 : ");
		String st_num = scan.nextLine();
		 String st_name =null, st_status=null, st_pr_num=null;
		 int st_semester = 0;
		switch(subMenu) {
		case 1:
			System.out.println("이름 : ");
			st_name = scan.nextLine();
			break;
		case 2:
			System.out.println("학기 : ");
			st_semester = scan.nextInt();
			scan.nextLine();
			break;
		case 3:
			System.out.println("상태 : ");
			st_status = scan.nextLine();
			break;
		case 4:
			System.out.println("지도교수 번호 : ");
			st_pr_num = scan.nextLine();
			break;
		case 5:System.out.println("[종료]");
			break;
		default:
			System.out.println("!잘못된 메뉴입니다!");
		}
		StudentV01 std = new StudentV01(st_num,st_name,st_semester,st_status,st_pr_num);
		studentDao.updateStudent(std, subMenu);
	}


	private static void printSubMenu() {//수정 서브메뉴
		System.out.println("====UPDATE MENU====");
		System.out.println("1.이름 수정");
		System.out.println("2.학기 수정");
		System.out.println("3.상태 수정");
		System.out.println("4.지도교수 수정");
		System.out.println("5.취소");
		System.out.println("-------------");
		System.out.println("번호 입력 > ");
		
	}


	private static void deleteStudent() {//삭제
		System.out.println("학번입력 : ");
		String st_num = scan.nextLine();
		if(studentDao.deleteStudent(st_num))
			System.out.println("[삭제 완료]");
		else
			System.out.println("!삭제 실패!");
	}


	private static void insertStudent() {
		System.out.println("학번 : ");
		String st_num = scan.nextLine();
		System.out.println("이름 : ");
		String st_name= scan.nextLine();
		System.out.println("학기 : ");
		int st_semester= scan.nextInt();
		scan.nextLine();
		System.out.println("상태(재학/휴학/퇴학) : ");
		String st_status= scan.nextLine();
		System.out.println("지도교수 번호 : ");
		String st_pr_num= scan.nextLine();
		if(studentDao.insertStudent(new StudentV01(st_num, st_name,st_semester,st_status,st_pr_num)))
			System.out.println("[학생을 추가했습니다]");
		else
			System.out.println("!학생추가 실패!");
		
	}


	private static void printStudentList() throws Exception {//조회
		List<StudentV01> list = studentDao.selectAllStudent();
		if(list.size()==0) {
			System.out.println("!등록된 학생이 없습니다!");
		}else {
			for(StudentV01 tmp : list)
				System.out.println(tmp);
		}
		
	}


	private static void printMenu() {//메뉴출력
		System.out.println("====MENU====");
		System.out.println("1.조회");
		System.out.println("2.추가");
		System.out.println("3.수정");
		System.out.println("4.삭제");
		System.out.println("5.종료");
		System.out.println("-------------");
		System.out.println("번호 입력 > ");

	}

	public void connect(String url, String id, String pw) throws SQLException {
		con = DriverManager.getConnection(url, id, pw);
	}

	public void closeConnect() {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
