package generics;

public class Main {

    public static void main(String... args) {
        var user1 = new User(10);
        var user2 = new User(10);

        if (user1.compareTo(user2) < 0) {
            System.out.println("user1 < user2");
        } else if (user1.compareTo(user2) == 0) {
            System.out.println("user1 == user2");
        } else {
            System.out.println("user1 > user2");
        }
    }

}
