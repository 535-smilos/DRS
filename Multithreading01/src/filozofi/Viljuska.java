package filozofi;

public class Viljuska {
	boolean slobodna;
	
	public Viljuska() {
		this.slobodna=true;
	}
	
	/*
	public synchronized void uzmi() {
		while(this.slobodna==false) {
			System.out.println(((Filozof)Thread.currentThread()).ime+" ceka viljusku.");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		slobodna=false;
	}*/
	public synchronized void uzmiLijevu() {
		while(this.slobodna==false) {
			System.out.println(((Filozof)Thread.currentThread()).ime+" ceka lijevu viljusku.");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		slobodna=false;
		System.out.println(((Filozof)Thread.currentThread()).ime+" je spustio lijevu viljusku.");	}
	
	public synchronized boolean uzmiDesnu() {
		if(slobodna==false) {
			System.out.println(((Filozof)Thread.currentThread()).ime+" ne moze uzeti desnu viljusku.");
			return false;
		}
		
		slobodna=false;
		System.out.println(((Filozof)Thread.currentThread()).ime+" je spustio desnu viljusku.");
		return true;
	}
	
	public synchronized void spusti() {
		System.out.println(((Filozof)Thread.currentThread()).ime+" je spustio viljusku.");
		this.slobodna=true;
		notify();
	}
	
}
