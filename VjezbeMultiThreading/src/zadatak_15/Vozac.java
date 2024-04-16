package zadatak_15;

public class Vozac extends Thread{
	Rolerkoster r;
	
	public Vozac(Rolerkoster r) {
		this.r=r;
	}
	
	public void run() {
		while(true) {
			this.r.zapocniVoznju();
			try {
				sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.r.zavrsiVoznju();
		}
	}
}
