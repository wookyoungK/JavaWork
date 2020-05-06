package com.lec.java.level1;

import java.util.Arrays;

public class Sort {
	// k번째수
	public static void main(String[] args) {

	}// end main

}// end class

class Solution {
    public String solution(int n) {
        String answer = "";

        
        while(true){
            if(n==0)
                break;
               
            if(n%3==1){
                n = n/3;
                answer=answer+"1";
  
            }
            else if(n%3 ==2){
                n= n/3;
                answer=answer+"2";
            }
            else if(n%3 ==0){
                n=(n-3)/3;
                answer=answer+"4";
            }
      
        }//end while

        return answer;
    }//end
}//end class