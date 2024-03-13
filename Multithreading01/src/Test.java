
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//------prvi nacin
		/*MyThread1 t1=new MyThread1("ping", 300);
		MyThread1 t2=new MyThread1("PONG", 1000);*/
		
		/*
		t1.run();//ovo je pozivanje obicne metode iz klase
		t2.run();//greska jer besk stampanje pinga nikad nece dozvoliti stampanje ponga
		*/
		
		/*
		t1.start();//smjenjuju se ping pong
		t2.start();*/
		
		
		//------drugi nacin
		MyThread2 mt1=new MyThread2("ping", 300);
		MyThread2 mt2=new MyThread2("PONG", 1000);
		
		Thread t3=new Thread(mt1);//smjesta se objekat klase runnable
		t3.start();
		
		Thread t4=new Thread(mt2);
		t4.start();
		
	}

}
