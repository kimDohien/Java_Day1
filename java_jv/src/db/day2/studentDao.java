package db.day2;

import java.util.ArrayList;
import java.sql.SQLException;

public interface studentDao { 
	//Dao : DB에 접근하기위한 객체라고 생각하면됨.
	//service : 추가적인 작업을 할때..하는게 service
	ArrayList<StudentV01> selectAllStudent() throws SQLException;
	StudentV01 selectStudentBySt_num(String st_num) throws SQLException;
	boolean insertStudent(StudentV01 std);
	boolean deleteStudent(String st_num);
	boolean updateStudent(StudentV01 std, int subMenu);
}
