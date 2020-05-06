package 함수1.자가진단02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a =sc.nextInt();
		System.out.println(say(a));
	}
	public static int say(int x) {
		int j;
		int result = 0;
		for(j=0; j<=x; j++) {
			result +=j;
		}
		return result;
	}
}
