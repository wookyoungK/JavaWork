package codeUp;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a;
		a = sc.next();

		String[] b = a.split("\\.");
		int A = Integer.valueOf(b[0]);
		int B = Integer.valueOf(b[1]);
		int C = Integer.valueOf(b[2]);
		System.out.printf("%04d.%02d.%02d", A, B, C);

	}

}
