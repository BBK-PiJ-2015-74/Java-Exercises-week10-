package comparator;

import java.util.Comparator;

public class Dog implements Comparator<Dog>, Comparable<Dog> {
    private String name;
    private int age;

    public Dog() {
    }

    public Dog(String n, int a) {
        name = n;
        age = a;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Overriding the compareTo method
    @Override
    public int compareTo(Dog d) {
        return (this.getName()).compareTo(d.getName());
    }

    // Overriding the compare method to sort the age
    @Override
    public int compare(Dog d, Dog d1) {
        return d.getAge() - d1.getAge();
    }
}

