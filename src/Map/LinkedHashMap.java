package Map;

import java.util.Map;

public class LinkedHashMap {
    public static void main(String[] args) {

        // Create LinkedHashMap
        Map<Integer, String> map =
                new java.util.LinkedHashMap<>();

        // Add ID and Name
        map.put(101, "Pradeep");
        map.put(102, "Yash");
        map.put(103, "Aman");
        map.put(104, "Rahul");

        // Print Map
        System.out.println(map);

        // Get value
        System.out.println(map.get(101));

        // Check key and value
        System.out.println(map.containsKey(102));
        System.out.println(map.containsValue("Aman"));

        // Update value
        map.put(102, "Rohit");

        // Print using Lambda Expression
        map.forEach((id, name) -> {
            System.out.println("ID: " + id + ", Name: " + name);
        });

        // Remove entry
        map.remove(104);

        // Print updated Map
        System.out.println(map);
    }
}