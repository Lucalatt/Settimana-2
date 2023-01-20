package EsameSettimanale;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class Archivio {

	private static final String ENCODING = "utf-8";
	static String fileName = "Archivio.txt";
	static File fileInfo = new File(fileName);
	static Scanner in = new Scanner(System.in);
	static ArrayList<Libro> libri = new ArrayList<>();
	static ArrayList<Rivista> riviste = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		
		
		ArrayList<String> archivio = new ArrayList<>(FileUtils.readLines(fileInfo, ENCODING));
		
		
		
		boolean continuaProgramma = true;

		do {
			System.out.println("Benvenuti nell' archivio");
			System.out.println("1 - Aggiungi elemento");
			System.out.println("2 - Rimuovi (ISBN)");
			System.out.println("3 - Ricerca (ISBN)");
			System.out.println("4 - Ricerca (ANNO)");
			System.out.println("5 - Ricerca (AUTORE)");
			System.out.println("6 - Mostra archivio");
			System.out.println("0 - Chiudi archivio");
			System.out.println("**-----**");
			System.out.println("Seleziona un'opzione: ");
			try {
				int selezione = Integer.parseInt(in.nextLine());
				switch (selezione) {
				case (1):
					System.out.println("Inserisci tipo: ");
					System.out.println("1 - Libri");
					System.out.println("2 - Rivista");
					int selezioneTipo = Integer.parseInt(in.nextLine());
					if (selezioneTipo == 1) {
						aggiungiLibro();
					} else if (selezioneTipo == 2) {
						aggiungiRivista();
					} else {
						System.out.println("Selezione Errata");
					}
					break;
				case (2):
					System.out.println("- Digita il codice ISBN del libro da rimuovere:");
					long codiceIsbn = Long.parseLong(in.nextLine());
					archivio.removeIf(line -> line.contains(Long.toString(codiceIsbn)));
					FileUtils.writeLines(fileInfo, archivio);
					System.out.println("Elemento rimosso!");
					break;
				case (3):
					System.out.println("Inserisci l'ISBN da ricercare");
					long isbnRicerca = Long.parseLong(in.nextLine());
					archivio.stream().filter((e) -> e.contains(Long.toString(isbnRicerca)))
							.forEach((e) -> System.out.println(e));
					break;
				case (4):
					System.out.println("Inserisci l'anno da ricercare");
					int annoRicerca = Integer.parseInt(in.nextLine());
					archivio.stream().filter((e) -> e.contains(Integer.toString(annoRicerca)))
							.forEach((e) -> System.out.println(e));
					break;
				case (5):
					System.out.println("Inserisci l'autore da ricercare");
					String autoreRicerca = in.nextLine();
					archivio.stream().filter((e) -> e.contains(autoreRicerca)).forEach((e) -> System.out.println(e));
					break;
				case (6):
					System.out.printf("I contenuti del file %s sono: %n", fileInfo);
					System.out.println(FileUtils.readFileToString(fileInfo, ENCODING));
					break;

				case (0):
					System.out.println("Chiudi Archivio");
					in.close();
					System.exit(0);
					break;
				default:
					System.out.println("Seleziona un'opzione");
				}
			} catch (NumberFormatException e) {
				System.out.println("Errore! Valore non valido!");
			}

			System.out.println("Vuoi continuare? (S/N)");
			String input = in.nextLine();
			continuaProgramma = input.equalsIgnoreCase("S");
		} while (continuaProgramma);

	}

	public static void aggiungiLibro() {
		System.out.println("Inserisci titolo: ");
		String titolo = in.nextLine();
		System.out.println("Inserisci anno di pubblicazione: ");
		int anno = Integer.parseInt(in.nextLine());
		System.out.println("Inserisci numero pagine: ");
		int nPagine = Integer.parseInt(in.nextLine());
		System.out.println("Inserisci Autore");
		String autore = in.nextLine();
		System.out.println("Inserisci Genere");
		String genere = in.nextLine();

		Libro libro = new Libro(generatoreIsbn(), titolo, anno, nPagine, autore, genere);
		libri.add(libro);
		String libroAgg = libro.toString();
		try {
			scriviInArchivio(fileInfo, libroAgg + System.lineSeparator(), true);

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Libro aggiunto correttamente!");
	}

	public static void aggiungiRivista() {
		System.out.println("Inserisci titolo: ");
		String titolo = in.nextLine();
		System.out.println("Inserisci anno di pubblicazione: ");
		int anno = Integer.parseInt(in.nextLine());
		System.out.println("Inserisci numero pagine: ");
		int nPagine = Integer.parseInt(in.nextLine());
		System.out.println("Inserisci periodicità: ");
		System.out.println("1 - Settimanale");
		System.out.println("2 - Mensile");
		System.out.println("3 - Semestrale");
		int selezione = Integer.parseInt(in.nextLine());
		Periodicita periodicita = null;
		switch (selezione) {
		case (1):
			periodicita = Periodicita.SETTIMANALE;
			break;
		case (2):
			periodicita = Periodicita.MENSILE;
			break;
		case (3):
			periodicita = Periodicita.SEMESTRALE;
			break;
		default:
			System.out.println("Valore Errato");
		}

		Rivista rivista = new Rivista(generatoreIsbn(), titolo, anno, nPagine, periodicita);

		riviste.add(rivista);
		String rivistaAgg = rivista.toString();
		try {
			scriviInArchivio(fileInfo, rivistaAgg + System.lineSeparator(), true);

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Rivista aggiunto correttamente!");
	}

	public static long generatoreIsbn() {
		HashSet<Long> setIsbn = new HashSet<>();
		Random numR = new Random();
		long inizioCodice = 9000000000000L;
		long fineCodice = 9999999999999L;

		long nuovoIsbn = 0;

		do {
			nuovoIsbn = inizioCodice + (long) (numR.nextDouble() * (fineCodice - inizioCodice));
		} while (setIsbn.contains(nuovoIsbn));

		setIsbn.add(nuovoIsbn);
		return nuovoIsbn;
	}

	public static void scriviInArchivio(File f, String s, boolean append) throws IOException {
		FileUtils.writeStringToFile(f, s, ENCODING, append);
	}

	public static void eliminaDaArchivio(File f) throws IOException {
		FileUtils.readFileToString(f, ENCODING);
	}

}
