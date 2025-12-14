package minicase.domain;

public class Item  extends CaseItem{
    public Item(String name, Rarity rarity, double value) {
        super(name,rarity,value);

    }
    @Override
    public String check() {
        return "Item: "+getName()+"["+getRarity()+"] - Cena:"+getValue();
    }
}
