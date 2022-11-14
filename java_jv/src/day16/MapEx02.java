package day16;

import java.util.HashMap;

import lombok.Data;

public class MapEx02 {

	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		//value를 object로 해서 다양한 객체들을 가져올수있다.
		
		map.put("user", new User("abc", "def"));
		map.put("age", 22);
		map.put("address", "서울시");
		System.out.println(map.get("user"));
		System.out.println(map.get("age"));
		System.out.println(map.get("address"));
		System.out.println(map.get("123"));
		
		//왼쪽은 문자열로 정해놓고 왼쪽에는 그에 맞는 객체들을 넣어서 활용할때 주로 사용..
		//ex)("색상정보",new color("black","red"))
	}

}
@Data
class User{
	private String id,pw;
	public User(String id, String pw) {
		this.id = id;
		this.pw = pw;
		
	}
}
