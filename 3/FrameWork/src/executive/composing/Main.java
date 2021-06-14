package executive.composing;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static CompletableFuture<String> getUserEmailAsync() {
        return CompletableFuture.supplyAsync(() -> "email");
    }

    public static CompletableFuture<String> getPlaylistAsync(String email) {
        return CompletableFuture.supplyAsync(() -> "playlist");
    }

    public static void main(String[] args) {
        getUserEmailAsync().thenCompose(Main::getPlaylistAsync)
                .thenAccept(System.out::println);
    }
}
