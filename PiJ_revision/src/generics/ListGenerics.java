package generics;

import java.util.Arrays;
import java.util.List;

public class ListGenerics {

    public static void main(String[] args) {
        List<String> stringlist =  Arrays.asList("Buenos Aires", "Córdoba", "La Plata");
        List<Integer> integerlist = Arrays.asList(1,2,3,45);

        printListOfStrings(stringlist);
        printListAgain(stringlist);
        printListAgain(integerlist);
    }

    public static void printListOfStrings(List<String> list) {
        list.forEach(System.out::println);
    }

    public static void printListAgain(List<?> list) {
        list.forEach(System.out::println);
    }
}
