package thread_pools;

import java.util.concurrent.Callable;

public class Zadatak2 implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getId()+" izvrsava zadatak2.");
		return 76;
	}

}
