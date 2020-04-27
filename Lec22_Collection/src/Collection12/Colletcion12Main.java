package Collection12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class Colletcion12Main {

	public static void main(String[] args) {
		TreeMap<Integer,String> list =new TreeMap<Integer,String>();
		
		list.put(1, "aa");
		list.put(2, "bb");
		list.put(3, "cc");
		list.put(4, "dd");
		list.put(5, "ff");
		
		for(String value : list.values()) {
			System.out.println(value);
		}
		
		Set<Integer> keySet =list.keySet();
		Iterator<Integer> map =keySet.iterator();
		while(map.hasNext()) {
			int key=map.next();
			System.out.println(key+ ":" + list.get(key));
		}
		
		System.out.println();
		
		HashMap<Integer,String> hmap = new HashMap<Integer,String>();
		hmap.put(1,"a");
		hmap.put(2,"b");
		hmap.put(3,"c");
		hmap.put(4,"d");
		
		TreeMap<Integer,String> Tmap=new TreeMap<Integer,String>(hmap);
		Set<Integer> keySet2 =Tmap.keySet();
		Iterator<Integer> map2 =keySet2.iterator();
		while(map2.hasNext()) {
			int key=map2.next();
			System.out.println(key+ ":" + Tmap.get(key));
		}
	
		
	}

}
