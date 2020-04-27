package com.lec.java.file04;
/* 보조스트림 (filter stream)
Program <=== FilterInputStream <=== InputStream <=== Source
					↓ 상속					↓ 상속
Program <=== BufferedInputStream <=== FileInputStream <=== File


Program ===> FilterOutputStream ===> OutputStream ===> Source
					↓ 상속					↓ 상속
Program ===> BufferedOutputStream ===> FileOutputStream ===> File

java.io.InputStream
 |__ java.io.FilterInputStream
      |__ java.io.BufferedInputStream-->내부적으로 buff를 사용한다

java.io.OutputStream
 |__ java.io.FilterOutputStream
      |__ java.io.BufferedOutputStream-->내부적으로 buff를 사용한다 

참고 ) 보조스트림 (filter stream)
보조스트림(filter stream) 이란 다른 스트림과 연결되어 여러가지 편리한 기능을 제공해주는 스트림
*/

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class File04Main {

	public static void main(String[] args) {
		System.out.println("BufferedInputStream, BufferedOutputStream");

		InputStream in = null; // InputStream 변수선언
		BufferedInputStream bin =null;
		OutputStream out = null; // OutputStream 변수 선언
		BufferedOutputStream bout =null;

		// FileInputStream 인스턴스 생성
		try {
			in = new FileInputStream("temp/big_text.txt"); // inputstream을 big_text에다가 꽂아넣은것
			bin = new BufferedInputStream(in);//장착
			// FileOutStream
			out = new FileOutputStream("temp/copy_big_text.txt");
			bout = new BufferedOutputStream(out);//장착
			// 위 파일이 없으면 새로 생성
			// 있으면 기존 파일 삭제후 새로 생성

			int dataRead;
			int bytesCopied = 0;
			long startTime = System.currentTimeMillis();
			// 파일복사 : 읽기->쓰기
			while (true) {
				

				dataRead = bin.read();
				if (dataRead == -1) {// 더이상 읽을 것이 없으면 read()는-1리턴
					break;
				}

				bout.write(dataRead);
				bytesCopied++;

			}
			long endTime = System.currentTimeMillis();
			long elapsedTime = endTime - startTime;
			System.out.println("읽고 쓴 바이트" + bytesCopied);
			System.out.println("경과시간 : " + elapsedTime);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 리소스 해제
			try {
				if (bout != null)bout.close();
				if (bin != null)bin.close();
				//bin을 close 하면, bin을 만든 in도 같이 close됨
				//bout close 하면, bout을 만든out도같이 close됨
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("\n프로그램 종료");

	} // end main()

} // end class
