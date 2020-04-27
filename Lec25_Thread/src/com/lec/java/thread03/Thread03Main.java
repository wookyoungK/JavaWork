package com.lec.java.thread03;

/* 쓰레드와 익명클래스
 */
//질문 .getname을 사용하는이유 , 여기서 몇개가 동작되는가 Runnable 이 불려서 동작된것익ㄴ가

//자주쓰이는것 -https://wwhite103.tistory.com/39
//.printStackTrace() = 에러 메세지의 발생 근원지를 찾아서 단계별로 에러출력
//.getMessage()  에러이벤트와 함꼐 들어오는 메세지출력
//toString() 에러 이벤트의 toString()을 호출해서 간단한 에러메시지 확인 

public class Thread03Main {

	public static void main(String[] args) {
		System.out.println("쓰레드와 익명 클래스");

		// 이미 정의된 MyRunnable 클래스의 인스턴스 사용
		new Thread(new MyRunnable()).start();

		// 익명 클래스를 사용해서 Runnable 인스턴스를 생성
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("3 x" + i + "=" + (3 * i));

					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						
					}
				}
			}
		}).start();
		for (int i = 0; i < 10; i++) {
			System.out.println("4 x" + i + "=" + (4 * i));
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	} // end main()

} // end class Thread03Main

class MyRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("2 x" + i + "=" + (2 * i));

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

} // end class MyRunnable
