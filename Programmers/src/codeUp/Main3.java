package codeUp;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		
		int i =0;
		Scanner sc = new Scanner(System.in);
		String a;
		a = sc.next();
		char [] d=a.toCharArray();
		for(i=0; i<a.length(); i++) {
			System.out.printf("\'%c\'",d[i]);

		}
	}
}
