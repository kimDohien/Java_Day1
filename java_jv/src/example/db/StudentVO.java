package example.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
@AllArgsConstructor
public class StudentVO {
	private String st_num;
	private String st_name;
	private int st_semester;
	private String st_status;
	private String st_pr_num;
	
}
