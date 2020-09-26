package six;

//재귀호출
//1부터 10까지의합 
// 가장작은단위로 나누기 
public class Recursive6_2 {

	public static void main(String[] args) {
		MySum1 mysum1 = new MySum1();
		System.out.println(mysum1.sum(10));
		
		Mysum2 mysum2 =new Mysum2();
		System.out.println(mysum2.sum(10));
		
	} // end main
}// end class


class MySum1{
	int sum(int n) {
		if(n<2)
			return n;
		return n+ sum(n-1);
	}
	
}// 재귀함수호출

class Mysum2{
	int result =0;
	int sum(int n) {
		for(int i=1; i<=10; i++) {
			result+=i;
		}
		return result;
		
	}
} // 일반적인 반복문호출
