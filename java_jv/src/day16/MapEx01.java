package day16;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class MapEx01 { //map은 컬렉션에 속하지 않음

	public static void main(String[] args) {
		
		HashMap<String, String> userList = new HashMap<String,String>();
		//꺽쇠안에 클래스 2개(키,벨류) 써줘야함.
		userList.put("id1", "pw1"); //map은 add가 아니라 put을 써준다.
					//id1이 키(중복 허용X), pw1이 벨류(비번은 중독이 허용)
		userList.put("id2", "pw2");
		userList.put("id3", "pw2"); //아이디느 다른데 비번이 같으면 저장됨.
//		userList.put("id3", "pw3"); //아이디가 같으면 추가가 안되고 덮어쓰기가 된다.
		System.out.println(userList);
		
		
		//방법1. keySet을 이용
		//KeySet()은 map에있는 key들을 하나의 set에 담아 반환하는 메소드 
		//순서 보장X
		Set<String> keySet = userList.keySet();
		for(String tmp : keySet) {
			System.out.println(tmp + " : "+userList.get(tmp));
		}
		
		
		//방법2. EntrySet을 이용
		//Entry클래스 객체 하나에 Key 와 vlaue로 이루어진 하나의 객체이다.
		//ex)"id1", "pw1" 두개(키,벨류)가 하나의 객체이다.
		Set<Entry<String, String>> entrySet = userList.entrySet();
		for(Entry<String, String>tmp : entrySet) {
			System.out.println(tmp.getKey()+" : "+ tmp.getValue());
		}
	
	}

}
