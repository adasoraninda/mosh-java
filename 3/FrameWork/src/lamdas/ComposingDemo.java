package lamdas;

import java.util.function.Function;

public class ComposingDemo {
    public static void show() {

        Function<String, String> replaceColon = str -> str.replace(":", "=");
        Function<String, String> addBraces = str -> "{" + str + "}";

        var result = replaceColon.andThen(addBraces).apply("key:value");

        result = addBraces.compose(replaceColon).apply("key:value");

        System.out.println(result);
    }
}
