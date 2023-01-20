package esercizio19_01_23;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		Prodotto p1 = new Prodotto(1, "Libro 1", "Libri", 12.00);
		Prodotto p2 = new Prodotto(2, "Libro 2", "Libri", 20.00);
		Prodotto p3 = new Prodotto(3, "Libro 3", "Libri", 150.00);
		Prodotto p4 = new Prodotto(4, "Gioco 1", "Baby", 10.00);
		Prodotto p5 = new Prodotto(5, "Gioco 2", "Baby", 50.00);
		Prodotto p6 = new Prodotto(6, "Gioco 3", "Baby", 30.00);
		Prodotto p7 = new Prodotto(7, "Articolo 1", "Boys", 15.00);
		Prodotto p8 = new Prodotto(8, "Articolo 2", "Boys", 40.00);
		Prodotto p9 = new Prodotto(9, "Articolo 3", "Boys", 20.00);

		ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9));
			
			Stream<Prodotto> bookStream = prodotti.stream()
					.filter((prodotto) -> prodotto.getCategoria() == "Libri" && prodotto.getPrezzo() > 100);
			
			bookStream.forEach(prodotto -> {
				System.out.println(prodotto);
			});
			
			ArrayList<Prodotto> ordine1 = new ArrayList<Prodotto>(Arrays.asList(p6, p8, p9));
			
			ArrayList<Prodotto> ordine2 = new ArrayList<Prodotto>(Arrays.asList(p3, p5, p8, p9)); 
			
			ArrayList<Prodotto> ordine3 = new ArrayList<Prodotto>(Arrays.asList(p1, p8, p9)); 
			
			Cliente c1 = new Cliente(1, "Luca", 1);
			Cliente c2 = new Cliente(2, "Marco", 2);
			Cliente c3 = new Cliente(3, "Giovanni", 2);
			
			Ordine o1 = new Ordine (1, "in consegna",LocalDate.of(2023, 1, 23), LocalDate.now(), ordine1, c1);
			Ordine o2 = new Ordine (2, "in consegna",LocalDate.of(2023, 1, 18), LocalDate.now(), ordine2, c2);
			Ordine o3 = new Ordine (3, "in consegna",LocalDate.of(2023, 1, 20), LocalDate.now(), ordine3, c3);
			
			ArrayList<Ordine> listaOrdini = new ArrayList<Ordine>(Arrays.asList(o1, o2, o3));
			
			ArrayList<Ordine> listaFiltrata = new ArrayList<>();
	          listaOrdini.stream()
	                      .filter((ordine) -> ordine.getProdotti().stream()
	                                      .filter((categoriaProdotto) -> categoriaProdotto.getCategoria() == "Baby")
	                                      .count() > 0)
	                      .forEach((ordine) -> listaFiltrata.add(ordine));

	            listaFiltrata.forEach(ordine -> {
	                System.out.println(ordine);
	              });
	            
	            
	}
	
}

	class Prodotto {

		long id;
		String nome;
		String categoria;
		double prezzo;

		public Prodotto(long id, String nome, String categoria, double prezzo) {
			this.id = id;
			this.nome = nome;
			this.categoria = categoria;
			this.prezzo = prezzo;
		}
		
		public String getCategoria() {
			return this.categoria;
		}
		
		public double getPrezzo() {
			return this.prezzo;
		}
		
		@Override 
		public String toString() {
			return "Nome libro: " + this.nome + " Prezzo: " + this.prezzo + " €";
		}
	}

	class Ordine {

		long id;
		String stato;
		LocalDate dataOrdine;
		LocalDate dataConsegna;
		List<Prodotto> prodotti;
		Cliente cliente;

		public Ordine(long id, String stato, LocalDate dataOrdine, LocalDate dataConsegna, List<Prodotto> prodotti,
				Cliente cliente) {

			this.id = id;
			this.stato = stato;
			this.dataOrdine = dataOrdine;
			this.dataConsegna = dataConsegna;
			this.prodotti = prodotti;
			this.cliente = cliente;
		}
		
		public List<Prodotto> getProdotti() {
			return this.prodotti
;			
		}
		
		@Override 
		public String toString() {
			return "ID - " + this.id + " stato ordine: " + this.stato + " data ordine: " + this.dataOrdine + " data consegna: " + this.dataConsegna +" prodotti: " + this.prodotti + " Cliente: " + this.cliente;
		}
	}

	class Cliente {

		long id;
		String nome;
		int livello;

		public Cliente(long id, String nome, int livello) {

			this.id = id;
			this.nome = nome;
			this.livello = livello;
		}
		
		@Override 
		public String toString() {
			return this.nome + " Livello: " + this.livello;
		}

	}
