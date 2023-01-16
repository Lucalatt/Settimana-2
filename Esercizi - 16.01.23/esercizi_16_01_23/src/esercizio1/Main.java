package esercizio1;

import java.util.Arrays;
import java.util.Random;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		create();

	    
	}
	
	public static void create() {
		
		Scanner scan = new Scanner(System.in);
		
		int[] numbers = new int[5];
		
		Random num = new Random();
		
		int position = 0;
		int newValue = 0;
		
		try  {
	
			for (int i = 0; i < numbers.length; i++) {		
				numbers[i] = num.nextInt(1, 11);
				}
			
			
			System.out.println("ARRAY BASE");
			System.out.println(Arrays.toString(numbers));
			System.out.println("----------");
			
			do {
				System.out.println("INSERISCI UN VALORE");
				newValue = scan.nextInt();
				
				System.out.println("IN CHE POSIZIONE?");
				position = scan.nextInt();
				
				if (newValue > 0) {
					for (int i = numbers.length - 1; i > position; i-- ) {
						numbers[i] = numbers [i];
					}
					
					numbers[position] = newValue;
					System.out.println("NUOVO ARRAY: " + Arrays.toString(numbers));
					System.out.println("------");
				} else {
					System.out.println("INSERITO 0, PROGRAMMA TERMINATO");
					scan.close();
				}
			} while (newValue != 0);
			
			
			
		} catch (InputMismatchException e) {
			System.out.println("VALORE ERRATO, INSERIRE NUMERO");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("POSIZIONE ARRAY ERRATA");
		}
	}
	
	
}
