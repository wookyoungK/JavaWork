package com.lec.java.array06;

import java.util.Scanner;

/* 2차원 배열 의 length
	
 */
public class Array06Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int intArray[] = new int[8]; // 배열의 선언과 생성
	    int max=0;
	    int min=0;
	    
	    for( int i=0 ; i<intArray.length; i++ ) {
	    	intArray[i] = sc.nextInt();
	    	if(intArray[i] > max) {  
		          max = intArray[i];
	    	}
	    	
	    }
		     System.out.println(max); 
		for( int i=0 ; i<intArray.length; i++ ) {
			  	intArray[i] = sc.nextInt();
			    	if(intArray[i] < min) {  
				          min = intArray[i];
			    	}
			    	
			    }
		

	} // end main()

} // end class Array06Main










