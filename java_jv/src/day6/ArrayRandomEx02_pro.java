package day6;

public class ArrayRandomEx02_pro {

	public static void main(String[] args) {

		//강사님 코딩법
		
		int min = 1, max = 9;// 랜덤수 범위
		int size = 3;
		int arr[] = new int[size];// 랜덤수를 저장할 배열
		int count = 0;// 저장된 랜덤 수의 개수

		// 배열에 저장된 중복되지 않은 수가 3개가 될때까지 반복해야힘
		while (count < 3) {

			// 랜덤한 수 생성
			int r = (int) (Math.random() * (max - min + 1) + min);

			boolean isDuplicated = false;

			// 배열에 저장된 수 중에서 랜덤한 수와 일치하는 숫자가 있는지 없는지 확인하여
			// 저장된 숫자 개수만큼 반복해야함 =>i는 0번지부터 저장된 개수보다 작을때까지
			for (int i = 0; i < count; i++) {
				// 배열에 저장된 숫자개수만큼 확인
				// i번지에 있는 숫자와 랜덤수가 같은 isDuplicated를 true로
				if (arr[i] == r) {
					isDuplicated = true;
				}
			}
			// 있으면 다시 처음으로,(=isDuplicated가 true이면 )
			if(isDuplicated==true) {
				continue;
			}
			// 없으면(=isDuplicated가 false)
			else {//continue가 있어서 else구문을 지워줘도 됨.
				//arr[count++]=r;
				arr[count]=r;
				count++;
				
			}
			// 배열에 저장하고, 저장된 개수 1 증가
			for(int tmp:arr) {
				System.out.println(tmp + "  ");
			}
		}
	}

}
