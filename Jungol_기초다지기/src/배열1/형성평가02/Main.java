package 배열1.형성평가02;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	int list[]=new int[5];
	int i;
	int j;
	int sum=0;
	for(i=0; i<list.length; i++) {
		list[i]=sc.nextInt();
		}
	for(j=0; j<i; j++) {
		if(j%2==0) sum = sum + list[j];		
	}
	System.out.println(sum);
	}
}

