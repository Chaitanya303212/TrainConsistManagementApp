import java.util.*;

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

    public void displaySortedByCapacity() {

        Collections.sort(bogies, new Comparator<Bogie>() {
            public int compare(Bogie b1, Bogie b2) {
                return b2.getCapacity() - b1.getCapacity();
            }
        });

        System.out.println("\n=== Bogies Sorted by Capacity ===");

        for (Bogie b : bogies) {
            b.display();
        }
    }
}

class TrainConsistManagementApp {

    public static void main(String[] args) {

        Train train = new Train();

        train.addBogie(new Bogie("BG101", "Sleeper", 72));
        train.addBogie(new Bogie("BG102", "AC Chair", 56));
        train.addBogie(new Bogie("BG103", "First Class", 40));

        train.displaySortedByCapacity();
    }
}