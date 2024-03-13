package filozofi;

public class Viljuska {
	boolean slobodna;
	
	public Viljuska() {
		this.slobodna=true;
	}
	
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
	}
	
	public synchronized void spusti() {
		System.out.println(((Filozof)Thread.currentThread()).ime+" je spustio viljusku.");
		this.slobodna=true;
		notify();
	}
	
}
