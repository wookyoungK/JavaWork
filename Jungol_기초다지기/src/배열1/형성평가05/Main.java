package 배열1.형성평가05;

import java.util.Scanner;

/*6개의 문자배열을 만들고 {'J' 'U' 'N' 'G' 'O' 'L'} 으로 초기화 한 후 문자 한 개를 입력받아 배열에서의 위치를 출력하는 프로그램을 작성하시오.
첫 번째 위치는 0번이며 배열에 없는 문자가 입력되면 "none" 라는 메시지를 출력하고 끝내는 프로그램을 작성하시오.
{ "J", "U", "N", "G", "O", "L" };*/
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] list = { 'J', 'U', 'N', 'G', 'O', 'L' };
		int i = 0;

		char a = sc.next().charAt(0);

		while (i < 6) {
			if (a == list[i]) {
				System.out.println(i);
				break;
			} else {
				i++;
			}
		}
		if (i >= 6) {
			System.out.println("none");
		}

	}// end main
}// end class
