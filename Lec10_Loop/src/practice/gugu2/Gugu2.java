package practice.gugu2;

public class Gugu2 {

	public static void main(String[] args) {
		for (int i = 2; i <= 9; i += 3) {

			for (int j = 1; j <= 9; j++) {

				for (int k = i; k < i + 3; k++) {
					if (k == 10)
						break;
					System.out.print(k + "*" + j + "=" + j * k + "\t");
				}

				System.out.println("");
			}
			System.out.println();
		} // class
	}
}// main
