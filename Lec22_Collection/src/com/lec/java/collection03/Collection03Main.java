package com.lec.java.collection03;

import java.util.ArrayList;
import java.util.Scanner;

public class Collection03Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		
		//TODO:
		// Student 타입을 담는 ArrayList를 만드고
		// 사용자로부터 3개의 Student 데이터 을 입력받아서 (id,name,kor,eng,math)
		// 3가지 방법으로 출력해보세요. 
		// for, Enhanced-for, Iterator
		ArrayList<Student> student = new ArrayList<Student>();
		
		Scanner sc =new Scanner(System.in);
	
		for(int i=0; i<3; i++) {
			System.out.println("이름:");
			String name  =sc.next();
			System.out.println("국어:");
			int kor  =sc.nextInt();
			System.out.println("영어:");
			int eng  =sc.nextInt();
			System.out.println("수학:");
			int math  =sc.nextInt();
			System.out.println("아이디:");
			int id  =sc.nextInt();
			
			Score score=new Score(kor,eng,math);
			Student list =new Student(id,name,score);
			
			student.add(list);
		}
		for(Student e:student) {
			System.out.print(e);
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class









