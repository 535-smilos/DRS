package producer_consumer;

public class Potrosac extends Thread{
	Bafer bafer;
	
	public Potrosac(Bafer b) {
		this.bafer=b;
	}
	
	public void run() {
		while(true) {
			int el=this.bafer.uzmi();
			try {
				sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
