package 반복제어문2.자가진단07;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		
		for( int i =0; i<=a; i++) {
			
			for( int j=1; j<=b; j++) {
				System.out.print((i+i*j)+ " ");
			}
			System.out.println();
		}

	}

}
