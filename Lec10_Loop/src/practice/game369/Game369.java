package practice.game369;

public class Game369 {

	public static void main(String[] args) {
		/*
		 * 나쁜코드 int j; for (j = 1; j <= 100; j++) { if (j % 10 == 0) { if (j / 10 == 3
		 * || j / 10 == 6 || j / 10 == 9) { System.out.print("*\t");
		 * System.out.println(); } else { System.out.print(j + "\t");
		 * System.out.println(); } } else if (j % 10 == 3 || j % 10 == 6 || j % 10 == 9
		 * || j / 10 == 3 || j / 10 == 6 || j / 10 == 9) {
		 * 
		 * System.out.print("*\t"); } else { System.out.print(j + "\t"); }
		 */

		int j;
		for (j = 1; j <= 100; j++) {

			if (j % 10 == 3 || j % 10 == 6 || j % 10 == 9 || j / 10 == 3 || j / 10 == 6 || j / 10 == 9) {
				System.out.print("*\t");
			} else {
				System.out.print(j + "\t");
			}

			if (j % 10 == 0)
				System.out.println();

		}
	}
}
