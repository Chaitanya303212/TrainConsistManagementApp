import java.util.*;

class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String msg) {
        super(msg);
    }
}

class PassengerBogie {

    private String id;
    private int capacity;

    public PassengerBogie(String id, int capacity) throws InvalidCapacityException {

        if (capacity <= 0) {
            throw new InvalidCapacityException("Invalid capacity for " + id);
        }

        this.id = id;
        this.capacity = capacity;
    }

    public void display() {
        System.out.println(id + " | Capacity: " + capacity);
    }
}

class Train {

    private List<PassengerBogie> bogies;

    public Train() {
        bogies = new ArrayList<>();
    }

    public void addBogie(String id, int capacity) {

        try {
            PassengerBogie b = new PassengerBogie(id, capacity);
            bogies.add(b);
            System.out.println("✅ Added Bogie: " + id);
        } catch (InvalidCapacityException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    public void display() {

        System.out.println("\n=== Train Bogies ===");

        for (PassengerBogie b : bogies) {
            b.display();
        }
    }
}

class TrainConsistManagementApp {

    public static void main(String[] args) {

        Train train = new Train();

        train.addBogie("BG101", 72);
        train.addBogie("BG102", 0);
        train.addBogie("BG103", -10);
        train.addBogie("BG104", 56);

        train.display();
    }
}