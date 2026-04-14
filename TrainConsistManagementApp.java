import java.util.HashMap;
import java.util.Map;

class Bogie {

    private String id;
    private String type;
    private int capacity;

    public Bogie(String id, String type, int capacity) {
        this.id = id;
        this.type = type;
        this.capacity = capacity;
    }

    public String getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void display() {
        System.out.println(id + " | " + type + " | Capacity: " + capacity);
    }
}

class Train {

    private String trainName;
    private Map<String, Bogie> bogieMap;

    public Train(String trainName) {
        this.trainName = trainName;
        this.bogieMap = new HashMap<>();
    }

    public void addBogie(Bogie bogie) {

        if (bogieMap.containsKey(bogie.getId())) {
            System.out.println("❌ Duplicate Bogie ID not allowed: " + bogie.getId());
            return;
        }

        bogieMap.put(bogie.getId(), bogie);
        System.out.println("✅ Added Bogie: " + bogie.getId());
    }

    public void displayConsist() {

        System.out.println("\n=== Train Consist ===");

        for (Bogie b : bogieMap.values()) {
            b.display();
        }
    }

    public void displayCapacity(String id) {

        if (bogieMap.containsKey(id)) {
            System.out.println("Capacity of " + id + ": " + bogieMap.get(id).getCapacity());
        } else {
            System.out.println("❌ Bogie not found: " + id);
        }
    }
}

class TrainConsistManagementApp {

    public static void main(String[] args) {

        Train train = new Train("Express Line");

        train.addBogie(new Bogie("BG101", "Sleeper", 72));
        train.addBogie(new Bogie("BG102", "AC Chair", 60));
        train.addBogie(new Bogie("BG103", "Goods Rectangular", 100));
        train.addBogie(new Bogie("BG101", "Duplicate", 50));

        train.displayConsist();

        train.displayCapacity("BG102");
        train.displayCapacity("BG999");
    }
}