import java.util.Arrays;

class TrainConsistManagementApp {

    public static void main(String[] args) {

        String[] bogieTypes = {
                "Sleeper",
                "AC Chair",
                "First Class",
                "General",
                "Pantry"
        };

        Arrays.sort(bogieTypes);

        System.out.println("=== Sorted Bogie Types ===");

        for (String type : bogieTypes) {
            System.out.println(type);
        }
    }
}