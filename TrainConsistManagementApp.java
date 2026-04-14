import java.util.LinkedHashSet;
import java.util.Set;

class Bogie {

    private String id;
    private String type;

    public Bogie(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void display() {
        System.out.println(id + " | " + type);
    }
}

class Train {

    private String trainName;
    private Set<String> bogieIds;
    private LinkedHashSet<Bogie> bogies;

    public Train(String trainName) {
        this.trainName = trainName;
        this.bogieIds = new LinkedHashSet<>();
        this.bogies = new LinkedHashSet<>();
    }

    public void addBogie(Bogie bogie) {

        if (bogieIds.contains(bogie.getId())) {
            System.out.println("❌ Duplicate Bogie ID not allowed: " + bogie.getId());
            return;
        }

        bogieIds.add(bogie.getId());
        bogies.add(bogie);

        System.out.println("✅ Added Bogie: " + bogie.getId());
    }

    public void displayConsist() {

        System.out.println("\n=== Train Consist (Insertion Order) ===");

        for (Bogie b : bogies) {
            b.display();
        }
    }
}

class TrainConsistManagementApp {

    public static void main(String[] args) {

        Train train = new Train("Express Line");

        train.addBogie(new Bogie("BG101", "Sleeper"));
        train.addBogie(new Bogie("BG105", "AC Chair"));
        train.addBogie(new Bogie("BG103", "First Class"));
        train.addBogie(new Bogie("BG101", "Duplicate"));

        train.displayConsist();
    }
}