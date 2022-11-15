package day17;

import lombok.Data;



@Data
public class Member { 
	public Member(String pw, String name, String residentNumber, int age) {
		this.pw = pw;
		this.name = name;
		this.residentNumber = residentNumber;
		this.age = age;	
	}
	//map을 만들기 때문에 id를 제외한 나머지를 기입
	//map을 할것이기에 equals를 할 필요가 없음  => key쪽만 확인하면 되기때문.
	//밑에것들은 value쪽 이기때문에 비교할필요없음..
	private String pw,name,residentNumber;
	private int age;

	
	public void update(String newPw, String name, int age, String residentNumber) {
		this.pw = newPw;
		this.name = name;
		this.residentNumber = residentNumber;
		this.age = age;	
		
	}
}
