package 선택제어문.자가진단08;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double a = sc.nextDouble();
		double grade = a;
		if (grade >= 4.0) {
			a = 4;
		} else if (grade >= 3.0) {
			a = 3;
		} else if (grade >= 2.0) {
			a = 2;
		} else {
			System.out.println("retake");
		}

		switch ((int) a) {
		case 4:
			System.out.println("scholarship");
			break;
		case 3:
			System.out.println("next semester");
			break;
		case 2:
			System.out.println("seasonal semester");
			break;

		}
	}

}
