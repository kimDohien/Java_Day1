package db.day3.service;

import java.util.Scanner;

import db.day3.DBConnector;
import db.day3.dao.CourseMapper;
import db.day3.dao.ProfessorMapper;
import db.day3.vo.*;


public class CourseServiceImp implements CourseService {
	private CourseMapper courseDao;
	private Scanner scan = new Scanner(System.in);

	
	public CourseServiceImp(DBConnector dbConnector) {
		courseDao = new CourseMapper(dbConnector);
	
	}


	public void insertLecture() {
		System.out.println("강좌명 : ");
		String le_name = scan.nextLine();
		System.out.println("일정 : ");
		String le_schedule = scan.nextLine();
		System.out.println("학점 : ");
		int le_point = scan.nextInt();
		scan.nextLine();
		System.out.println("분반 : ");
		int le_class = scan.nextInt();
		scan.nextLine();
		System.out.println("연도 : ");
		int le_year = scan.nextInt();
		scan.nextLine();
		System.out.println("학기 : ");
		String le_term = scan.nextLine();
		System.out.println("지도교수 번호");
		String le_pr_num = scan.nextLine();
		LectureVO lecture = new LectureVO(0, le_name, le_schedule, le_point, le_class, le_year, le_term, le_pr_num);
		courseDao.insertLecture(lecture);
	}


	public void updateLecture() {
		System.out.println("강좌번호 : ");
		int le_num = scan.nextInt();
		scan.nextLine();
		System.out.println("강좌명 : ");
		String le_name = scan.nextLine();
		System.out.println("일정 : ");
		String le_schedule = scan.nextLine();
		System.out.println("학점 : ");
		int le_point = scan.nextInt();
		scan.nextLine();
		System.out.println("분반 : ");
		int le_class = scan.nextInt();
		scan.nextLine();
		System.out.println("연도 : ");
		int le_year = scan.nextInt();
		scan.nextLine();
		System.out.println("학기 : ");
		String le_term = scan.nextLine();
		System.out.println("지도교수 번호");
		String le_pr_num = scan.nextLine();
		LectureVO lecture = new LectureVO(le_num, le_name, le_schedule, le_point, le_class, le_year, le_term, le_pr_num);
		courseDao.updateLecture(lecture);
		
	}


	public void deleteLecture() {
		System.out.println("강좌번호 : ");
		int le_num = scan.nextInt();
		scan.nextLine();
		courseDao.deleteLecture(le_num);
		
	}


	public void insertCourse() {
		System.out.println("강좌명(정확히입력) : ");
		String le_name = scan.nextLine();
		System.out.println("분반 : ");
		int le_class = scan.nextInt();
		scan.nextLine();
		System.out.println("연도 : ");
		int le_year = scan.nextInt();
		scan.nextLine();
		System.out.println("학기(정확히 입력)");
		String le_term = scan.nextLine();
		System.out.println("학번 : ");
		String co_st_num = scan.nextLine();
		System.out.println("학점 : ");
		String co_type = scan.nextLine();
		LectureVO lec = courseDao.selectLectueByName(le_name,le_class,le_year,le_term,co_st_num);
		if(lec ==  null) {
			System.out.println("수강 신청 실패");
			return;
		}
		courseDao.insertCourse(new CourseVO(0, co_st_num, lec.getLe_num(), co_type, null));
	}


	public void deleteCourse() {
		System.out.println("강좌명(정확히입력) : ");
		String le_name = scan.nextLine();
		System.out.println("분반 : ");
		int le_class = scan.nextInt();
		scan.nextLine();
		System.out.println("연도 : ");
		int le_year = scan.nextInt();
		scan.nextLine();
		System.out.println("학기(정확히 입력)");
		String le_term = scan.nextLine();
		System.out.println("학번 : ");
		String co_st_num = scan.nextLine();
		System.out.println("학점 : ");
		String co_type = scan.nextLine();
		LectureVO lec = courseDao.selectLectueByName(le_name,le_class,le_year,le_term,co_st_num);
		if(lec ==  null) {
			System.out.println("수강 취소 실패");
			return;
		}
		courseDao.deleteCourse(lec.getLe_num(),co_st_num);
		
	}

}
