package concurrency.solutions.volatileeg;

public class DownloadStatus {
    private volatile boolean isDone;
    private int totalBytes;
    private Object totalBytesLock = new Object();

    public void incrementTotalBytes() {
        synchronized (totalBytesLock) {
            totalBytes++;
        }
    }

    public boolean isDone() {
        return isDone;
    }

    public void done() {
        this.isDone = true;
    }

    public int getTotalBytes() {
        return totalBytes;
    }

}
