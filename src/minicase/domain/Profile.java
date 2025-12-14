package minicase.domain;

import java.util.ArrayList;
import java.util.List;

public class Profile {

    private String username;
    private double balance;
    private List<CaseItem> inventory;

    // Konstruktor
    public Profile(String username, double balance) {
        this.username = username;
        this.balance = Math.max(0, balance); // brak ujemnego balansu
        this.inventory = new ArrayList<>();
    }

    // Dodaje item do ekwipunku
    public void addItem(CaseItem item) {
        if (item != null) {
            inventory.add(item);
        }
    }

    /*
     * UWAGA:
     * true  -> gracza STAĆ na dany wydatek
     * false -> gracza NIE stać
     */
    public boolean isBroke(double amount) {
        return balance >= amount;
    }

    // Zabiera pieniądze (bez zejścia poniżej zera)
    public void delMoney(double amount) {
        if (amount < 0) return;

        balance -= amount;
        if (balance < 0) {
            balance = 0;
        }
    }

    // Dodaje pieniądze (UNLIMITED GEMS IN CLASH ROYALE 😎)
    public void addMoney(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }


    // Wyświetla profil gracza
    public void showProfile() {
        System.out.println("PROFIL GRACZA");
        System.out.println("Gracz: " + username);
        System.out.println("Saldo: " + balance);
        System.out.println("Ekwipunek:");

        if (inventory.isEmpty()) {
            System.out.println("brak przedmiotów");
        } else {
            for (CaseItem item : inventory) {
                System.out.println(" - " + item);
            }
        }
    }

    // Gettery (opcjonalnie, ale przydatne)
    public String getUsername() {
        return username;
    }

    public double getBalance() {
        return balance;
    }

    public List<CaseItem> getInventory() {
        return inventory;
    }
}
