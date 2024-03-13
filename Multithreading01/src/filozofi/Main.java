package filozofi;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Viljuska[] viljuske=new Viljuska[5];
		Filozof[] filozofi=new Filozof[5];
		
		for(int i=0;i<5;i++) {
			viljuske[i]=new Viljuska();
		}
		
		filozofi[0]=new Filozof("Niche", viljuske[0], viljuske[1]);
		filozofi[1]=new Filozof("Hegel", viljuske[1], viljuske[2]);
		filozofi[2]=new Filozof("Kant", viljuske[2], viljuske[3]);
		filozofi[3]=new Filozof("Kjerkegor", viljuske[3], viljuske[4]);
		filozofi[4]=new Filozof("Marks", viljuske[4], viljuske[0]);
		
		for(int i=0;i<5;i++) {
			filozofi[i].start();
		}
		
	}

}
