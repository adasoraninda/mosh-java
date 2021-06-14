package exceptions;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExceptionsDemo {

    public static void show() throws IOException {
        var account = new Account();
        try {
            account.deposit(100);
        } catch (IOException e) {
            throw e;
        }

    }

    public static void fileReader() {
        try (var reader = new FileReader("file.txt"); var writer = new FileWriter("...");) {
            var value = reader.read();
            new SimpleDateFormat().parse("");
        } catch (IOException | ParseException e) {
            System.out.println("Could not read data.");
        }

    }

}
