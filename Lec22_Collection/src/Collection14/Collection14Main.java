package Collection14;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class Collection14Main {

	public static void main(String[] args) {
		List<St> list = new LinkedList<St>();

		list.add(new St("asdcasc", 1));
		list.add(new St("Ssds", 4));
		list.add(new St("bdsc", 2));
		list.add(new St("dascd", 5));
		System.out.println("Comparable 구현, sort() 적용");
		System.out.println(list); // Student 에 Comparable<> 구현 안되어 있으면 에러!
		Collections.sort(list);
		// Comparagle<> 구현후실행
		System.out.println(list);

		System.out.println("Comparator<> 적용");
		Collections.sort(list, new Asc()); // '이름'내림차순
		System.out.println(list);

//		Collections.sort(list, new Desc());
//		System.out.println(list);

	}// end main

}// end class

class St implements Comparable<St> {
	String name;
	int Score;

	public St() {
	}

	public St(String name, int score) {
		super();
		this.name = name;
		Score = score;
	}

	@Override
	public String toString() {

		return this.name + ":" + this.Score + "점";
	}

	@Override
	public int compareTo(St o) {
		if (o.Score < this.Score)
			return -1; // 내가 더 작으면 음수
		if (this.Score < o.Score)
			return 1; // 내가 더 크면 양수
		return 0;
	}
}

	class Asc implements Comparator<St> {

		@Override
		public int compare(St o1, St o2) {

			return o1.name.compareTo(o2.name);
		}
	}


//class Student implements Comparable<Student> {
//	int score;
//	String name;
//	
//	public Student() {}
//
//	public Student(String name, int score) {
//		super();
//		this.score = score;
//		this.name = name;
//	}
//	@Override
//	public String toString() {
//
//		return this.name + ":" +this.score;
//	}
//
//	@Override
//	public int compareTo(Student o) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	
//}
