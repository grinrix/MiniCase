package minicase.shop;

import minicase.domain.*;
import minicase.domain.Case;

public class ShopService implements Shop {

    @Override
    public CaseItem buyAndOpen(Profile profile, Case c) {

        if (!profile.isBroke(c.getCost())) {
            System.out.println("BRAK ŚRODKÓW!!!");
            return null;
        }

        profile.delMoney(c.getCost());

        CaseItem item = c.open();
        profile.addItem(item);

        System.out.println("Wylosowano: " + item.check());
        return item;
    }
}
