package com.lec.java.collection10;

import java.util.Iterator;
import java.util.TreeSet;

public class Collection10Main {

	public static void main(String[] args) {
		System.out.println("TreeSet 연습");
		
		// String 타입을 저장할 수 있는 TreeSet 인스턴스 생성
		// 5개 이상의 데이터를 저장해보고
		// 오름차순, 내림차순으로 출력해보기
		TreeSet<String> test=new TreeSet<String>();
		
		test.add("aa");
		test.add("bb");
		test.add("cc");
		test.add("dd");
		test.add("ee");
		test.add("ff");
		test.add("gg");
		
		
		System.out.println("오름차순");
		Iterator<String> set=test.iterator();
		while(set.hasNext()) {
			System.out.println(set.next());
		}
		
		System.out.println();
		System.out.println("내림차순");
		
		Iterator<String> set1=test.descendingIterator();
		while(set1.hasNext()) {
			System.out.println(set1.next());
		}
		
		System.out.println("\n프로그램 종료");
	} // end main

} // end class

















