package filozofi;

public class Filozof extends Thread{
	String ime;
	Viljuska lijeva;
	Viljuska desna;
	
	public Filozof(String ime, Viljuska l, Viljuska d) {
		this.ime=ime;
		this.lijeva=l;
		this.desna=d;
	}
	
	public void run() {
		while(true) {
			System.out.println(this.ime+" filozofira.");
			/*try {
				sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			this.lijeva.uzmi();
			try {
				sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.desna.uzmi();
			System.out.println(this.ime+" jede.");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.lijeva.spusti();
			this.desna.spusti();
			System.out.println(this.ime+" odmara.");
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
