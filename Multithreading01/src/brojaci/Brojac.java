package brojaci;

public class Brojac {
	static int counter;
	
	public synchronized void increment() {//sinhronizacija je kljuc da se fino izvrsi fja 
		//jer jedan thread ga poziva drugi se blokira i tako cekaju jedan drugoga
		counter++;
	}
	
	public static synchronized void increment1() {
		counter++;
	}
}
