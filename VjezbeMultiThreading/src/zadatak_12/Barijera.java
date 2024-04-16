package zadatak_12;

public class Barijera {
	int brojac;
	int ukupnoNiti;
	boolean izlazak=false;//ovo se koristi kad naznacavamo da je proces izlaska u toku
	
	public Barijera(int n) {
		this.ukupnoNiti=n;
	}
	
	public synchronized void cekaj() {
		while(this.izlazak==true) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		brojac++;
		System.out.println("Dosla sam na barijeru i cekam ostale!");
		if(this.brojac==this.ukupnoNiti) {			
			this.izlazak=true;
			notifyAll();//kada su svi dosli onda moze da se napusti
		}
		while(this.izlazak==false) {
				try {
				wait();//ceka se dok svi tredovi ne dodju
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public synchronized void napusti() {
		System.out.println("Napustam barijeru!");
		brojac--;
		if(this.brojac==0) {
			this.izlazak=false;
			notifyAll();
		}
	}
	
}
