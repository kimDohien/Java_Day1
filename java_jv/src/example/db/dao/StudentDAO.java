package example.db.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import db.day3.vo.StudentVO;
import example.db.StudentVO2;

public interface StudentDAO {


	public ArrayList<example.db.StudentVO> selectAllStudent();

	public int insertStudent(example.db.StudentVO std);

	public int updateStudent(example.db.StudentVO std);

	public example.db.StudentVO selectStudent(String st_num);

	//resultMap
	public ArrayList<StudentVO2> selectAllStudent2(); 



	
}
