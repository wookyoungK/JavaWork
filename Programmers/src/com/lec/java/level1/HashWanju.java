package com.lec.java.level1;

// 효율성 생각하기!
// 답은나오지만 효율성이 0점임 
//6.25일까지 완료하기
import java.util.HashMap;
import java.util.Map;

public class HashWanju {

	public static void main(String[] args) {
		String[] participant = { "marina", "josipa", "nikola", "vinko", "filipa" };
		String[] completion = { "josipa", "filipa", "marina", "nikola" };
		String answer = "";
		Map<String, Integer> hm = new HashMap<>();

		for (String part : participant) {
			if (hm.get(part) == null) {
				hm.put(part, 1);
			} else {
				hm.put(part, hm.get(part) + 1);
			}
		}

		for (String comp : completion) {
			hm.put(comp, hm.get(comp) - 1);
		}

		for (String key : hm.keySet()) {
			if (hm.get(key) == 1)
				answer = key;
		}

		System.out.println(answer);
	}

}
