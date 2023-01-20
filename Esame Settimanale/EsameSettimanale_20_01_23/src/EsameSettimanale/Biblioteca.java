package EsameSettimanale;

import java.time.LocalDate;

public abstract class Biblioteca {

	long codIsbn;
	String titolo;
	int annoPubblicazione;
	int nPagine;

	public Biblioteca(long codIsbn, String titolo, int annoPubblicazione, int nPagine) {
		super();
		this.codIsbn = codIsbn;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.nPagine = nPagine;
	}
	
	public long getCodiceIsbn() {
		return this.codIsbn;
	}
	
	

}
