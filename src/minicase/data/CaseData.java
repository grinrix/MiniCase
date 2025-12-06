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
        //RANGA RARE:
        Item goldenduck = new Item("Golden Duck",Rarity.RARE, 12.99);
        //RANGA LEGENDARY:
        Item megaknight = new Item("MEGA KNIGHT",Rarity.LEGENDARY, 999.99);


        //SKRZYNKI:

        // Skrzynka nr.01: normal case
        List<CaseItem> normalCase_drops = new ArrayList<>();
        normalCase_drops.add(skibidi);
        normalCase_drops.add(goldenduck);
        normalCase_drops.add(megaknight);

        Case normalCase = new Case("Normal Case", 2.50, normalCase_drops);
        caseList.add(normalCase);

        return caseList;
    }

}
