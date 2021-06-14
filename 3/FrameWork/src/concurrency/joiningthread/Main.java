package concurrency.joiningthread;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new DownloadFileTask());
        thread.start();

        try {
            // join with current thread
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("File is ready to be scanned.");
    }
}
