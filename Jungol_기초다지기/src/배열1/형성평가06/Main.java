package 배열1.형성평가06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] list = new int[100];
		int i;
		int num = sc.nextInt();

		if (num != 999) {
			
			int max = num;
			int min = num;

			for (i = 0; i < list.length; i++) {
				if (max < 999 && min > -999) {

					int a = sc.nextInt();

					if (a == 999)
						break;
					if (a > max)
						max = a;
					if (a < min)
						min = a;

				}
			}
			System.out.println("max : "+max);
			System.out.println("min : "+min);
		}else {
			System.out.println("다시입력하세요 ");
		}

	}// end main

}// end class
