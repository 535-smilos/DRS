
public class MyThread1 extends Thread {//jedan od nacina pravljenja threadova
	String poruka;
	int vrijeme;
	public MyThread1(String poruka, int vrijeme) {
		this.poruka=poruka;
		this.vrijeme=vrijeme;
		
	}
	@Override//ova metoda mora da se predefinise
	public void run() {//definise se kao main za threadove, tj odakle krece thread da se izvrsava
		while(true) {
			System.out.println(poruka);
			try {
				sleep(vrijeme);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//sleep gasi nakon unesenih ms izvrsavanja, cesto ide uz try-catch
			
		}
	}
}
