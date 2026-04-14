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
}

class Train {

    private List<Bogie> bogies;

    public Train() {
        bogies = new ArrayList<>();
    }

    public void addBogie(Bogie b) {
        bogies.add(b);
    }

    public void totalCapacity() {

        int total = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, (a, b) -> a + b);

        System.out.println("\n=== Total Seating Capacity ===");
        System.out.println("Total Seats: " + total);
    }
}

class TrainConsistManagementApp {

    public static void main(String[] args) {

        Train train = new Train();

        train.addBogie(new Bogie("BG101", "Sleeper", 72));
        train.addBogie(new Bogie("BG102", "AC Chair", 56));
        train.addBogie(new Bogie("BG103", "First Class", 40));
        train.addBogie(new Bogie("BG104", "Goods Rectangular", 100));

        train.totalCapacity();
    }
}