package example.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
@AllArgsConstructor
public class StudentVO2 {
	private String num;
	private String name;
	private int semester;
	private String status;
	private String professorNum;
	
}
