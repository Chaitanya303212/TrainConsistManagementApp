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

    public void groupByType() {

        Map<String, List<Bogie>> grouped =
                bogies.stream()
                        .collect(Collectors.groupingBy(Bogie::getType));

        System.out.println("\n=== Bogies Grouped by Type ===");

        for (String type : grouped.keySet()) {
            System.out.println("\n" + type + ":");
            for (Bogie b : grouped.get(type)) {
                b.display();
            }
        }
    }
}

class TrainConsistManagementApp {

    public static void main(String[] args) {

        Train train = new Train();

        train.addBogie(new Bogie("BG101", "Sleeper", 72));
        train.addBogie(new Bogie("BG102", "AC Chair", 56));
        train.addBogie(new Bogie("BG103", "Sleeper", 72));
        train.addBogie(new Bogie("BG104", "Goods Rectangular", 100));
        train.addBogie(new Bogie("BG105", "Goods Cylindrical", 120));

        train.groupByType();
    }
}