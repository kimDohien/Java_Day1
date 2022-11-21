package day21;

import java.util.regex.Pattern;

import lombok.Data;

@Data
//핸드폰 번호만 입력받아서 저장하는것
public class phoneNumber_pro { 
	private String pName,number; //number를 유효성 검사를 해야한다.
	
	public void setNubmer(String number) {
		String regex ="\\d{2,3}-\\d{3,4}-\\d{4}";//정규표현식을 자바에서 쓸때는 역슬래쉬를 두번 해줘야한다.
		
		if(Pattern.matches(regex, number)) {
			this.number = number;
		}else {
			throw new RuntimeException("예외발생 : 번호를 잘못 입력하였습니다.");
		}
	}
	
	//<생성자>
	public phoneNumber_pro(String pName, String number) {
		this.pName = pName;
		setNubmer(number); //this.number =number를 setNuber로 바꿔서 정규표현식으로 바꿈
	}
	
	@Override
	public String toString() {
		return "["+pName + " : " + number + "]";
	}

	public void update(String pName, String number) {
		this.pName = pName;
		this.number=number;
		
	}

	
}
