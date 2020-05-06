package com.lec.java.level1;

import java.util.Arrays;

public class Sort {
	//k번째수
	public static void main(String[] args) {

	}// end main

}// end class

class Solution {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer =  new int [commands.length];
		
        for (int i = 0; i < commands.length; i++) {
            int[] arr = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            
            Arrays.sort(arr);
            answer[i] = arr[commands[i][2]-1];
        }

		return answer;

	} 
}