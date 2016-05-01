package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

/**
 * @author Benjamin Winterberg
 */
public class Streams3 {

    static Timer timer = new Timer();
    static final int MAX = 1000000;

    public static void sortSequential() {
        List<String> values = new ArrayList<>(MAX);
        IntStream.range(0, MAX).forEach(i -> {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        });

        // sequential
        timer.start();
        System.out.println(values.stream().sorted().count());
        timer.end();

        System.out.println(String.format("sequential sort took: %d ms", timer.getTotalTime()));
    }

    public static void sortParallel() {
        List<String> values = new ArrayList<>(MAX);
        IntStream.range(0, MAX).forEach(i -> {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        });

        timer.start();
        System.out.println(values.parallelStream().sorted().count());
        timer.end();

        System.out.println(String.format("parallel sort took: %d ms", timer.getTotalTime()));
    }

    public static void main(String[] args) {
        for (int x=0; x < 10; x++) {
            sortSequential();
            sortParallel();
        }
    }
}
