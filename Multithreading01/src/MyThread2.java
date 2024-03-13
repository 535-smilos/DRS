
public class MyThread2 implements Runnable{//drugi nacin, implementacijom interfejsa, tjera nas da implementiramo metode
	String poruka; int vrijeme;
	
	public MyThread2(String poruka, int vrijeme) {
		this.poruka=poruka;
		this.vrijeme=vrijeme;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println(this.poruka);
			//sleep funkcija je staticka fja u klasi thread
			try {
				Thread.sleep(vrijeme);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
