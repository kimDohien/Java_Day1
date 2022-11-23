package day22;

import java.util.ArrayList;
import lombok.Data;
@Data
public class Attendance {
	//출석부 클래스(Attendance) :학생들, 일지들
	//지각,조퇴,출석,결석,,,
	
	//학생정보
	private ArrayList<Student> stds=  new ArrayList<Student>();
	private ArrayList<Log>logs = new ArrayList<Log>();
	
}
