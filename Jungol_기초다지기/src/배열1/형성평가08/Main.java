package 배열1.형성평가08;

//1 2 3 4 5 6 7 8 9 10 100
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		double i = 0;
		double sum = 0;
		double avg;

		while (true) {

			int a = sc.nextInt();

			if (a == 0)
				break;
			if (a % 5 == 0) {
				sum += a;
				i++;
			}
		}
		avg = (Double)(sum / i);
		System.out.println("Multiples of 5 : " + (int)i);
		System.out.println("sum : " + (int)sum);
		System.out.format("avg : %.1f", avg);

	}// end main

}// end class
