package day28;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data

public class Member implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8129425427566287306L;
	private String id,pw;
	private Date joinDate;
	private Authority authority;
	
	//id,pw만 hashcode&equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pw == null) {
			if (other.pw != null)
				return false;
		} else if (!pw.equals(other.pw))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		return result;
	}
		
	//기본생성자
	public Member(String id, String pw, Authority authority) {
		this.id = id;
		this.pw = pw;
		this.authority = authority;
		joinDate = new Date();
	}
	
	//id,pw둘다 있는 생성자
	public Member(String id,String pw) {
			this(id,pw,Authority.MEMBER);
		}	
	
}

//관리자인지 아닌지 구분하기위해 열거형사용
enum Authority{
	ADMIN, MEMBER
}
