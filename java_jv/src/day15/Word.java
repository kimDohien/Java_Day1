package day15;

public class Word {
	private String word;
	private String mean;
	
	//생성자
	public Word(String word, String mean) {
		super();
		this.word = word;
		this.mean = mean;
	}

	
	
	//toString
	@Override
	public String toString() {
		return "[" + word + " : " + mean + "]";
	}


	//equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) { //객체(단어들)이 다 다르기때문에..수정해줌
			//위에는 워드클래스 밑에는 스트링 클래스
			if(!(obj instanceof String)) { //문자열로 형변환할수 없는애들은 return false로가서 비교하면 안됨
				return false;
			}
			return word.equals(obj);//형변환할수 있는애들은 이퀄스로 비교해서 
		}
			
		Word other = (Word) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}


	//setMean에대한 메소드
	public void setMean(String mean2) {
		this.mean = mean;
		
	}
	
}
