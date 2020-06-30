package com.lec.java.level1;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		int[] answer = {1,3,3,2,3,1 };
		int[] answers = {};
		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] c = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int[] cnt = { 0, 0, 0 };
		
		
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
		for(int i=0; i<cnt.length; i++) {
			System.out.println("cnt 크기 "+cnt[i]);
		}
		ArrayList<Integer> set = new ArrayList<Integer>();
		
		for (int i = 0; i < cnt.length; i++) {
			int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
			
			if (max > 0) {
				if (max == cnt[0]) {
					set.add(1);
					cnt[0] = 0;
				}
				if (max == cnt[1]) {
					set.add(2);
					cnt[1] = 0;
				}
				if (max == cnt[2]) {
					set.add(3);
					cnt[2] = 0;
				}
			}
				
		}
		answers= new int[set.size()]; 
		System.out.println("set크기: "+set.size());

			for(int i=0; i <set.size(); i++) {
				answers[i]=set.get(i);
			}
			
			for(int i=0; i <answers.length; i++) {
				System.out.println(answers[i]);
			}
			
		
		
		
	}

}
