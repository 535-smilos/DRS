package zadatak_12;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		
		Nit niz[]=new Nit[n];
		Barijera b=new Barijera(n);
		
		for(int i=0;i<n;i++) {
			niz[i]=new Nit(b);
			niz[i].start();
		}
		
	}

}
