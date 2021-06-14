package executive.async2;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        var future = CompletableFuture.supplyAsync(() -> 1);
        future.thenAccept(result -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(result);
        });
        
        // future.thenRunAsync(() -> {
        // Thread.currentThread().getName();
        // System.out.println("Done");
        // });

    }
}
