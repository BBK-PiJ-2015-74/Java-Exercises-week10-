package streams;

import java.util.ArrayList;
import java.util.List;

public class Streams2 {

    public static void main(String[] args) {

        List<String> stringCollection = new ArrayList<String>() {{
            add("ddd2");
            add("aaa2");
            add("bbb1");
            add("aaa1");
            add("bbb3");
            add("ccc");
            add("bbb2");
            add("ddd1");
        }};

        System.out.println(stringCollection);

        // sorting

        stringCollection
                .stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println(stringCollection);


    }

}
