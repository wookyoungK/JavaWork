package com.lec.java.level2;

import java.util.Scanner;

public class Jusik {

	public static void main(String[] args) {
		int[] list = { 1, 3, 3, 2, 3 };

		System.out.println(solution(list));

	}// end main

	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		for (int i = 0; i < answer.length; i++) {
			int low = 0;
			if (i == answer.length - 1) {
				answer[i] = 0;
				break;
				
			}
			for (int j = i+1; j < answer.length; j++) {
				if (prices[i] <= prices[j]) {
					low++;
				} else {
					low++;
					break;
				}

			}
			answer[i] = low;
		}

		return answer;
	}
}// end class
