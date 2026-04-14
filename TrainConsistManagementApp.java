/**
 * UC1: Initialize Train and Display Consist Summary
 * Entry point of Train Consist Management App
 *
 * @author Chaitanya
 * @version 1.0
 */

// Train Class
class Train {

    private String trainName;
    private int totalBogies;

    public Train(String trainName) {
        this.trainName = trainName;
        this.totalBogies = 0;
    }

    public void displaySummary() {
        System.out.println("===== Train Consist Summary =====");
        System.out.println("Train Name: " + trainName);
        System.out.println("Total Bogies: " + totalBogies);
        System.out.println("Status: No bogies attached yet.");
        System.out.println("=================================");
    }
}

// Main Class (as you requested)
class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("🚆 Welcome to Train Consist Management App");

        // Initialize train
        Train train = new Train("Express Line");

        // Display initial consist
        train.displaySummary();
    }
}