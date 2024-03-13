package zadatak1;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Valjak {
	public static void main(String[] args) {//u 2 threada da se racuna baza i omotac i ovom glavnom da se vrati povrsina
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		double r, H;
		
		r=in.nextDouble();
		H=in.nextDouble();
		
		//Baza b=new Baza(r);
		Omotac m=new Omotac(r, H);
		
		//b.start();
		m.start();
				
		//sa join cekamo da se oba izvrse da bi ih glavni iskoristio: glavni+b+m
		try {
			//b.join();//main thread ceka da se zavrsi b
			m.join();//isto i za m
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//treci nacin
		Baza1 b=new Baza1(r);
		FutureTask<Double> ft=new FutureTask<Double>(b);//predaje se callable objekat 
		Thread t=new Thread(ft);//prima futuretask
		t.start();
		try {
			ft.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//isto radi kao join, ceka i vraca rezultat
		
		
		
		//System.out.println("Povrsina valjka je: "+(2*b.povrsina+m.povrsina));//ovakva implementacija vrace 0 jer nismo
																			//sacekali ostale tredove da izracunaju
		
		try {
			System.out.println("povrsina valjka je:" + (2*ft.get()+m.povrsina));
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
