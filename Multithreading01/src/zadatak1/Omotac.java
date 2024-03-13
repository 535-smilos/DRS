package zadatak1;

public class Omotac extends Thread{
	double r, H, povrsina;
	
	public Omotac(double r, double H) {
		this.r=r;
		this.H=H;
	}
	
	public void run() {
		povrsina=2*r*Math.PI*H;
	}
}
