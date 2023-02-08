package kr.kh.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class InfoVO {
	private String name;
	private int num; 
	//integer가 아닌 int로 해도되는 이유
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "infoVO [name=" + name + ", num=" + num + "]";
	}
	
	
}
