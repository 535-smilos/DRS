package brojaci;

public class Main {//dijeljenje istog resursa izmedju vise threadova

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Brojac b=new Brojac();
		
		TredBrojac t1=new TredBrojac(b, 1);
		TredBrojac t2=new TredBrojac(b, 0);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(b.counter);
	}

}
