package esercizio3;

public class ContoCorrente {
	String titolare;
	int nMovimenti;
	final int maxMovimenti = 50;
	double saldo;

	ContoCorrente(String titolare, double saldo) {
		this.titolare = titolare;
		this.saldo = saldo;
		nMovimenti = 0;
	}

	void preleva(double x) {
		if (nMovimenti < maxMovimenti)
			saldo = saldo - x;
			if (saldo < 0 ) {
				throw new Exception ("disponibilità esaurita");
			}
		else {
			saldo = saldo - x - 0.50;
		nMovimenti++;}
	}

	double restituisciSaldo() {
		return saldo;
	}

}
