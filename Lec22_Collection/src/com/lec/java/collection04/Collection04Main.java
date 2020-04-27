package com.lec.java.collection04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Collection04Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");

		// TODO
		// MemberModel 타입을 담는 ArrayList를 만드고
		// 사용자로부터 3개의 Student 데이터 을 입력받아서
		// (id, passwd)
		// 3가지 방법으로 출력해보세요.
		// for, Enhanced-for, Iterator
		
		ArrayList<MemberModel> student =new ArrayList<MemberModel>();
		Scanner sc= new Scanner(System.in);
		
		for(int i=0; i<2; i++) {
			System.out.println("id: ");
			String id= sc.nextLine();
			System.out.println("pw: ");
			String pw= sc.nextLine();
			
			
			MemberModel mb = new MemberModel(id,pw);
			mb.displayInfo();
			student.add(mb);
			
		}
		Iterator<MemberModel>itr =student.iterator();
		while(itr.hasNext()) {
			itr.next().displayInfo();
		}
		//for(int i=0; i<student.size(); i++) {
		//	student.get(i).displayInfo();
		//} for
		
		//for(MemberModel e: student) {
		//	e.displayInfo();
		//	} enhanced for 
		System.out.println("\n프로그램 종료");
		sc.close();
	} // end main()

} // end class
