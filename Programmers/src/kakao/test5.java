package kakao;

import java.util.Scanner;
 //이거잘모르겠음 !!
public class test5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(soluction(n));

	}// end main

	public static int soluction(int n) {
		int answer = 0;
		int d = 1;
		int a = 2;
		int b = 3;
		int c = 0;
		int i;
		if (n <= 3) {
			answer = n;
			return answer;
		}

		if (n > 3) {
			for (i = 4; i <=n; i++) {
				c = a + b;
				a = b;
				b = c;
			}
			answer = c;
		}

		return answer;
	}// end method

}// end class
