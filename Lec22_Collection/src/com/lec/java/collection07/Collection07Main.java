package com.lec.java.collection07;

import java.util.HashSet;
import java.util.Iterator;

public class Collection07Main {

	public static void main(String[] args) {
		System.out.println("HashSet 연습");
		
		// TODO
		// String 타입을 저장할 수 있는 HashSet 를 생성하고
		// 5개 이상의 데이터는 저장, 수정, 삭제 등의 동작을 해보고,
		// iterator, enhanced-for 문을 사용해서 출력해보기
		
		HashSet<String> hash=new HashSet<String>();
		hash.add("aa");
		hash.add("bb");
		hash.add("cc");
		hash.add("dd");
		hash.add("ee");
		hash.add("ff");
		hash.add("gg");
		
		System.out.println();
		Iterator<String> itr = hash.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next()+" ");
		}
		
		System.out.println();
		for(String e :  hash) {
			System.out.print(e+" ");
		}
		
		hash.remove("aa");
		hash.add("22");
		System.out.println();
		itr = hash.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next()+" ");
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
















