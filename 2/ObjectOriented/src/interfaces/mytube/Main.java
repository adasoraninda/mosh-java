package interfaces.mytube;

public class Main {

    public static void main(String[] args) {
        var video = new Video();
        video.setFileName("birthday.mp4");
        video.setTitle("Jennifer's birthday");
        video.setUser(new User("john@domain.com"));

        IVideoEncoder encoder = new VideoEncoder();
        IVideoDatabase database = new VideoDatabase();
        INotificationService emailService = new EmailService();

        var processor = new VideoProcessor(encoder, database, emailService);
        processor.process(video);
    }
}
