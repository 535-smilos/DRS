package skladiste;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Skladiste s=new Skladiste();
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<1000;i++) {
					s.add1();
					s.add2();
				}
			}
		};
		
		Thread t1=new Thread(r);
		Thread t2=new Thread(r);
		
		t1.start();
		t2.start();
		
		long begin=System.currentTimeMillis();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Velicine listi: "+s.l1.size()+" "+ s.l2.size());
		long end=System.currentTimeMillis();
		
		System.out.println("Proteklo vrijeme: "+(end-begin));
	}

}
