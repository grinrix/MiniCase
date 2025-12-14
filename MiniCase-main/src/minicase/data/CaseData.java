package minicase.data;

import minicase.domain.*;
import java.util.ArrayList;
import java.util.List;

public class CaseData {
    public static List<Case> loadCase(){
        List<Case> caseList = new ArrayList<>();

        //LISTA PRZEDMIOTÓW:

        //RANGA COMMON:
        Item skibidi = new Item("Skibidi",Rarity.COMMON, 0.99);
        Item TralaleloTralala = new Item("TralaleloTralala", Rarity.COMMON, 1.49);
        Item konstantynopolitańczykowianeczka = new Item("konstantynopolitańczykowianeczka",Rarity.COMMON,6.70);
        //RANGA RARE:
        Item goldenduck = new Item("Golden Duck",Rarity.RARE, 12.99);
        Item salsaipikante = new Item("Salsa, ipikante",Rarity.RARE,23.99);
        Item POMOCY = new Item("POMOCY, AAA",Rarity.RARE,12.32);
        Item melon = new Item("mmmmm me aelon",Rarity.RARE,21.37);
        //RANGA LEGENDARY:
        Item megaknight = new Item("MEGA KNIGHT",Rarity.LEGENDARY, 999.99);
        Item hogrider = new Item("HOG RIDAAA",Rarity.LEGENDARY, 999.99);


        //SKRZYNKI:

        // Skrzynka nr.01: normal case
        List<CaseItem> normalCase_drops = new ArrayList<>();
        normalCase_drops.add(skibidi);
        normalCase_drops.add(goldenduck);
        normalCase_drops.add(megaknight);
        normalCase_drops.add(TralaleloTralala);
        normalCase_drops.add(salsaipikante);
        normalCase_drops.add(POMOCY);

        Case normalCase = new Case("Normal Case", 2.50, normalCase_drops);
        caseList.add(normalCase);

        // Skrzynka nr.02: epic case
        List<CaseItem> epicCase_drops = new ArrayList<>();
        epicCase_drops.add(salsaipikante);
        epicCase_drops.add(goldenduck);
        epicCase_drops.add(melon);
        epicCase_drops.add(megaknight);
        epicCase_drops.add(konstantynopolitańczykowianeczka);
        epicCase_drops.add(hogrider);

        Case epicCase = new Case("Normal Case", 2.50, normalCase_drops);
        caseList.add(normalCase);


        return caseList;
    }

}
