import java.util.*;
import java.util.stream.*;

class Bogie {

    private String id;
    private String type;
    private int capacity;

    public Bogie(String id, String type, int capacity) {
        this.id = id;
        this.type = type;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }

    public void display() {
        System.out.println(id + " | " + type + " | Capacity: " + capacity);
    }
}

class Train {

    private List<Bogie> bogies;

    public Train() {
        bogies = new ArrayList<>();
    }

    public void addBogie(Bogie b) {
        bogies.add(b);
    }

    public void filterHighCapacity(int minCapacity) {

        System.out.println("\n=== High Capacity Passenger Bogies ===");

        bogies.stream()
                .filter(b -> b.getType().contains("Passenger") || b.getType().contains("Sleeper") || b.getType().contains("AC"))
                .filter(b -> b.getCapacity() >= minCapacity)
                .forEach(Bogie::display);
    }
}

class TrainConsistManagementApp {

    public static void main(String[] args) {

        Train train = new Train();

        train.addBogie(new Bogie("BG101", "Sleeper Passenger", 72));
        train.addBogie(new Bogie("BG102", "AC Chair Passenger", 56));
        train.addBogie(new Bogie("BG103", "First Class Passenger", 40));
        train.addBogie(new Bogie("BG104", "Goods Rectangular", 100));

        train.filterHighCapacity(50);
    }
}