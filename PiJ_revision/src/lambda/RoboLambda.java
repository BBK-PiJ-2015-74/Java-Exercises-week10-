package lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class RoboLambda {
    public <T> void phoneContacts(List<T> pl, Predicate<T> pred, Consumer<T> ct) {
        pl.stream().filter(p -> pred.test(p)).forEach(x -> ct.accept(x));
    }

    public void roboCall(Person p) {
        System.out.println("Calling " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getPhone());
    }

    public void roboEmail(Person p) {
        System.out.println("EMailing " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getEmail());
    }

    public void roboMail(Person p) {
        System.out.println("Mailing " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getAddress());
    }

}
