package minicase.shop;

import minicase.inventory.Profile;
import minicase.inventory.CaseItem;
import minicase.cases.Case;

public class ShopService {

    public static void BuyAndOpen(Profile user, Case box) {

        double cost = box.getCost();

        // Sprawdzenie czy u¿ytkownika staæ
        if (user.isBroke(cost)) {

            // Zabranie pieniêdzy
            user.delMoney(cost);

            // Otwarcie skrzynki
            CaseItem item = box.open();

            // Dodanie itemu do ekwipunku
            user.addItem(item);

            System.out.println("Otworzy³eœ skrzynkê!");
            System.out.println("Wylosowany item: " + item);

        } else {
            // LIPA
            System.out.println("Brak œrodków!");
            System.out.println("50 lat prac spo³ecznych.");
        }
    }
}