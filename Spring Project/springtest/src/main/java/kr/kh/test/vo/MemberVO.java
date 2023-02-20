package kr.kh.test.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {

	String me_id;
	String me_pw;
	String me_email;
	Date me_birthday;
	int me_authority;
	Date me_join_time;
	
	
	//setter기 때문에 set으로 써줘야함. get을 쓰면 에러
	public void setMe_birthday(String str) {//없으면 400(typeMismatch)에러가 남
		//패턴은 signup.jsp와 맞춰야함(MM은 꼭 대문자로. 소문자로 하면 분이 들어감)
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		try {
			me_birthday = format.parse(str);
		} catch (ParseException e) {
			me_birthday = null;
		}
	}
}
