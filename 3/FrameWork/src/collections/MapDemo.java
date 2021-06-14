package collections;

import java.util.Map;
import java.util.HashMap;

public class MapDemo {
    public static void show() {
        var c1 = new Customer("a", "e1");
        var c2 = new Customer("b", "e2");

        Map<String, Customer> map = new HashMap<>();
        map.put(c1.getEmail(), c1);
        map.put(c2.getEmail(), c2);

        var customer = map.get("e1");
        System.out.println(customer);

        for (var entry : map.entrySet()) {
            System.out.println(entry);
        }

        for (var key : map.keySet()) {
            System.out.println(key);
        }

        for (var value : map.values()) {
            System.out.println(value);
        }
    }
}
