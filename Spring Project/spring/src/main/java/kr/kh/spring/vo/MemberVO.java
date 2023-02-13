package kr.kh.spring.vo;

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

	public void setMe_birthday(String str) { // 없으면 400(typeMismatch)에러가 남
	
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			me_birthday = format.parse(str);
		} catch (ParseException e) {
			me_birthday = null;
		}
	}

	public Object getMe_id() {
		// TODO Auto-generated method stub
		return null;
	}

}
