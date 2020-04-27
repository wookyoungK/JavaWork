package com.lec.java.datetime03;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.text.SimpleAttributeSet;

/* Calendar 객체를 사용한 시간 및 날짜 연산
 *  
 */
public class DateTime03Main {

	public static void main(String[] args) {
		System.out.println("날짜, 시간 연산");

		Calendar cal = Calendar.getInstance();
		DateFormat df = null;
		Date date = null;
		
		//-------------------------------------------------------
		System.out.println("현재 시간에서 날짜 더하고 빼기");
		
        cal.setTime(new Date());//현재시간 
        df= new SimpleDateFormat("yyy-MM-dd"); //*******
        System.out.println("현재"+df.format(cal.getTime())); //getTime()캘린더에서 날짜객체를 바당오는것!!
		
        //cal.add(Calendar.MONTH,11); //11개월뒤 , 하지만 음수가나와도 add는 덧셈이아니라 뺄셈도 동작한다
        cal.add(Calendar.DATE,3);
        
        System.out.println("계산후"+df.format(cal.getTime()));
        //-------------------------------------------------------
        System.out.println();
        System.out.println("특정 날짜에 더하고 빼기");
        
       df =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       try {
       date =df.parse("2010-03-16 09:00:00");
       }catch (ParseException e) {
    	   e.printStackTrace();
    	   
       }
       cal.setTime(date);
       System.out.println("주어진 시간:"+df.format(cal.getTime()));
       cal.add(Calendar.HOUR_OF_DAY, 5);
       cal.add(Calendar.MINUTE,20);
       cal.add(Calendar.SECOND,10);
      
        
        //-------------------------------------------------------
        System.out.println();
        System.out.println("날짜 두개 더하기");
        // 두개의 Date를 더하려면 두개의 Calendar를 사용해야 합니다. 
        
        Calendar cal2 =Calendar.getInstance();
        System.out.println("cal: "+df.format(cal.getTime()));
        System.out.println("cal2: "+df.format(cal2.getTime()));
        
        cal.add(Calendar.DATE, cal2.get(Calendar.DATE));
        System.out.println("날짜 두개 계산후");
        System.out.println("cal: "+df.format(cal.getTime()));
        System.out.println("cal2: "+df.format(cal2.getTime()));
       
            
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class











