package 함수2.형성평가03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int a;
		int sum=0;
		for(int i=0; i<5; i++) {
			a= sc.nextInt();
			sum = Math.abs(a)+sum;
		}
		
		System.out.println(sum);
	}
	

}
