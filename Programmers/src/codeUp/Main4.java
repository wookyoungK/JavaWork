package codeUp;

import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        String num = sc.nextLine();
        
        String [] arr = num.split(" ");
                
        int total[] = new int[23];
        for(int i=0; i<arr.length; i++) {
            total[Integer.parseInt(arr[i])-1] +=1;
        }
        
        for(int i=0; i<total.length; i++) {
            System.out.print(total[i]+" ");
        }
    }   
}  