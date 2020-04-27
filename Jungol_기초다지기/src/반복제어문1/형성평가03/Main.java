package 반복제어문1.형성평가03;

//0 부터 100 까지의 점수를 계속 입력받다가 범위를 벗어나는 수가 입력되면 그 이전까지 입력된 자료의 합계와 평균을 출력하는 프로그램을 작성하시오.
//(평균은 반올림하여 소수 첫째자리까지 출력한다.)
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		int count = 0;
		int sum = 0;
		
		while (true) {
			a = sc.nextInt();
			if (a >= 0 && a <= 100) {
				sum = a + sum;
				count++;
			}else {
				break;
			}

		}
		System.out.println("sum : "+sum);
		System.out.printf("avg : %.1f",(double)sum/count);
	}

}
