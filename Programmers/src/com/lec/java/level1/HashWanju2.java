package com.lec.java.level1;

// 효율성 생각하기!
// 답은나오지만 효율성이 0점임 
//6.25일까지 완료하기
import java.util.HashMap;

public class HashWanju2 {

	public static void main(String[] args) {
		String[] participant = { "marina", "josipa", "nikola", "vinko", "filipa" };
		String[] completion = { "josipa", "filipa", "marina", "nikola" };
		String answer = "";
		int count = 0;
		HashMap<Integer, String> list = new HashMap<Integer, String>();

		for (int i = 0; i < participant.length; i++) {
			for (int j = 0; j < completion.length; j++) {
				if (participant[i].equals(completion[j])) {
					completion[j] = "null";
					break;
				} else {
					count++;
				}
			}
			if (count == completion.length) {
				answer = list.put(1, participant[i]);
				answer = list.get(1);
				break;
			}
			count = 0;
		}
		System.out.println(answer);
	}

}
