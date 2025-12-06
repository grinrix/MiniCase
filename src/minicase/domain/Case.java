package minicase.domain;

import java.util.List;
import java.util.Random;
public class Case implements Openable {
    private String name; //nazwa case'a
    private Rarity rarity; //Ranga
    private double cost; //cena
    private List<CaseItem> drops; //lista itemów w case
    private Random random;

    public Case(String name, double cost, List<CaseItem> drops) {
        this.name = name;
        this.cost = cost;
        this.drops = drops;
        this.random = new Random(); //DO ZMIANY NA WŁASNY SYSTEM
    }

    @Override
    public CaseItem open() {
        int index = random.nextInt(drops.size());
        return drops.get(index);
    }

    public String getName() {
        return  name;
    }

    public double getCost() {
        return cost;
    }

    //TODO: dodawanie do ekwipunku, pobieranie z konta pięniędzy, nowa metoda losowania (zależna od rzadkości)
    
}
