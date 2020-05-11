package com.lec.java.level2;

public class Printer {

	public static void main(String[] args) {
		int[] priorities = { 1, 1, 9, 1, 2, 1 };
		int location = 0;
		int j=0;

		int answer = 1;
		while (true) {
			for ( j = 0; j < priorities.length; j++) {
				int maxnum = 0;
				for (int i = 0; i < priorities.length; i++) {
					if (priorities[i] > maxnum)
						maxnum = priorities[i];
				}
				if (priorities[j] == maxnum) {
					priorities[j] = 0;
					if (j == location)
						System.out.println(j);
					else
						j++;
				}
			}
		
		}
	}
}
