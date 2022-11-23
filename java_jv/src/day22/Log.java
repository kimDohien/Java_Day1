package day22;
import java.util.ArrayList;
import lombok.Data;
@Data
public class Log {
	//하루치 출석부
	//일지 클래스(Log): 날짜 , 학생일지들(이름,생년월일,출결)
	
	private ArrayList<StudentLog> slogs = new ArrayList<StudentLog>();
	String date;
	
	//학생들 정보&날짜를 주는 
	public Log(ArrayList<StudentLog> stdLogs, String date) {
		this.date = date;
		this.slogs= stdLogs; //원래는 깊은 복사를 해줘야하는데 간단하게 얕은 복사
	}
}
