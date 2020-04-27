package 반복제어문1.자가진단01;

// 1 2 3 4 5 6 7 8 9 10 100
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num =sc.nextInt();
		if(num != 0) {
			int max =num;
			int min =num;
		while (true) {

			int a = sc.nextInt();

			if (a == 0) break;
			if (a > max)max = a;
			if (a < min)min = a;
		}
		System.out.println(max );
		System.out.println(min);

		}
	}
	

}
