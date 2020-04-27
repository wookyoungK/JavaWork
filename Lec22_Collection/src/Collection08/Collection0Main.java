package Collection08;

import java.util.HashSet;
import java.util.Iterator;

public class Collection0Main {
	public static void main(String[] args) {
		// MyClass 타입을 저장할 수 있는 HashSet 인스턴스 생성
				// 데이터 3개 이상 저장해보고 iterator, enhanced-for 등을 
				// 사용하여 출력해보기
		HashSet<MyClass> list = new HashSet<MyClass>();
		
		list.add(new MyClass(1,"abe"));
		list.add(new MyClass(2,"Abe"));
		list.add(new MyClass(3,"aBe"));
		list.add(new MyClass(1,"abe"));
		System.out.println(list.size());//저장완료
		
		System.out.println();
		Iterator<MyClass> itr =list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());//주소값출력
		}
	}
}
