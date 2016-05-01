package exceptions;

public class Attempt {

    public static void main(String[] args) {
        System.out.println(throwException());
    }

    public static String throwException() {
        try {

            try {
                System.out.println("Inner Try reached");
                throw new Exception();
            } catch (RuntimeException e) {
                System.out.println("Inner Catch reached");
                return "Returned: Inner Nested catch";
            } finally {
                System.out.println("Inner Finally reached");
                return "Returned: Inner Nested finally";
            }

        } catch (Exception e) {
            System.out.println("Outer Catch reached");
            return "Returned: Outer Nested catch";
        } finally {
            System.out.println("Outer finally reached");
            return "Returned: Outer Nested finally";
        }
    }
}
