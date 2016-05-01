package insertion;

import java.util.Comparator;
import java.util.Random;

import static insertion.Sort.insertionSort;
import static insertion.Sort.insertionSortGeneric;

public class SortTest {
    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        Random rand = new Random();
        Integer[] a = new Integer[size];
        for (int i = 0; i < size; i++) {
            a[i] = rand.nextInt(size);
        }
        insertionSort(a);
        check(a);

        insertionSortGeneric(a, new Comp());
    }

    static void check(Integer[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                System.out.println("ERROR");
            }
        }
    }

}

class Comp<T extends Comparable<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }
}
