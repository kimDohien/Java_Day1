package db.day3.dao;

import db.day3.vo.CourseVO;
import db.day3.vo.LectureVO;

public interface CourseDAO {
	void insertLecture(LectureVO lecture);
	void updateLecture(LectureVO lecture);
	void deleteLecture(int le_num);
	LectureVO selectLectueByName(String le_name, int le_class, int le_year, String le_term,
			String co_st_num);
	 void insertCourse(CourseVO courseVO);
	 void deleteCourse(int le_num, String co_st_num);
}
