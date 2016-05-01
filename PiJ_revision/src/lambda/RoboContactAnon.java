package lambda;

import java.util.List;

public class RoboContactAnon {

    public void phoneContacts(List<Person> pl, MyTest<Person> aTest) {
        pl.stream().filter(t -> aTest.test(t)).forEach(x -> roboCall(x));
    }

    public void emailContacts(List<Person> pl, MyTest<Person> aTest) {
        pl.stream().filter(t -> aTest.test(t)).forEach(p -> roboEmail(p));
    }

    public void mailContacts(List<Person> pl, MyTest<Person> aTest) {
        pl.stream().filter(t -> aTest.test(t)).forEach(p -> roboMail(p));
    }

    public void roboCall(Person p) {
        System.out.println("Calling " + p.getGivenName() + " " + p.getSurName() + " age "
                + p.getAge() + " at " + p.getPhone());
    }

    public void roboEmail(Person p) {
        System.out.println("EMailing " + p.getGivenName() + " " + p.getSurName() + " age "
                + p.getAge() + " at " + p.getEmail());
    }

    public void roboMail(Person p) {
        System.out.println("Mailing " + p.getGivenName() + " " + p.getSurName() + " age "
                + p.getAge() + " at " + p.getAddress());
    }

}
