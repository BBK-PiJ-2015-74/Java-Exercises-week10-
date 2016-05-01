package generics;

public class GenericBox<T> {
    private T t;

    public static void main(String[] args) {
        GenericBox<Integer> integerGenericBox = new GenericBox<>();
        GenericBox<String> stringGenericBox = new GenericBox<>();

        integerGenericBox.add(new Integer(10));
        stringGenericBox.add(new String("Hello World"));

        System.out.println("Integer Value: " + integerGenericBox.get());
        System.out.println("String Value: " + stringGenericBox.get());
    }

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}
