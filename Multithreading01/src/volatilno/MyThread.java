package volatilno;

public class MyThread extends Thread{
	volatile boolean stop=false;//stavljamo volatile ako postoje promjenljive koje drugi tredovi mogu mijenjati
	
	public void run() {
		while(!stop) {
			System.out.println("ja sam thread! :) ");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
