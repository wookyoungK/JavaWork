package 배열1.형성평가03;

	import java.util.Scanner;
	
	public class Main {
	
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int list[]= new int[10];
			int i ;
			int j ;
			int add = 0,odd=0;
			for(i=0; i<list.length; i++) {
				list[i]=sc.nextInt();
			}
			for(j=0; j<i; j++) {
				if(j%2==0) {
					add= add+list[j];
				}else {
					odd = odd+list[j];
				}
			}
			System.out.println(add);
			System.out.println(odd);
		}//혹시몰라성~
	}//연습
