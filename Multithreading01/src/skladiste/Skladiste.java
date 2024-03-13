package skladiste;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Skladiste {
	List<Integer> l1 = new LinkedList<Integer>();
	List<Integer> l2 = new LinkedList<Integer>();
	
	//------------prvi nacin sinhronizacije
	
	/*public synchronized void add1() {//dodavanje u prvu listu
		Random r=new Random();
		l1.add(r.nextInt());
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void add2() {//dodavanje u drugu listu
		Random r=new Random();
		l2.add(r.nextInt());
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	//-----------blok sinhronizacije, drugi nacin
	
	/*public void add1() {//dodavanje u prvu listu
		Random r=new Random();
		synchronized (l1) {//blok			
			l1.add(r.nextInt());
		}
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void add2() {//dodavanje u drugu listu
		Random r=new Random();
		synchronized (l2) {//blok	
			l2.add(r.nextInt());
		}
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	//--------treci nacin, preko brava/lock-ova
	
	Lock lock1=new ReentrantLock();
	Lock lock2=new ReentrantLock();
	
	public void add1() {//dodavanje u prvu listu
		Random r=new Random();
		lock1.lock();//kad nam treba zakljucamo
		l1.add(r.nextInt());
		lock1.unlock();//kad nam ne treba otkljucamo
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void add2() {//dodavanje u drugu listu
		Random r=new Random();
		lock2.lock();
		l2.add(r.nextInt());
		lock2.unlock();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
