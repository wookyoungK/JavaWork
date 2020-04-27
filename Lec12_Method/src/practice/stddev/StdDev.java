package practice.stddev;

import java.util.Scanner;

public class StdDev {

	public static void main(String[] args) {

		// TODO
		// 임의정수 5개로 초기화한 정수로
		// 평균, 분산, 표준편차 구하기
		Scanner sc = new Scanner(System.in);
		int[] score = new int[5];

		for (int i = 0; i < score.length; i++) {
			score[i] = (int) (Math.random() * 100 + 1);
		}
		for (int i = 0; i < score.length; i++) {
			System.out.print((int) score[i] + " ");
		}

		System.out.println("\n평균:" + calcAvg(score));
		System.out.printf("분산:%.1f\n", calcVariance(score));
		System.out.printf("표준편차:%.1f\n", +calcStdDev(score));

	} // end main

	/**
	 * 메소드 이름 : calcAvg 매개변수 : int [] 리턴값 : double
	 * 
	 * 주어진 배열의 '평균값' 리턴
	 */
	public static double calcAvg(int[] score) {

		double Avg = 0;

		for (int i = 0; i < score.length; i++) {
			Avg = Avg + score[i];
		}

		return Avg / 5;  // 숫자로하지말고 length로 하기 !! 틀린문장
	}

	/**
	 * 메소드 이름 : calcVariance 매개변수 : int [] 리턴값 : double
	 * 
	 * 주어진 배열의 '분산값' 리턴
	 */
	public static double calcVariance(int[] score) {

		double result = 0;
		for (int i = 0; i < score.length; i++) {

			result = Math.pow(calcAvg(score) - score[i], 2) + result;
		}
		return result/5;  // 숫자로하지말고 length로 하기!!!! 틀린문장
	}	

	/**
	 * 메소드 이름 : calcStdDev 매개변수 : int [] 리턴값 : double
	 * 
	 * 주어진 배열의 '표준편차' 리턴
	 */
	public static double calcStdDev(int[] score) {
		double result = 0;

		result = Math.sqrt(calcVariance(score));

		return result;
	}

} // end class
