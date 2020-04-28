package 배열1.형성평가01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String list[]= new String[10];
		int i ;
		int j ;
		for(i=0; i<list.length; i++) {
			list[i]=sc.next();
		}
		for(j=i-1; j>=0; j--) {
		System.out.print(list[j]+" ");
		}
		System.out.println(i);
		
	}//혹시몰라성~
}//연습
