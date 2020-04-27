package com.lec.java.file15;

import java.io.File;

public class File15Main {

	public static void main(String[] args) {
		System.out.println("디렉토리 정보 확인");
		System.out.println();
		// current working directory : 현재작업경로
		String curWorkingDir = System.getProperty("user.dir"); //여기선 이게절대경로 , getProperty() 경로얻는법		System.out.println("현재 작업 폴더: " + curWorkingDir);

		System.out.println();
		// 현재 작업 디렉토리의 파일 리스트 출력
		// File 클래스: 파일(txt, doc, ...) 객체 또는 디렉토리(폴더) 객체
		// File 폴더 ,파일 둘다 표현가능
		File curDir = new File(curWorkingDir); // 현재 작업 디렉토리(폴더) 객체
		File[] list = curDir.listFiles(); // listFiles() : 디렉토리 안에 있는 '파일'과 '디렉토리'를 file배열로 리턴
		// 디렉토리(폴더) , 파일 구분하기
		System.out.println(list.length); // '파일'과 '디렉토리' 의 개수
		for (int l = 0; l < list.length; l++) {
			System.out.println(list[l].getName()); // list[l]타입 = File
		}
		System.out.println();
		System.out.println();
		
		
		
		for (int l = 0; l < list.length; l++) {
			if (list[l].isDirectory()) {
				// isDirectory(): File 객체가 디렉토리이면 true 리턴
				// isFile(): File 객체가 파일이면 true 리턴
				System.out.print("DIR\t");
			} else {
				System.out.print("FILE\t");
			}
			System.out.print(list[l].getName()+"\t");
			System.out.println(list[l].length()+"bytes"); //length() '파일'의 크기 (byte)
												//'디렉토리' 인경우는 의미없
		}

		System.out.println(); //curWorkingDir(현재경로 기준 )밑에있는 파일을 찾은것 -- > '상대경로' 이영한 File 객체 생성 
		System.out.println("디렉토리의 내용 출력, enhanced for 문 이용");
		// 디렉토리의 내용 출력, enhanced for 문 이용
//		File tempDir = new File("temp");
//		절대경로(absolute path) 를 이용한 File객체생성		
		String tempDirPath =System.getProperty("user.dir")
			+ File.separator // 윈도우(\) , :LINUX,MAC(/)
			+ "temp";
		System.out.println("절대경로: "+tempDirPath);
		File tempDir =new File(tempDirPath);
		
		
		
		File[] list1 = tempDir.listFiles();
		System.out.println(list.length);
		for (File e : list1) {
			if(e.isDirectory()) {
				System.out.print("DIR\t");
			}else {
				System.out.print("FILE\t");
			}
			System.out.print(e.getName()+"\t");
			System.out.println(e.length()+"bytes");
		}

		System.out.println();
		// 파일 하나에 대한 정보
		String path = "dummy.txt"; //상대경로,
		File f= new File(path); //새로운 File 객체생성!
					//★File 객체를 생성(new)했다고 해서
					//물리적 파일/ 디렉토리가 만들어지는게 아니다!~~~~~
		System.out.println("파일이름: "+f.getName()); //상대 경로명
		System.out.println("절대경로: "+f.getAbsolutePath()); //절대 경로명
		System.out.println("있냐?: "+f.exists()); //물리적으로 존재하는지 여부 boolean타입 리턴
		
		
		
		
		System.out.println("\n프로그램 종료");

	} // end main()

} // end File11Main
