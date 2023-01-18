package esercizio3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class Main {

	private static final String ENCODING = "utf-8";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String fileName = "RegistroPresenze.txt";
		File presenze = new File(fileName);
		Scanner in = new Scanner(System.in);

		if (presenze.exists()) {
			System.out.println("Scrivi il nome e le presenze");
			try {
				System.out.println("Scrivi nome della persona");
				String nome = in.nextLine();
				
				System.out.println("Scrivi quanti giorni di presenza ha fatto");
				int ggPresenze = in.nextInt();
				
				RegistroPresenze p1 = new RegistroPresenze(nome, ggPresenze);
				
				writeOnFile(presenze, p1.toString(), true);
				System.out.println("Prezenza aggiunta!");
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println("Leggi dal file:");
			try {
				readFromFile(presenze);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("errore");

		}
		in.close();

	}

	public static void writeOnFile(File f, String name, boolean append) throws IOException {
		FileUtils.writeStringToFile(f, name, ENCODING, true);
	}

	public static void readFromFile(File f) throws IOException {
		String content = FileUtils.readFileToString(f, ENCODING);
		String[] segments = content.split("#");

		try {
			RegistroPresenze registro = new RegistroPresenze(segments[0], Integer.parseInt(segments[1]));
			System.out.println(registro);
		} catch (NumberFormatException e) {
			System.out.println("Errore!");
		}
	}
}

class RegistroPresenze {
	private String name;
	private int days;

	public RegistroPresenze(String name, int days) {
		this.name = name;
		this.days = days;
	}

	@Override
	public String toString() {
		String s = String.format(this.name + "@", this.days + "#");
		return s;
	}

}
