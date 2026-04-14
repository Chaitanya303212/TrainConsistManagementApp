class UnsafeCargoException extends Exception {
    public UnsafeCargoException(String msg) {
        super(msg);
    }
}

class GoodsBogie {

    private String id;
    private String type;
    private String cargo;

    public GoodsBogie(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public void assignCargo(String cargo) throws UnsafeCargoException {

        if (type.equalsIgnoreCase("Cylindrical") && !cargo.equalsIgnoreCase("Petroleum")) {
            throw new UnsafeCargoException("Cylindrical bogie must carry Petroleum");
        }

        if (type.equalsIgnoreCase("Rectangular") && cargo.equalsIgnoreCase("Petroleum")) {
            throw new UnsafeCargoException("Rectangular bogie cannot carry Petroleum");
        }

        this.cargo = cargo;
        System.out.println("✅ Cargo assigned to " + id);
    }

    public void display() {
        System.out.println(id + " | " + type + " | Cargo: " + cargo);
    }
}

class TrainConsistManagementApp {

    public static void main(String[] args) {

        GoodsBogie b1 = new GoodsBogie("BG201", "Cylindrical");
        GoodsBogie b2 = new GoodsBogie("BG202", "Rectangular");

        try {
            b1.assignCargo("Petroleum");
            b2.assignCargo("Petroleum");
        } catch (UnsafeCargoException e) {
            System.out.println("❌ " + e.getMessage());
        } finally {
            System.out.println("\n=== Final Bogie Status ===");
            b1.display();
            b2.display();
        }
    }
}