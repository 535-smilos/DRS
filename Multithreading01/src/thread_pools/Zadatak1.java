package thread_pools;

public class Zadatak1 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getId()+" izvrsava zadatak.");
		if(Thread.currentThread().getId()%3==0) {			
			System.out.println(5/0);
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
