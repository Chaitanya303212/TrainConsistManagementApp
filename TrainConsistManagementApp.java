import java.util.*;

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

    private List<Bogie> bogies;

    public Train() {
        bogies = new ArrayList<>();
    }

    public void addBogie(Bogie b) {
        bogies.add(b);
    }

    public void search(String target) {

        for (Bogie b : bogies) {
            if (b.getId().equalsIgnoreCase(target)) {
                System.out.println("✅ Bogie Found:");
                b.display();
                return;
            }
        }

        System.out.println("❌ Bogie not found: " + target);
    }
}

class TrainConsistManagementApp {

    public static void main(String[] args) {

        Train train = new Train();

        train.addBogie(new Bogie("BG101", "Sleeper"));
        train.addBogie(new Bogie("BG102", "AC Chair"));
        train.addBogie(new Bogie("BG103", "First Class"));

        train.search("BG102");
        train.search("BG999");
    }
}