package zadatak_15;

public class Putnici extends Thread{
	Rolerkoster r;
	int id;
	
	public Putnici(int id,Rolerkoster r) {
		this.id=id;
		this.r=r;
	}
	
	public void run() {
		while(true) {
			System.out.println("Putnik "+this.id+" se seta po parku.");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.r.udji();//ceka da udje na rolerkoster
			this.r.izadji();//izadje kad se voznja zavrsi
		}
	}
}
