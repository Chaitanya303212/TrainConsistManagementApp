import java.util.regex.*;

class Validator {

    public static boolean validateTrainId(String id) {
        String pattern = "^TRN-\\d{4}$";
        return Pattern.matches(pattern, id);
    }

    public static boolean validateCargoCode(String code) {
        String pattern = "^CG-[A-Z]{3}-\\d{3}$";
        return Pattern.matches(pattern, code);
    }
}

class TrainConsistManagementApp {

    public static void main(String[] args) {

        String trainId1 = "TRN-1234";
        String trainId2 = "TRAIN12";

        String cargo1 = "CG-ABC-123";
        String cargo2 = "CARGO12";

        System.out.println("Train ID " + trainId1 + " → " + Validator.validateTrainId(trainId1));
        System.out.println("Train ID " + trainId2 + " → " + Validator.validateTrainId(trainId2));

        System.out.println("\nCargo Code " + cargo1 + " → " + Validator.validateCargoCode(cargo1));
        System.out.println("Cargo Code " + cargo2 + " → " + Validator.validateCargoCode(cargo2));
    }
}