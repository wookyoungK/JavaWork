package com.lec.java.level2;

//DFS-BFS
public class targetNumber {

	public int solution(int[] numbers, int target) {
		int[] list = { 1, 1, 1, 1, 1 };
		int answer = 0;
		int idx = 0;
		//for (idx = 0; idx < list.length; idx++) {
			answer = inpsect(idx, list, 0, target, answer, list.length);
		//}
		return answer;
	}
 
	public int inpsect(int idx, int[] list, int point, int tg, int answer, int size) {

		int num1 = point + list[idx];
		int num2 = point + (-1 * list[idx]);
		idx++;

		int result = answer;
		if (idx == size) {
			if (num1 == tg || num2 == tg) {
				result++;
			}
		} else {
			result = inpsect(idx, list, num1, tg, result, size);
			result = inpsect(idx, list, num2, tg, result, size);
		}

		return result;

	}// end main

}// end class







//class Solution {
//    public int solution(int[] numbers, int target) {
//        int answer = 0;
//		int idx = 0;
//		
//		answer = inpsect(idx, numbers, 0, target, answer, numbers.length);
//		
//		return answer;
//	}
//
//	public int inpsect(int idx, int[] numbers, int point, int tg, int answer, int size) {
//
//		int num1 = point + numbers[idx];
//		int num2 = point + (-1 * numbers[idx]);
//		idx++;
//
//		int result = answer;
//		if (idx == size) {
//			if (num1 == tg || num2 == tg) {
//				result++;
//			}
//		} else {
//			result = inpsect(idx, numbers, num1, tg, result, size);
//			result = inpsect(idx, numbers, num2, tg, result, size);
//		}
//
//		return result;
//    }
//}