package zadatak_12;

public class Nit extends Thread{
	Barijera b;
	
	public Nit(Barijera barijera) {
		this.b=barijera;
	}
	
	public void run() {
		while(true) {//sa while je implementacija pod b
			this.b.cekaj();//dolazi na barijeru
			this.b.napusti();//napusta barijeru
		}
	}
}
