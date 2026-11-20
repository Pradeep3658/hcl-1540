
package Map;

import java.util.Map;

public class ContainsKey {
    public static void main(String[] args) {

        // Create HashMap
        Map<Integer, String> map = new java.util.HashMap<>();

        // Add ID and Name
        map.put(101, "Pradeep");
        map.put(102, "Rahul");
        map.put(103, "Aman");

        // Check whether key exists
        System.out.println(map.containsKey(101));
        System.out.println(map.containsKey(105));

        // Check whether value exists
        System.out.println(map.containsValue("Rahul"));
        System.out.println(map.containsValue("Yash"));

        // Add new entry
        map.put(104, "Yash");

        // Check after adding value
        System.out.println(map.containsValue("Yash"));

        // Print updated Map
        System.out.println(map);
    }
}
