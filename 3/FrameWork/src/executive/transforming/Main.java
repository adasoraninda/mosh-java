package executive.transforming;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static int toFahrenheit(int celsius) {
        return (int) (celsius * 1.8) + 32;
    }

    public static void main(String[] args) {
        var future = CompletableFuture.supplyAsync(() -> 20);

        future.thenApply(Main::toFahrenheit).thenAccept(f -> System.out.println(f));

        // try {
        // var result = future.thenApply(Main::toFahrenheit).get();
        // System.out.println(result);
        // } catch (InterruptedException | ExecutionException e) {
        // e.printStackTrace();
        // }
    }
}
