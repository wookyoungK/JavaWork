package com.lec.java.level2;
//DFS-BFS
public class targetNumber {

	public static void main(String[] args) {

		int[] num = {4,1,2,3,4};
		int target = 2;
		int n=0;
		int sum=0;
		int chance=0;
		int subN=0;
		
	for(int i =0; i<num.length; i++) {
		if(n<num.length) {
			num[i]=(-num[i]);
//			if(subN<)
			
			for(int j=0; j<num.length; j++) {
				sum= num[j] +sum;
			}if(sum==target) {
				chance++;
				n++;
			}
			
		}
	}
	
	System.out.println(chance);
		
		
		
	
	
	
	
	
	
	
	
	
	}//end main

}//end class
