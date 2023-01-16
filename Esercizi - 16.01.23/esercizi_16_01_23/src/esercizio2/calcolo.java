package esercizio2;

import java.util.Scanner;

public class calcolo {
	int km;
	int lt;

	Scanner scan = new Scanner(System.in);

	public void calcola() throws ZeroError {

		System.out.println("INSERIRE I KM PERCORSI: ");
		km = scan.nextInt();

		System.out.println("INSERIRE I LITRI CONSUMATI: ");
		lt = scan.nextInt();
		scan.close();
		
		if( lt <= 0 ) {
			throw new ZeroError(lt);
		}

		int cons = km / lt;
		System.out.println("IL CONSUMO DELLA TUA AUTO E': " + cons + " km/lt");

	}
}
