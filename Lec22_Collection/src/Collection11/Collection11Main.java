package Collection11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Collection11Main {
	// 도전과제
	// arr[] = {2, 4, 5, 4, 3, 3, 4}
	// 주어진 배열이 위와 같을때 다음과 같이 발생회수 나타내기
	// 2 : 1개
	// 3 : 2개
	// 4 : 3개
	// 5 : 1개

	public static void main(String[] args) {
		System.out.println("HashMap 응용: 배열에서 발생빈도 구하기");
		int arr[] = { 2, 4, 5, 4, 3, 3, 4 };
		HashMap<Integer, Integer> list = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			Integer v = list.get(arr[i]);
			if (v == null) {
				list.put(arr[i], 1);
			} else {
				list.put(arr[i], v + 1);
			}
		}
		Set<Integer> keySet = list.keySet();
		Iterator<Integer> itr = keySet.iterator();
		while (itr.hasNext()) {
			int key = itr.next();

			System.out.println(key + ":" + list.get(key));
		}

		// printFreq(arr);

	}// end main

}// end class
