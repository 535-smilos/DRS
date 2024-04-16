package zadatak_15;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rolerkoster r=new Rolerkoster(3);
		Putnici[] p=new Putnici[10];
		
		Vozac v=new Vozac(r);
		
		for(int i=0;i<10;i++) {
			p[i]=new Putnici(i, r);
			p[i].start();
		}
		v.start();
	}

}
