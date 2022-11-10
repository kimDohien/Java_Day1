package day14;

import java.util.ArrayList;

public class ListEx03 {

	public static void main(String[] args) {
		/*클래스에 equals를 오버라이징 하지 않으면 contains와 indexOf처럼
		 * 같은 객체인지를 제대로 판별하지 못해서 원하는 결과를 얻을수 없다.
		 */
		ArrayList<Word> list =new ArrayList<Word>() ;
		list.add(new Word("time", "시간"));
		list.add(new Word("apple","사과"));
		System.out.println(list);
		System.out.println(list.contains(new Word("apple","사과")));
		//애플,사과가 있냐고 물었는데 답은 없다고 나온다. 그래서 equals로 오버라이징을 해야 값이 나온다.
	}

}
class Word{
	private String word;
	private String mean;
	
	//생성자
	public Word(String word, String mean) {
		super();
		this.word = word;
		this.mean = mean;
	}
	
	//String오버라이징
	public String toString() {
		return word + " : " + mean;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mean == null) ? 0 : mean.hashCode());
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (mean == null) {
			if (other.mean != null)
				return false;
		} else if (!mean.equals(other.mean))
			return false;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}
	
}