package thread_pools;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService pool=Executors.newFixedThreadPool(3);
		
		Zadatak1 z1=new Zadatak1();
		Zadatak1 z2=new Zadatak1();
		Zadatak1 z3=new Zadatak1();
		Zadatak1 z4=new Zadatak1();
		Zadatak1 z5=new Zadatak1();
	
		pool.execute(z1);
		pool.execute(z2);
		pool.execute(z3);
		pool.execute(z4);
		pool.execute(z5);
		
		Zadatak2 z6=new Zadatak2();
		FutureTask<Integer> f1=new FutureTask<Integer>(z6);
		
		pool.submit(f1);
		try {
			System.out.println(f1.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pool.shutdown();
		
		while(!pool.isTerminated());
		
	}

}
