package esercizio1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		C1 c1 = new C1("*");
		C1 c2 = new C1("#");
		
		c1.start();
		c2.start();

	}

}

class C1 extends Thread {
	private String symb;
	
	public C1(String symb) {
		this.symb = symb;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			System.out.println("Simbolo: " + symb);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		} 
		
	}
}


