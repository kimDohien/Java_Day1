package kr.kh.spring;

public class LoginVO {
	private String id;
	private int pw;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPw() {
		return pw;
	}
	public void setPw(int pw) {
		this.pw = pw;
	}
	@Override
	public String toString() {
		return "LoginVO [id=" + id + ", pw=" + pw + "]";
	} 
}
