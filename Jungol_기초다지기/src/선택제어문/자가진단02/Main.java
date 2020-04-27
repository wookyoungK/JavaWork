package 선택제어문.자가진단02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int height = sc.nextInt();
		int weight = sc.nextInt();
		
		int bb = weight + 100 - height;

		if (bb > 0) {
			System.out.println(bb + "\nObesity");
		} else {
			System.out.println(bb);

		}
	}

}
