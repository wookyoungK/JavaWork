//package com.lec.java.level1;
//
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Set;
//
//
//public class HashWanju {
//
//	public static void main(String[] args) {
//		String [] participant = {"leo", "kiki", "eden"};
//		String [] completion = {"eden", "kiki"};
//		String answer="";
//		int a=0;
//		
//		HashMap<Integer, String> list =new HashMap<Integer, String>();
//		
//		for(int i=0; i<participant.length; i++) {
//			list.put(participant.length,participant[i]);
//		}
//
//		for(int i =0; i<participant.length; i++) {
//			for(int j=0; j<completion.length; j++) {
//				if(participant[i].equals(completion[j])) {
//					list.remove(i+1);
//				}
//			}
//		}
//		Set<Integer> keySet =list.keySet();
//		Iterator<String> itr = keySet.iterator();
//		while(itr.hasNext()) {
//			answer=itr.next();
//		}
//		
//		System.out.println(answer);
//	}
//
//}
