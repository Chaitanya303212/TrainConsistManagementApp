import java.util.ArrayList;

/**
 * UC2: Add Passenger Bogies using ArrayList
 * Demonstrates dynamic insertion, removal, and search operations.
 *
 * @author Chaitanya
 * @version 1.0
 */

// Passenger Bogie Class
class PassengerBogie {

    private String type;
    private int capacity;

    public PassengerBogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void display() {
        System.out.println(type + " | Capacity: " + capacity);
    }
}

// Train Class
class Train {

    private String trainName;
    private ArrayList<PassengerBogie> bogies;

    public Train(String trainName) {
        this.trainName = trainName;
        this.bogies = new ArrayList<>();
    }

    // Add bogie
    public void addBogie(PassengerBogie bogie) {
        bogies.add(bogie);
        System.out.println("✅ Added: " + bogie.getType());
    }

    // Remove bogie
    public void removeBogie(String type) {

        for (PassengerBogie b : bogies) {
            if (b.getType().equalsIgnoreCase(type)) {
                bogies.remove(b);
                System.out.println("❌ Removed: " + type);
                return;
            }
        }

        System.out.println("⚠️ Bogie not found: " + type);
    }

    // Check existence
    public void checkBogie(String type) {

        for (PassengerBogie b : bogies) {
            if (b.getType().equalsIgnoreCase(type)) {
                System.out.println("✔️ Bogie exists: " + type);
                return;
            }
        }

        System.out.println("❌ Bogie does not exist: " + type);
    }

    // Display consist
    public void displayConsist() {

        System.out.println("\n=== Train Consist ===");

        if (bogies.isEmpty()) {
            System.out.println("No bogies attached.");
            return;
        }

        for (PassengerBogie b : bogies) {
            b.display();
        }
    }
}

// Main Class
class TrainConsistManagementApp {

    public static void main(String[] args) {

        Train train = new Train("Express Line");

        // Add bogies
        train.addBogie(new PassengerBogie("Sleeper", 72));
        train.addBogie(new PassengerBogie("AC Chair", 60));
        train.addBogie(new PassengerBogie("First Class", 40));

        // Display
        train.displayConsist();

        // Check bogie
        train.checkBogie("Sleeper");

        // Remove bogie
        train.removeBogie("AC Chair");

        // Display again
        train.displayConsist();
    }
}