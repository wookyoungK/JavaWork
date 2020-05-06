package 배열1.형성평가0A;

import java.util.Arrays;
import java.util.Collections;
// 1 2 3 4 5 6 7 8 9 10 100
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int temp = 0;
		int i;
		int j;
		int a = sc.nextInt();

		Integer [] list = new Integer[a]; //이부분을 Integer로 바꿔야 역순정렬가능 , int는 sort만가능

		if (list.length <= 20) {
			for (i = 0; i < list.length; i++) {
				int b = sc.nextInt();
				list[i] = b;
			}

//			for (i = 0; i < list.length; i++) {
//				for (j = i + 1; j < list.length; j++) {
//					if (list[i] < list[j]) {
//
//						temp = list[i];
//						list[i] = list[j];
//						list[j] = temp;
//
//					} 
//				}
//			}
			Arrays.sort(list, Collections.reverseOrder());
			for (i = 0; i < list.length; i++) {
				System.out.println(list[i]);
			}
		}

	}// end main
}// class main