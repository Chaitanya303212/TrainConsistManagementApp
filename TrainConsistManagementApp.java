import java.util.*;
import java.util.stream.*;

class Bogie {

    private int capacity;

    public Bogie(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}

class TrainConsistManagementApp {

    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 1000000; i++) {
            bogies.add(new Bogie((i % 100) + 1));
        }

        long startLoop = System.nanoTime();

        int sumLoop = 0;
        for (Bogie b : bogies) {
            if (b.getCapacity() > 50) {
                sumLoop += b.getCapacity();
            }
        }

        long endLoop = System.nanoTime();

        long startStream = System.nanoTime();

        int sumStream = bogies.stream()
                .filter(b -> b.getCapacity() > 50)
                .mapToInt(Bogie::getCapacity)
                .sum();

        long endStream = System.nanoTime();

        System.out.println("Loop Result: " + sumLoop);
        System.out.println("Stream Result: " + sumStream);

        System.out.println("\nLoop Time: " + (endLoop - startLoop) + " ns");
        System.out.println("Stream Time: " + (endStream - startStream) + " ns");
    }
}