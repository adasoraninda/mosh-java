package lamdas;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

    public static void show() {
        // List<Integer> list = List.of(1, 2, 3);
        // list.forEach(item -> System.out.println(item));
        // list.forEach(System.out::println);

        List<String> list2 = List.of("a", "b", "c");
        Consumer<String> print = item -> System.out.println(item);
        Consumer<String> printUpperCase = item -> System.out.println(item.toUpperCase());

        list2.forEach(print.andThen(printUpperCase));
        System.out.println();
        print.accept("z");
    }

}
