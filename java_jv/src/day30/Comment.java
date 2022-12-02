package day30;

import lombok.Data;

@Data
public class Comment {
	private int num;
	private String contents,writer; 
	private int boardNum; //이 글이 어떤게시글과 연결되는지 해야하기때문에 boardNum
	//수정삭제를 한다면 euqals가 필요하지만,,수정삭제를 안하기때문에 지금은 필요없음
	
	@Override
	public String toString() {
		return "[ 번호 : " + num + " | " +writer +" | "+ contents +  " ]";
	}
	
	public Comment(int num, String contents, String writer,int boardNum) {
		this.num = num;
		this.contents = contents;
		this.writer = writer;
		this.boardNum = boardNum;
	}

	//hashcode/equals :num
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (num != other.num)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		return result;
	}
	
	
	
}
