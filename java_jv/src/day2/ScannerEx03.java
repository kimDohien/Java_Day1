package day2;

import java.util.Scanner;

public class ScannerEx03 {

	public static void main(String[] args) {
	
			Scanner scan= new Scanner(System.in);

			System.out.println("Typing one word : ");
			String str2 = scan.next();
			System.out.println(str2);
			
			scan.nextLine();
			
			System.out.println("Typing one sentence : ");
			String str1 = scan.nextLine();
			System.out.println(str1);
			
			scan.close();
		}

	}


