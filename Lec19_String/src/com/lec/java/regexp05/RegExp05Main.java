package com.lec.java.regexp05;
//구글링~ ;~ ;~ ;~ ;~
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 대표적인 정규 표현식 
 *  구글링 하면 대표적인 정규표현식들이 많이 구할수 있습니다.
 *  각 정규표현식들을 작성해보고
 *	매칭되는 문자열과 그렇지 않은 것들을 출력해봅시다.   
 */
public class RegExp05Main {

	public static void main(String[] args) {
		System.out.println("많이 쓰는 정규표현식");

		String regex, intput, title;
		String [] arrInput;
		
		//─────────────────────────────────────────
		title = "URL";
		regex = "^(https?):\\/\\/([^:\\/\\s]+)(:([^\\/]*))?((\\/[^\\s/\\/]+)*)?\\/?([^#\\s\\?]*)(\\?([^#\\s]*))?(#(\\w*))?$";; // TODO
		arrInput = new String[] {
				"http://www.daum.net",
				"http://www.naver.com"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);


		//─────────────────────────────────────────
		title = "email";
		regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-z]{2,6}$"; // TODO
		arrInput = new String[] {
			"pd11256@naver.com",
			"dnrud11256@naver.com"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);
	
		//─────────────────────────────────────────
		title = "주민등록번호";
		regex = "\\b(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))-[1-4][0-9]{6}\\b"; // TODO
		arrInput = new String[] {
			"921125-1211313",
			"931320-1135412"
			
		};
		System.out.println(title);
		regExpTest(regex, arrInput);
		
		//─────────────────────────────────────────
		title = "날짜 YYYY-MM-DD";
		regex =  "^([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))$"; // TODO
		arrInput = new String[] {
			"2020-03-23",
			"2020-13-24"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);
		
		//─────────────────────────────────────────
		title = "자연수";
		regex = "^[1-9][0-9]*$"; // TODO
		arrInput = new String[] {
			"900",
			"-23"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);
		
		//─────────────────────────────────────────
		title = "정수";
		regex = "^(0|-?[1-9][0-9]*)$"; // TODO
		arrInput = new String[] {
			"130",
			"-23"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);
		

		//─────────────────────────────────────────
		title = "소수";
		regex = "^[0-9]+(.[0-9]+)?$"; // TODO
		arrInput = new String[] {
			"3.41",
			"3"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "소숫점 둘째자리까지";
		regex = "^[0-9]+(.[0-9]{2})?$"; // TODO
		arrInput = new String[] {
			"3.145",
			"3.15"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);
		
		//─────────────────────────────────────────
		title = "통화표시 (￦)";
		regex = "\\p{Sc}"; // TODO
		arrInput = new String[] {
			"￦"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		System.out.println("프로그램 종료");

	} // end main()

	// 도우미 함수
	public static void regExpTest(String regex, String[] arrInput) {
		for (String input : arrInput)
			regExpTest(regex, input);
	}

	public static void regExpTest(String regex, String input) {
		System.out.println("[정규표현식 매칭 테스트]-----------------");
		System.out.println("정규표현식: " + regex);
		System.out.println("입력문자열: " + input);

		if(Pattern.matches(regex, input)) {
			System.out.println("   ●매칭●");
		} else {
			System.out.println("   Ⅹ매칭 없슴Ⅹ");
		}
		
		System.out.println();
	} // end regExpTest()

} // end class
