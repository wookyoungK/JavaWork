package 출력.자가진단01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("yard? ");
		double num1 =sc.nextDouble();
		System.out.printf("%.1fyard = %.1fcm",num1,num1*91.44);


	}

}
