package 배열1.형성평가09;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] list = new int[100];
		int[] list2 = new int[100];
		int i;
		int j;

		for (i = 0; i < list.length; i++) {
			list[i] = sc.nextInt();
			if (list[i] == 0)
				break;
		}

		j = i;

		for (i = 0; i < j; i++) {
			if (list[i] % 2 == 0) {
				list[i] = list[i] / 2;

			} else {
				list[i] = list[i] * 2;
			}
		}

		System.out.println(j);
		for (i = 0; i < j; i++) {
			System.out.print(list[i] + " ");
		}

	}// end main

}// end class