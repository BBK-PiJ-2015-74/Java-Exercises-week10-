package insertion;

import java.util.Comparator;

public class Sort {

    // integer array insertion sort
    public static void insertionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            //Insert a[i] into the sorted sublist
            int v = a[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (a[j] <= v) break;
                a[j + 1] = a[j];
            }
            a[j + 1] = v;
        }
    }

    // Object array insertion sort
    public static void insertionSort(Object[] a) {
        for (int i = 0; i < a.length; i++) {
        /* Insert a[i] into the sorted sublist */
            Object v = a[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (((Comparable) a[j]).compareTo(v) <= 0) break;
                a[j + 1] = a[j];
            }
            a[j + 1] = v;
        }
    }

    // Object array insertion sort with comparator
    public static void insertionSort(Object[] a, Comparator c) {
        for (int i = 0; i < a.length; i++) {
        /* Insert a[i] into the sorted sublist */
            Object v = a[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (c.compare(a[j], v) <= 0) break;
                a[j + 1] = a[j];
            }
            a[j + 1] = v;
        }
    }

    // generic array insertion sort
    public static <T extends Comparable<? super T>>
    void insertionSortGeneric(T[] a) {
        for (int i = 0; i < a.length; i++) {
        /* Insert a[i] into the sorted sublist */
            T v = a[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (a[j].compareTo(v) <= 0) break;
                a[j + 1] = a[j];
            }
            a[j + 1] = v;
        }
    }

    // generic array insertion sort with comparator
    public static <T>
    void insertionSortGeneric(T[] a, Comparator<? super T> c) {
        for (int i = 0; i < a.length; i++) {
        /* Insert a[i] into the sorted sublist */
            T v = a[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (c.compare(a[j], v) <= 0) break;
                a[j + 1] = a[j];
            }
            a[j + 1] = v;
        }
    }


}
