import java.util.*;

class PassengerBogie {

    private String id;
    private int capacity;

    public PassengerBogie(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
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

    public void addBogie(PassengerBogie b) {
        bogies.add(b);
    }

    public void bubbleSort() {

        int n = bogies.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (bogies.get(j).getCapacity() < bogies.get(j + 1).getCapacity()) {

                    PassengerBogie temp = bogies.get(j);
                    bogies.set(j, bogies.get(j + 1));
                    bogies.set(j + 1, temp);
                }
            }
        }
    }

    public void display() {

        System.out.println("\n=== Sorted Bogies (Bubble Sort) ===");

        for (PassengerBogie b : bogies) {
            b.display();
        }
    }
}

class TrainConsistManagementApp {

    public static void main(String[] args) {

        Train train = new Train();

        train.addBogie(new PassengerBogie("BG101", 72));
        train.addBogie(new PassengerBogie("BG102", 56));
        train.addBogie(new PassengerBogie("BG103", 40));
        train.addBogie(new PassengerBogie("BG104", 80));

        train.bubbleSort();
        train.display();
    }
}