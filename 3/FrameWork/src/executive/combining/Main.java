package executive.combining;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        var first = CompletableFuture.supplyAsync(() -> "20USD")
                .thenApply(str -> Integer.parseInt(str.replace("USD", "")));
        var second = CompletableFuture.supplyAsync(() -> 0.9);

        first.thenCombine(second, (price, exchangeRate) -> price * exchangeRate).thenAccept(System.out::println);
    }
}
