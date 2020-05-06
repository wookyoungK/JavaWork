package com.lec.java.level2;

public class Figure124 {

	public static void main(String[] args) {

	}

}

class Solution {
	public String solution(int n) {
		String answer = "";
		int a;
		if (n / 3 > 1) {
			
			 a = (int) n / 3;

			for (int i = 0; i <= a; i++) {

				if (n % 3 == 1) {
					answer = "1" + answer;
					n = n - (3 * i);
				}
				if (n % 3 == 2) {
					answer = "2" + answer;
					n = n - (3 * i);
				}
				if (n % 3 == 0 && n - (i * 3) != 0) {
					answer = "4" + answer;
					n = n - (3 * i);
				} else {
					break;
				}

			}

		}

		return answer;
	}
}