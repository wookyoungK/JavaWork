package 함수1.형성평가04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int a = sc.nextInt();
		int b= sc.nextInt();
		if(a>=0 && b>=0) {
		System.out.println(say(a,
				b));
		}
	}
	public static int say(int x, int y) {	
		int result=0;
		if(x>y) {
				result=(x*x)-(y*y);
				
			}else {
				result=(y*y)-(x*x);
			}
		
		return result;
		
	}

}
