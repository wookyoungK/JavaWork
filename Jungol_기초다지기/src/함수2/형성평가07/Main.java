package 함수2.형성평가07;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		double a = 3.141592;
		
		Scanner sc =new Scanner(System.in);
		double b = sc.nextDouble();
		
		System.out.printf("radius : area = %.3f",a*b*b);
	}

}
