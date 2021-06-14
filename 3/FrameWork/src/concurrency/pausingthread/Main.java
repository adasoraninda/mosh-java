package concurrency.pausingthread;

import concurrency.joiningthread.DownloadFileTask;

public class Main {
    
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        for(var i =0; i<10;i++){
            Thread thread = new Thread(new DownloadFileTask());
            thread.start();
        }
    }

}
