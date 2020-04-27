 package com.lec.java.collection14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


/* java.util.Collections 클래스
	 Collections 클래스는 여러 유용한 알고리즘을 구현한 메소드들을 제공
	 대부분 클래스메소드 (static) 형태로 제공됨
	 
	 정렬(sort)
	 섞기(shuffle)
	 탐색(search)
 */

public class Collection14Main {

	public static void main(String[] args) throws ParseException {
		System.out.println("Collections 메소드");

		List<String> list1 =new LinkedList<String>(); //앞에 이름이 서로다르지만 족보를 보면 포함관계이기때문에 가능하다
		
		list1.add("장수영");
		list1.add("김진영");
		list1.add("이수영");
		list1.add("짱수영");
		
		System.out.println(list1);
		System.out.println("sort()");
		// sort()
		// 기본적으로 속도가 비교적 빠르고 안전성이 보장되는 Merge Sort 사용
		Collections.sort(list1);
		System.out.println(list1); //정렬후 결과
		
		List<Date> list2 = new LinkedList<Date>();
		//"2018-08-16" --> Date객체
		new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-16"); //Date 객체 , parse --> throws parseException 해야함
		list2.add(new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-16"));
		list2.add(new SimpleDateFormat("yyyy-MM-dd").parse("2017-03-11"));
		list2.add(new SimpleDateFormat("yyyy-MM-dd").parse("2012-02-23")); //list2 에는 Date 객체가 3개들어가있다 .!!!
		System.out.println(list2);
		Collections.sort(list2); //Collections의 함수 .sort 
		System.out.println(list2);
		
		
		// String 타입이면 알파벳 순으로 정렬된다.
		// Date 타입이면 날짜순으로 정렬된다
		// ★ String 과 Date 는 기본적으로 Comparable<T> 인터페이스가 구현되었기 때문.
		// ※ String 온라인 도움말 확인해보자
	
		System.out.println();
		List<Student> list3 =new LinkedList<Student>(); //무엇이 높고낮은지 기준이 선언되어있어야한다 위에 Date , String은되어있다 
		list3.add(new Student("Susie", 50));
		list3.add(new Student("James", 80));
		list3.add(new Student("Kevin", 70));
		System.out.println("Comparable 구현, sort() 적용");
		System.out.println(list3); //Student 에 Comparable<> 구현 안되어 있으면 에러!
		Collections.sort(list3);
		//Comparagle<> 구현후실행
		System.out.println(list3);
		
		// TODO
		
		// 역순 정렬
		System.out.println("reverseOrder() 적용");
		System.out.println("reverseOrder()");
		Collections.sort(list3, Collections.reverseOrder()); //return type  comparator 내가 정의해준 comparable 과는다르다
		System.out.println(list3);
		
		System.out.println("reverse() 적용");
		Collections.reverse(list3);
		System.out.println(list3);
		
		
		// Comparator<> 적용
		// Collections.sort 메소드는 두 번째 인자로 Comparator 인터페이스를 받을 수 있도록 해놓았습니다.
		// Comparator 인터페이스의 compare 메소드를 오버라이드 하면 됩니다.
		System.out.println();
		System.out.println("Comparator<> 적용");
		Collections.sort(list3, new Asc()); //'이름'내림차순
		System.out.println(list3);
		
		Collections.sort(list3, new Desc());
		System.out.println(list3);
		// Collections 에서 많이 쓰이는 인터페이스임
		// Comparable 은 클래스 자체에 구현하는 인터페이스  compareTo(자기사진 vs 매개변수)
		// Comparator 는 두개의 객체 비교하는 기능제공 인터페이스  compare(매개변수1 vs 매개변수2)
		//      구현된 객체가 매개변수 등에 넘겨지는 형태로 많이 쓰임
		
		// Shuffling 하기 (섞기)
		System.out.println();
		System.out.println("shuffle()");
		Collections.shuffle(list1);
		System.out.println(list1);
		Collections.shuffle(list1);
		System.out.println(list1);

		String [] arr = {"aaa","bbb","ccc","ddd","eee","fff","ggg"};
		List<String> arrList =Arrays.asList(arr); //배열 -->List
		Collections.shuffle(arrList);
		arrList =arrList.subList(0, 3); //index 0부터 3전까지의 List<>생성
		System.out.println(arrList);
		
		// min(), max()
		// Comparable 메소드 영향 받음
		System.out.println();
		System.out.println("min(), max()");
		System.out.println(Collections.min(list1));
		System.out.println(Collections.max(list1));
		System.out.println(Collections.min(list3)); // 마지막에 내림차수능로 되어있어서 max,min도 comparable 이 되어있어야 동작한다!!!!	
		System.out.println(Collections.max(list3));
		// TODO
		
		// copy()
		System.out.println();
		List<Student> list4 = new LinkedList<Student>();
		list4.add(new Student("aaa", 10));
		list4.add(new Student("bbb", 10));
		list4.add(new Student("ccc", 10));
		
		System.out.println("카피전");
		System.out.println(list4);
		System.out.println("카피후");

		Collections.copy(list4, list3);// 뒤에것이 앞으로카피
		System.out.println(list4);
		System.out.println("\n프로그램 종료");
	} // end main

} // end class

// 우선은 Comparable 구현 없이 해보자
class Student implements Comparable<Student>{ //3.27 과제 기초
	
	String name;
	double point;
	
	public Student(String name, double point) {
		super();
		this.name = name;
		this.point = point;
	}
	
	@Override
	public String toString() {
		return this.name + ":" + this.point + "점";
	}
	
	
	// compareTo() 메소드는 매개변수 객체를 '자신' 과 비교하여
	//작으면 음수, 같으면0, 크면 양수를 리턴한다.
	//3.27 과제 기초
	@Override
	public int compareTo(Student o) {
		
		// 점수 오름차순
//		if(o.point > this.point) return -1;  // 내가 더 작으면 음수
//		if(this.point > o.point) return 1;   // 내가 더 크면 양수
//		return 0;  // 같으면 0
		
		// 점수 내림차순
		if(o.point < this.point) return -1;  // 내가 더 작으면 음수
		if(this.point < o.point) return 1;   // 내가 더 크면 양수
		return 0;  // 같으면 0		
		
	}

} // end class

//Student 를 이름(name) 오름차순  정렬해줄수 있는 Comparator<> 제공
class Asc implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {//o1. 작으면 - o2가크면 +
		// 이름
		return o1.name.compareTo(o2.name);
	}

} // end Asc

//Student 를 이름(name) 내림차순  정렬해줄수 있는 Comparator<> 제공
class Desc implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// 이름
		return o2.name.compareTo(o1.name);
	}

} // end Asc



