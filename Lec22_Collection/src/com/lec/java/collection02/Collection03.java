package com.lec.java.collection02;

import java.util.ArrayList;
import java.util.Iterator;

public class Collection03 {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		//TODO:
		// String 타입을 담는 ArrayList를 만들고
		// 5개 이상의 String을 저장하고
		// set(), remove() 등의 메소드 사용하여
		// 임의의 것을 수정, 삭제 도 해보시고
		// 3가지 방식으로 출력해보세요
		//  for, Enhanced-for, Iterator	
		ArrayList<String> e =new ArrayList<String>();
		e.add("aa");
		e.add("bb");
		e.add("cc");
		e.add("dd");
		e.add("ff");
		
		for(String o:e) {
			System.out.println(o);
		}
		
		e.set(2, "hh");
		e.remove(3);
		
		for(int i=0; i<e.size(); i++) {
			System.out.println(e.get(i));
		}
		
		
		Iterator<String> itr = e.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}
		
}
