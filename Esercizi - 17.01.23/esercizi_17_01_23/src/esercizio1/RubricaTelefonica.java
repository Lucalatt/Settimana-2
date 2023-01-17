package esercizio1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class RubricaTelefonica {

	Scanner scan = new Scanner(System.in);
	Map<String, String> contatti = new HashMap<>();
	String nome;
	String numero;

	public void rubrica() {
		System.out.println("1 - AGGIUNGI CONTATTO");
		System.out.println("2 - ELIMINA CONTATTO");
		System.out.println("3 - RICERCA CONTATTO TRAMITE NUMERO");
		System.out.println("4 - RICERCA CONTATTO TRAMITE NOME");
		System.out.println("5 - MOSTRA RUBRICA");
		System.out.println("-------------------------------");
		System.out.println("scegli un'opzione: ");
		int selezione = scan.nextInt();
		scan.nextLine();
		switch (selezione) {
		case (1):
			inserisciContatto();
			break;
		case (2):
			eliminaContatto();
			break;
		case (3):
			ricercaUtenteTelefono();
			break;
		case (4):
			ricercaUtenteNome();
			break;
		case (5):
			stampaContatti();
			break;
		default:
			System.out.println("valore errato!");
			break;
		}
		scan.close();
	}

	public void inserisciContatto() {
		System.out.println("Inserisci Nome: ");
		nome = scan.nextLine();
		System.out.println("Inserisci Numero di telefono: ");
		numero = scan.nextLine();

		contatti.put(nome, numero);
		rubrica();
	}

	public void eliminaContatto() {
		System.out.println("Inserisci il nome della persona da eliminare: ");
		String nomeDel = scan.nextLine();
		if (contatti.containsKey(nomeDel)) {
			contatti.remove(nomeDel);
			System.out.println("Contatto eliminato!");

		} else {
			System.out.println("Contatto non trovato!");
		}

		rubrica();

	}

	public void ricercaUtenteTelefono() {
		System.out.println("Inserisi il numero di telefono della persona da cercare: ");
		String numTel = scan.nextLine();
		for (Map.Entry<String, String> entry : contatti.entrySet()) {
			if (entry.getValue().equals(numTel)) {
				System.out.println("Nome: " + entry.getKey());
			} else {
				System.out.println("Contatto non trovato!");
			}

			rubrica();
		}

	}

	public void ricercaUtenteNome() {
		System.out.println("Inserisi il nome della persona da cercare: ");
		String nomeContatto = scan.nextLine();
		for (Map.Entry<String, String> entry : contatti.entrySet()) {
			if (entry.getKey().equals(nomeContatto) ) {
				System.out.println("Numero: " + entry.getValue());
			} else {
				System.out.println("Contatto non trovato!");
			}
			
			rubrica();
		}

	}

	public void stampaContatti() {
		if (!contatti.isEmpty()) {
			for (Map.Entry<String, String> entry : contatti.entrySet()) {
				System.out.println("Nome: " + entry.getKey() + " - Numero: " + entry.getValue());
			}
		} else {
			System.out.println("LA LISTA E' VUOTA!");
		}

		rubrica();

	}

}
