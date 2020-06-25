package com.lec.java.level1;
// 효율성 생각하기!
// 답은나오지만 효율성이 0점임 
//6.25일까지 완료하기
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashWanju {

	public static void main(String[] args) {
		String[] participant = { "ab", "bb", "bb", "cb" };
		String[] completion = { "bb", "bb", "cb" };
		String answer = "";

		HashMap<Integer, String> list = new HashMap<Integer, String>();

		for (int i = 0; i < participant.length; i++) {
			list.put(i, participant[i]);
		}

		for (int j = 0; j < completion.length; j++) {
			for (int i = 0; i < participant.length; i++) {
				if (participant[i].equals(completion[j])) {
					list.remove(i);
					participant[i]="0";
					break;
				}
			}
		}

		Set<Integer> keySet = list.keySet();
		Iterator<Integer> itr = keySet.iterator();
		while (itr.hasNext()) {
			Integer key = itr.next();
			answer = list.get(key);
		}
		System.out.println(answer);

	}

}
