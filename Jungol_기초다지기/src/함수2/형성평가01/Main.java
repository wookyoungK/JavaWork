package 함수2.형성평가01;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		say();

	}
	
	
	
	public static Integer[] say() {
		Scanner sc=new Scanner(System.in);
		int a = sc.nextInt();
		Integer [] list =new Integer[a];
		for(int i=0; i<a; i++) {
			int b= sc.nextInt();
			list[i]=b;
		}
		Arrays.sort(list,Collections.reverseOrder());
		for(int i =0; i<a; i++) {
			
			System.out.println(list[i]);
		}
		return list;
		
	}
	

}
