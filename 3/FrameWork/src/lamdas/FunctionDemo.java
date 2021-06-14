package lamdas;

import java.util.function.Function;

public class FunctionDemo {
    public static void show() {
        Function<String, Integer> map = str -> str.length();
        var length = map.apply("Sky");
        System.out.println(length);
    }
}
