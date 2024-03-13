package producer_consumer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bafer b=new Bafer(10);
		Proizvodjac p=new Proizvodjac(b);
		Potrosac c=new Potrosac(b);
		
		p.start();
		c.start();
		
		
	}

}
