package 함수1.형성평가05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum1 =0;
		int sum2 =0;
		int sum3 =0;
		for (int i = 0; i < 3; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			say(a,b,c);
			 sum1 =a+sum1;
			 sum2 =b+sum2;
			 sum3 =c+sum3;
		}
		System.out.printf("%d %d %d %d",sum1,sum2,sum3,sum1+sum2+sum3);
	}

	public static int say(int x, int y, int z) {
		int result;
		int sum = 0;
		sum = x + y + z;
		
		System.out.println(x + " " + y + " " + z + " " + sum);

		return 0;
	}

}
