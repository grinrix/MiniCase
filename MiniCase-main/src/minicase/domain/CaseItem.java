package minicase.domain;

public abstract class CaseItem {
    private String name;
    private Rarity rarity;
    private double value;

    public CaseItem(String name, Rarity rarity, double value) {
        this.name = name;
        this.rarity = rarity;
        this.value = value;
    }

    public  abstract  String check();

    public String getName() {
        return  name;
    }

    public Rarity getRarity() {
        return  rarity;
    }

    public double getValue() {
        return  value;
    }

}
