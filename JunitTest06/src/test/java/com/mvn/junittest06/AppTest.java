package com.mvn.junittest06;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileWriter;

import org.junit.Test;


public class AppTest 


{
	
	private App app =new App();
	// 실습1
    @Test
    public void test1() {
    	int [] one =new int[] {40,2,5,4,1};
    	int [] two =new int[] {40,2,5,4,1};
    	int [] three =new int[] {40,2,5,4,1};
    	int [] four =new int[] {40,2,5,4,1};
    	int [] five =new int[] {40,2,5,4,1};
    	
    	app.sortArr(one);
    	app.sortArr(two);
    	app.sortArr(three);
    	app.sortArr(four);
    	app.sortArr(five);

    	for(int i=1; i<one.length; i++) {
    		if(one[i]<one[i-1]) {
    			fail();
    		}
    	}
    	for(int i=1; i<two.length; i++) {
    		if(two[i]<two[i-1]) {
    			fail();
    		}
    	}
    	for(int i=1; i<four.length; i++) {
    		if(four[i]<four[i-1]) {
    			fail();
    		}
    	}
    	for(int i=1; i<three.length; i++) {
    		if(three[i]<three[i-1]) {
    			fail();
    		}
    	}
    	for(int i=1; i<five.length; i++) {
    		if(five[i]<five[i-1]) {
    			fail();
    		}
    	}
    }
    
//    // 실습2
//    @Test
//    public void test2() {
//    	
//    	
//    	int [] two = {3,1,4};
//    	int max= app.max(two);
//    	int min= app.min(two);
//    	
//    	
//    	for(int i =1; i<two.length; i++) {
//    		if(two[i]>max) fail();
//    		if(two[i]<min) fail();
//    	}
//    	try {
//    		
//    	File file= new File("TEST/report.txt");
//    	FileWriter fw = new FileWriter(file,false);
//
//    	fw.write(max);
//    	fw.write(min);
//    	fw.flush();
//    	fw.close();
//    	}catch(Exception e) {
//    		e.printStackTrace();
//    	}
//    	
//    	
//    }
    
}
