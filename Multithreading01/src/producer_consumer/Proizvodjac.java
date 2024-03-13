package producer_consumer;

import java.util.Random;

public class Proizvodjac extends Thread{
	Bafer bafer;
	
	public Proizvodjac(Bafer b) {
		this.bafer=b;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random r=new Random(); 
		while(true) {
			this.bafer.dodaj(r.nextInt(100));
			
			try {
				sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
