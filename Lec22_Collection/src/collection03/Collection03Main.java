package collection03;

import java.util.ArrayList;
import java.util.Scanner;

public class Collection03Main {

	public static void main(String[] args) {
		// TODO:
		// Student 타입을 담는 ArrayList를 만드고
		// 사용자로부터 3개의 Student 데이터 을 입력받아서 (id,name,kor,eng,math)
		// 3가지 방법으로 출력해보세요.
		// for, Enhanced-for, Iterator
		ArrayList<Student> list = new ArrayList<Student>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("국어입력");
		int kor = sc.nextInt();
		System.out.println("영어입력");
		int eng = sc.nextInt();
		System.out.println("수학입력");
		int math = sc.nextInt();
		System.out.println("id 입력");
		int id = sc.nextInt();
		System.out.println("name 입력");
		String name = sc.next();
		
		Student list2 = new Student(kor,name,id,eng,math);
		list.add(list2);
		
		for(Student e: list) {
			System.out.println(e.toString());
		}
		
	}

}
