package executive.waiting.first;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        var first = CompletableFuture.supplyAsync(() -> {
            LongTask.simulate();
            return 20;
        });

        var second = CompletableFuture.supplyAsync(() -> 20);

        CompletableFuture.anyOf(first, second).thenAccept(System.out::println);
    }
}
