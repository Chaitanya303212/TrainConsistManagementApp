import java.util.*;

class EmptyTrainException extends Exception {
    public EmptyTrainException(String msg) {
        super(msg);
    }
}

class Bogie {

    private String id;

    public Bogie(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
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

    public void search(String target) throws EmptyTrainException {

        if (bogies.isEmpty()) {
            throw new EmptyTrainException("Train has no bogies to search");
        }

        for (Bogie b : bogies) {
            if (b.getId().equalsIgnoreCase(target)) {
                System.out.println("✅ Found Bogie: " + target);
                return;
            }
        }

        System.out.println("❌ Bogie not found: " + target);
    }
}

class TrainConsistManagementApp {

    public static void main(String[] args) {

        Train train = new Train();

        try {
            train.search("BG101");
        } catch (EmptyTrainException e) {
            System.out.println("⚠️ " + e.getMessage());
        }

        train.addBogie(new Bogie("BG101"));
        train.addBogie(new Bogie("BG102"));

        try {
            train.search("BG102");
        } catch (EmptyTrainException e) {
            System.out.println("⚠️ " + e.getMessage());
        }
    }
}