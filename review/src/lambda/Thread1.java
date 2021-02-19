package lambda;

public class Thread1 implements Runnable { //멀티쓰레드하려면 implements Runnable 해야됨

	@Override
	public void run() {
		for(int i=0; i<999; i++) {
			try {
				Thread.sleep(200);  //2초간격으로 멈춤
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}

}
