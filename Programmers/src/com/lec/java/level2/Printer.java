package com.lec.java.level2;
public class Printer {
	public static void main(String[] args) {
		
	}


    public int solution(int[] priorities, int location) {
        int answer = 1;
        while(true){
            for(int j = 0; j<priorities.length;j++){
                int maxnum = 0;
                
                
                if(priorities[j]==maxnum){
                    priorities[j]=0; 
                    if(j==location)
                        return answer;
                    else answer++;
                }
            }
        }
    }
    
}
