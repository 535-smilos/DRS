package zadatak1;

import java.util.concurrent.Callable;

public class Baza1 implements Callable<Double>{//ovo kad imamo povratnu vrijednost
	double r;
	
	public Baza1(double r) {
		this.r=r;
	}
	@Override
	public Double call() throws Exception {
		return r*r*Math.PI;
	}

}
