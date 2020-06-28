package com.lec.java.level1;


//완전탐색 - 모의고사
public class Mowigosa {

	public static void main(String[] args) {
		int[] answer = { 1,3,2,4,2 };
		int[] answers = {};
		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] c = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int[] cnt = { 0, 0, 0 };
		int max = 0;
		int maxcount = 0;
		
		for (int i = 0; i < answer.length; i++) {
			if (answer[i] == a[i % 5]) {
				cnt[0]++;
			}
			if (answer[i] == b[i % 8]) {
				cnt[1]++;
			}
			if (answer[i] == c[i % 10]) {
				cnt[2]++;
			}
		}
//		for (int i = 0; i < cnt.length; i++) {
//			System.out.println(cnt[i]);
//		}

	}
}
