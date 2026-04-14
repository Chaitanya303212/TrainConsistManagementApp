import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class PassengerBogie {

    private String id;
    private String type;
    private int capacity;

    public PassengerBogie(String id, String type, int capacity) {
        this.id = id;
        this.type = type;
        this.capacity = capacity;
    }

    public String getId() {
        return id;
    }

    public void display() {
        System.out.println(id + " | " + type + " | Capacity: " + capacity);
    }
}

class Train {

    private String trainName;
    private ArrayList<PassengerBogie> bogies;
    private Set<String> bogieIds;

    public Train(String trainName) {
        this.trainName = trainName;
        this.bogies = new ArrayList<>();
        this.bogieIds = new HashSet<>();
    }

    public void addBogie(PassengerBogie bogie) {

        if (bogieIds.contains(bogie.getId())) {
            System.out.println(" Duplicate Bogie ID not allowed: " + bogie.getId());
            return;
        }

        bogies.add(bogie);
        bogieIds.add(bogie.getId());

        System.out.println(" Added Bogie: " + bogie.getId());
    }

    public void displayConsist() {

        System.out.println("\n=== Train Consist ===");

        for (PassengerBogie b : bogies) {
            b.display();
        }
    }
}

class TrainConsistManagementApp {

    public static void main(String[] args) {

        Train train = new Train("Express Line");

        train.addBogie(new PassengerBogie("BG101", "Sleeper", 72));
        train.addBogie(new PassengerBogie("BG102", "AC Chair", 60));
        train.addBogie(new PassengerBogie("BG101", "First Class", 40));

        train.displayConsist();
    }
}