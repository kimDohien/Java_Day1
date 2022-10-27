package day4;

public class NestingForStarEx01 {

	public static void main(String[] args) {
		/* *****
		 * *****
		 * *****
		 * *****
		 * *****
		 */
		
		//방법1
		int i ;
		for( i = 1 ; i <=5; i++) {
			System.out.println("*****");
		}
		
		System.out.println("--------");
		
		//방법2
		int col, row;
		for(row = 1; row <=5; row++) {
			System.out.println("*****");
		}
		
		System.out.println("--------");
		
		//방법 3
		for(row = 1; row <=5 ; row++) { //row - 가로
			for(col =1 ; col<=5 ; col++) { //col -세로 
				System.out.print("*");
			}
			System.out.println( );
		}
		
		
	}

}
