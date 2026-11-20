
package Map;

import java.util.Map;

public class HashMap {
    public static void main(String[] args) {

        // Create HashMap
        Map<String, Integer> marks = new java.util.HashMap<>();

        // Add student names and marks
        marks.put("Pradeep", 80);
        marks.put("Yash", 85);
        marks.put("Aman", 90);
        marks.put("Rahul", 75);

        // Print HashMap
        System.out.println(marks);

        // Get marks using name
        System.out.println("Pradeep's Marks: " + marks.get("Pradeep"));

        // Check key and value
        System.out.println(marks.containsKey("Yash"));
        System.out.println(marks.containsValue(90));

        // Print all entries using Lambda Expression
        marks.forEach((name, mark) -> {
            System.out.println("Name: " + name);
            System.out.println("Marks: " + mark);
        });

        // Update marks
        marks.put("Pradeep", 95);

        System.out.println("Updated Marks: " + marks.get("Pradeep"));
    }
}
