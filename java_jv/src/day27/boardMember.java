package day27;

import lombok.Data;

@Data
public class boardMember {

	private String id;
	private String pw;
	
	public boardMember(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

}
