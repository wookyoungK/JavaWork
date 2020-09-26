package six;

public class test {

	public static void main(String[] args) {

		int[][] flowers = { { 2, 5 }, { 3, 7 }, { 10, 11 } };
		int answer = 0;
		int i = 0;

		for (i = 0; i < flowers.length; i++) {
			if (i != flowers.length - 1) {
				if (flowers[i][1] > flowers[i + 1][0]) {
					answer += flowers[i + 1][1] - flowers[i][0];
					i=i+1;
				} else {
					answer += flowers[i][1] - flowers[i][0];
				}
			} else {
				answer += flowers[i][1] - flowers[i][0];
			}

		}

		System.out.println();
	}// end main

}// end class