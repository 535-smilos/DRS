package brojaci;

public class TredBrojac extends Thread{
	Brojac b;
	int id;
	
	public TredBrojac(Brojac b, int id) {
		this.b=b;
		this.id=id;	
	}
	
	public void run() {
		for(int i=0;i<1000;i++) {
			//this.b.counter++;
			
			//this.b.increment();
			
			/*if(this.id==0) {
				this.b.increment();
			}
			else {
				this.b.increment1();
			}
			*/
			
			//pristup preko sinhronizovanog bloka,
			//nedostatak je sto primitivne tipove ne moze da mijenja!!!
			synchronized (this.b) {
				this.b.counter++;
			}
			
		}
	}
}
