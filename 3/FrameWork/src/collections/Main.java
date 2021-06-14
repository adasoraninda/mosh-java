package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String... args) {
        List<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer("b", "e3"));
        customers.add(new Customer("a", "e2"));
        customers.add(new Customer("c", "e1"));

        System.out.println(customers);
        Collections.sort(customers, new EmailComparator());
        System.out.println(customers);
    }
}
