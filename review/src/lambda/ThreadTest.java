package lambda;

public class ThreadTest {

	public static void main(String[] args) {
//		for(int i=0; i<999; i++) {
//			System.out.println(i);
//		}
//		for(int i=1000; i<1999; i++) {
//			System.out.println(i);
//		}
		
		
		
		//두개의 for문 동시에 실행시키는 방법 = 멀티쓰레드
		
		Thread thread = new Thread(new Thread1());
		thread.start();

		//무명클래스로 생성하기
		Thread thread2 = new Thread(new Runnable(){
			public void run() {
				for (int i = 2000; i < 2999; i++) {
					try {
						Thread.sleep(200); // 2초간격으로 멈춤
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(i);
				}
			}});
		thread2.start();
		
		//람다식으로 표현(클래스 선언과 객체생성 = 무명클래스) +메소드가 하나뿐을때 사용가능
		Thread thread3 = new Thread(
				
				() -> {
					for (int i = 3000; i < 3999; i++) {
						try {
							Thread.sleep(200); // 2초간격으로 멈춤
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(i);
					}
				}
				
				);
		thread3.start();
		
		
		for (int i = 1000; i < 1999; i++) {
			try {
				Thread.sleep(200); // 2초간격으로 멈춤
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}

}
