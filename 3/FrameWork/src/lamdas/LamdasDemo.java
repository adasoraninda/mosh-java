package lamdas;

public class LamdasDemo {

    public static void print(String message) {

    }

    public static void show() {

        greet(new ConsolePrinter());

        greet(new Printer() {
            @Override
            public void print(String message) {
                System.out.println(message);
            }
        });

        greet((String message) -> {
            System.out.println(message);
        });

        greet(message -> System.out.println(message));

        greet(System.out::println);

        greet(LamdasDemo::print);

    }

    public static void greet(Printer printer) {
        printer.print("Hello World");
    }
}
