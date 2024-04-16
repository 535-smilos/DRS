package zadatak_15;

public class Rolerkoster {
	volatile int kapacitet;
	volatile int broj_putnika;
	
	volatile boolean ulazak=true, voznja=false, izlazak=false;
	
	public Rolerkoster(int k) {
		this.kapacitet=k;
	}
	
	public synchronized void udji() {
		int id=(int) ((Putnici)Thread.currentThread()).getId();
		while(this.ulazak==false) {
			System.out.println("Putnik "+id+" ceka voznju");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.broj_putnika++;
		System.out.println("Putnik "+id+" usao na voznju");
		if(this.broj_putnika==this.kapacitet) {
			this.ulazak=false;
			this.voznja=true;
			notifyAll();
		}
	}
	
	public synchronized void izadji() {
		while(this.izlazak==false) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		this.broj_putnika--;
		int id=(int) ((Putnici)Thread.currentThread()).getId();
		System.out.println("putnik "+id+" je izasao");
		
		if(this.broj_putnika==0) {
			this.izlazak=false;
			this.ulazak=true;
			notifyAll();
		}
		
	}
	
	public synchronized void zapocniVoznju() {
		while(this.voznja==false) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Voznja pocinje");
		
		
	}
	
	public synchronized void zavrsiVoznju() {
		System.out.println("Voznja je zavrsena");
		this.voznja=false;
		this.izlazak=true;
		notifyAll();
	}
}
