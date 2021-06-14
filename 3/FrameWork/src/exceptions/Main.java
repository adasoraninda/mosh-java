package exceptions;

public class Main {
    public static void main(String[] args) {

        try {
            ExceptionsDemo.show();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        // String str = null;
        // try {
        // System.out.println(str.toUpperCase());
        // } catch (NullPointerException e) {
        // System.out.println("Null value");
        // } finally {
        // System.out.println("finally");
        // }

    }
}
