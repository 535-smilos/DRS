package producer_consumer;

public class Bafer {
	int kapacitet;
	int pocetak;
	int kraj;
	int brojac;
	int[] elementi;
	
	public Bafer(int kapacitet) {
		this.kapacitet=kapacitet;
		this.pocetak=0;
		this.kraj=0;
		this.brojac=0;
		this.elementi=new int[kapacitet];
	}
	
	public synchronized void dodaj(int el) {
		while(this.brojac==this.kapacitet) {
			try {
				System.out.println("Proizvodjac ceka.");
				wait();//kad neka klasa pozove wait, ostaje blokiran, mora biti sinhronizovano
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.elementi[this.kraj]=el;
		this.brojac++;
		this.kraj=(this.kraj+1)%this.kapacitet;
		if(this.brojac==1) {			
			notify();//za potrosaca, da mu se javi kad se oslobodi neki prostor
			//notifyAll();//za vise potrosaca
		}
		
		System.out.println("Proizvodjac je dodao element " + el + " u bafer");
	}
	
	public synchronized int uzmi() {
		while(this.brojac==0) {
			try {
				System.out.println("Potrosac ceka.");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//potrosac ceka dok god je red prazan
		}
		
		int el=this.elementi[this.pocetak];
		this.brojac--;
		this.pocetak=(this.pocetak+1)%this.kapacitet;
		
		if(this.brojac==this.kapacitet-1) {//ako ima elemenata
			notify();
		}
		
		System.out.println("potrosac je uyzeo element "+ el + "iz bafera");
		return el;
		
	}
	
	
	
}
