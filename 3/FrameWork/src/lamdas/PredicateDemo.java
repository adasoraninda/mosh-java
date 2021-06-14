package lamdas;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void show() {
        Predicate<String> isLongerThan5 = str -> str.length() > 5;
        isLongerThan5.test("sky");

        Predicate<String> hasLeftBrace = str -> str.startsWith("{");
        Predicate<String> hasRightBrace = str -> str.endsWith("}");

        Predicate<String> hasLeftAndRightBraces = hasLeftBrace.and(hasRightBrace);

        hasLeftAndRightBraces.test("{key:value}");
    }
}
