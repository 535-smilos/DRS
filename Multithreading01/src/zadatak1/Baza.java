package zadatak1;

public class Baza extends Thread {
	double r;
	double povrsina;
	
	public Baza(double r) {
		this.r=r;
	}
	
	public void run() {
		povrsina=r*r*Math.PI;
		
	}
}
