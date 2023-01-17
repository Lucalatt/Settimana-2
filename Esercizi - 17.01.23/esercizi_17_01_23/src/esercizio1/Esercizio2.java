package esercizio1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Esercizio2 {

	public static void main(String[] args) {

		int N = 5;
        List<Integer> list = createRandomList(N);
        System.out.println("Lista originale: " + list);

        List<Integer> newList = duplicateAndReverseList(list);
        System.out.println("Nuova lista: " + newList);

        boolean isEven = true;
        printListByIndex(newList, isEven);

	}
	
	public static List<Integer> createRandomList(int N) {
        List<Integer> list = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            list.add(rand.nextInt(101));
        }
        Collections.sort(list);
        return list;
    }

    public static List<Integer> duplicateAndReverseList(List<Integer> list) {
        List<Integer> newList = new ArrayList<>(list);
        newList.addAll(new ArrayList<>(list));
        Collections.reverse(newList);
        return newList;
    }

    public static void printListByIndex(List<Integer> list, boolean isEven) {
        System.out.print("Valori in posizioni ");
        if (isEven) {
            System.out.print("pari: ");
        } else {
            System.out.print("dispari: ");
        }
        for (int i = 0; i < list.size(); i++) {
            if (isEven && i % 2 == 0) {
                System.out.print(list.get(i) + " ");
            } else if (!isEven && i % 2 != 0) {
                System.out.print(list.get(i) + " ");
            }
        }

	}

}
