package 반복제어문2.형성평가08;

import java.util.Scanner;

//행과 열의 수를 입력받아 다음과 같이 출력하는 프로그램을 작성하시오.
public class Main {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();

		for(int i=1; i<=a; i++) {
			for(int j=0; j<b; j++) {
				System.out.print((i+j*i)+ " ");
			}
			System.out.println();
		}

	}

}