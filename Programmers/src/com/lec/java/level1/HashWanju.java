package com.lec.java.level1;

import java.util.Iterator;
import java.util.LinkedList;

public class HashWanju {

	public static void main(String[] args) {
		String [] participant = {"leo", "kiki", "eden"};
		String [] completion = {"eden", "kiki"};
		String answer="";
		
		LinkedList<String> list =new LinkedList<String>();
		for(int i =0; i<participant.length; i++) {
			list.add(participant[i]);
		}
		
		for(int i =0; i<participant.length; i++) {
			for(int j=0; j<completion.length; j++) {
				if(participant[i]==completion[j]) {
					list.remove(participant[i]);
				}
				
			}
		}
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()) {
			answer=itr.next();
		}
		
		System.out.println(answer);
	}

}
