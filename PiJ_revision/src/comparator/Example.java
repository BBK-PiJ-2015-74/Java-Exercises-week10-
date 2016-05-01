package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example {

    public static void main(String args[]) {
        // Takes a list o Dog objects
        List<Dog> list = new ArrayList<>();

        list.add(new Dog("Shaggy", 3));
        list.add(new Dog("Lacy", 2));
        list.add(new Dog("Roger", 10));
        list.add(new Dog("Tommy", 4));
        list.add(new Dog("Tammy", 1));
        Collections.sort(list);// Sorts the array list

        //printing the sorted list of names
        list.forEach(x -> System.out.print(x.getName() + ", "));

        // Sorts the array list using comparator
        Collections.sort(list, new Dog());
        System.out.println(" ");

        //printing the sorted list of ages
        list.forEach(x -> System.out.print(x.getName() + "  : " + x.getAge() + ", "));
    }
}
