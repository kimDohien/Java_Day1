package kr.kh.test.pagination;

import lombok.Data;

@Data
public class Criteria {
	
	private int page;
	
	private int perPageNum;
	
	private String search;
	private int type;
	
	public Criteria() {
		this.page =1;
		this.perPageNum=10;
		this.search ="";
		
	}
	
	public int getPageStart() {
		return (this.page -1) * perPageNum;
	}

}
