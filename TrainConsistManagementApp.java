import java.util.*;

class TrainConsistManagementApp {

    public static void main(String[] args) {

        String[] bogieIds = {
                "BG101",
                "BG102",
                "BG103",
                "BG104",
                "BG105"
        };

        Arrays.sort(bogieIds);

        String target = "BG103";

        int left = 0;
        int right = bogieIds.length - 1;
        boolean found = false;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (bogieIds[mid].equals(target)) {
                System.out.println("✅ Found Bogie ID: " + bogieIds[mid]);
                found = true;
                break;
            } else if (bogieIds[mid].compareTo(target) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (!found) {
            System.out.println("❌ Bogie not found: " + target);
        }
    }
}