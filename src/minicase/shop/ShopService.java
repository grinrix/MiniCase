package minicase.shop;

import minicase.domain.Profile;
import minicase.domain.CaseItem;
import minicase.domain.Case;

public class ShopService {

    public static void BuyAndOpen(Profile user, Case box) {

        double cost = box.getCost();

        // Sprawdzenie czy użytkownika stać
        if (user.isBroke(cost)) {

            // Zabranie pieniędzy
            user.delMoney(cost);

            // Otwarcie skrzynki
            CaseItem item = box.open();

            // Dodanie itemu do ekwipunku
            user.addItem(item);

            System.out.println("Otworzyłeś skrzynkę!");
            System.out.println("Wylosowany item: " + item);

        } else {
            // LIPA
            System.out.println("Brak środków!");
            System.out.println("50 lat prac społecznych.");
        }
    }
}
