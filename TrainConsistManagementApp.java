import java.util.*;
import java.util.function.Predicate;

class GoodsBogie {

    private String id;
    private String type;
    private String cargo;

    public GoodsBogie(String id, String type, String cargo) {
        this.id = id;
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    public void display() {
        System.out.println(id + " | " + type + " | Cargo: " + cargo);
    }
}

class Train {

    private List<GoodsBogie> goods;

    public Train() {
        goods = new ArrayList<>();
    }

    public void addGoodsBogie(GoodsBogie b) {
        goods.add(b);
    }

    public void checkSafety() {

        Predicate<GoodsBogie> safetyRule = b -> {
            if (b.getType().equalsIgnoreCase("Cylindrical"))
                return b.getCargo().equalsIgnoreCase("Liquid");
            if (b.getType().equalsIgnoreCase("Rectangular"))
                return !b.getCargo().equalsIgnoreCase("Liquid");
            return true;
        };

        System.out.println("\n=== Safety Compliance Check ===");

        goods.stream().forEach(b -> {
            if (safetyRule.test(b)) {
                System.out.print("✅ Safe → ");
            } else {
                System.out.print("❌ Unsafe → ");
            }
            b.display();
        });
    }
}

class TrainConsistManagementApp {

    public static void main(String[] args) {

        Train train = new Train();

        train.addGoodsBogie(new GoodsBogie("BG201", "Cylindrical", "Liquid"));
        train.addGoodsBogie(new GoodsBogie("BG202", "Cylindrical", "Coal"));
        train.addGoodsBogie(new GoodsBogie("BG203", "Rectangular", "Coal"));
        train.addGoodsBogie(new GoodsBogie("BG204", "Rectangular", "Liquid"));

        train.checkSafety();
    }
}