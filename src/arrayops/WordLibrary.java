package arrayops;

import java.util.LinkedHashMap;
import java.util.Map;

public class WordLibrary {

    private static final Map<String, String> library = new LinkedHashMap<>();

    static {
        // Vehicles
        addCombination("Bicycle", "Engine", "Motorcycle");
        addCombination("House", "Wheels", "Camper");
        addCombination("Car", "Electricity", "Electric Car");
        addCombination("Camera", "Drone", "Flying Camera");

        // Science
        addCombination("Water", "Fire", "Steam");
        addCombination("Sand", "Heat", "Glass");
        addCombination("Iron", "Carbon", "Steel");
        addCombination("Copper", "Tin", "Bronze");
        addCombination("Water", "Cold", "Ice");
        addCombination("Ice", "Heat", "Water");
        addCombination("Earth", "Water", "Mud");

        // Food
        addCombination("Flour", "Water", "Dough");
        addCombination("Dough", "Oven", "Bread");
        addCombination("Milk", "Bacteria", "Yogurt");

        // Nature
        addCombination("Sun", "Rain", "Rainbow");
        addCombination("Ocean", "Wind", "Waves");
        addCombination("Wood", "Fire", "Ash");
        addCombination("Clay", "Fire", "Pottery");

        // Fantasy
        addCombination("Horse", "Wings", "Pegasus");
        addCombination("Human", "Machine", "Cyborg");
        addCombination("Human", "Fish", "Mermaid");
        addCombination("Dragon", "Ice", "Ice Dragon");

        // Objects
        addCombination("Paper", "Ink", "Book");
        addCombination("Wood", "Wheels", "Cart");
        addCombination("Stone", "Hammer", "Gravel");
    }

    // Create a unique key for two words
    private static String key(String first, String second) {

        String a = first.trim().toLowerCase();
        String b = second.trim().toLowerCase();

        // Allow combinations in either order
        if (a.compareTo(b) <= 0) {
            return a + "|" + b;
        }

        return b + "|" + a;
    }

    // Add a new combination
    public static void addCombination(
            String first, String second, String result) {

        if (first == null || second == null || result == null ||
            first.trim().isEmpty() ||
            second.trim().isEmpty() ||
            result.trim().isEmpty()) {

            throw new IllegalArgumentException(
                "All three fields must contain text."
            );
        }

        library.put(key(first, second), result.trim());
    }

    // Find a matching combination
    public static String combine(String first, String second) {

        String result = library.get(key(first, second));

        if (result != null) {
            return result;
        }

        return first + second;
    }

    // Return all combinations for display
    public static String getAllCombinations() {

        StringBuilder output = new StringBuilder();

        for (Map.Entry<String, String> entry : library.entrySet()) {

            String[] words = entry.getKey().split("\\|");

            output.append(words[0])
                  .append(" + ")
                  .append(words[1])
                  .append(" = ")
                  .append(entry.getValue())
                  .append("\n");
        }

        return output.toString();
    }
}