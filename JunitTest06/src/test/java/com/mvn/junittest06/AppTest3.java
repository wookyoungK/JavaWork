package com.mvn.junittest06;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class AppTest3 {
	


	private App app = new App();

		 String expected;
		 String valueOne;
		
		@Parameters
		public static Collection<String[]> getTestParameters(){
			return Arrays.asList(new String[][] {
				{"01011111111","010-1111-1111"},
				{"01022222222","010-2222-2222"},
				{"01033333333","010-3333-3333"}
				
				
			});
		}
	
		public AppTest3(String expected, String valueOne) {
			this.expected = expected;
			this.valueOne = valueOne;
		}
	
		@Test
		public void test() {
			assertEquals(expected, app.toNumber(valueOne));
			//System.out.println("테스트 통과: "+expected + ", "+valueOne);
			System.out.println(app.toNumber(valueOne));
		}	
		
		

	}


