# MiniCase (Symulator skrzynek)

Cel: Zaprojektować symulator otwierania skrzynek z systemem ekonomii, ważonym losowaniem przedmiotów (RNG) oraz zarządzaniem ekwipunkiem gracza.

### Lista kontrolna
1. Restrukturyzacja i nowe pakiety [04]
   - Upewnij się, że masz pakiety: `minicase.domain`, `minicase.data`, `minicase.app`.
   - Utwórz nowe pakiety: `minicase.inventory` (dla Profilu) oraz `minicase.shop`. [04]

2. Klasa Profile (Gracz i Ekwipunek) [05][05b]
   - Utwórz klasę `minicase.inventory.Profile`.
   - Pola prywatne: `username` (String), `balance` (double), `inventory` (List<CaseItem>). [05b]
   - Konstruktor: inicjalizacja listy `inventory` (new ArrayList<>). [06]
   - Metody:
     - `addItem(CaseItem item)`: dodaje przedmiot do listy. [03]
     - `isBroke(double amount)`: zwraca true jeśli balans < amount (lub odwrotnie `hasFunds`). [03]
     - `addMoney(double amount)`: dodaje środki. [03]
     - `delMoney(double amount)`: odejmuje środki (zabezpiecz przed zejściem < 0). [05]
     - `showProfile()`: wypisuje dane gracza i pętlą zawartość ekwipunku. [03]

3. Zaawansowana logika RNG w klasie Case [03]
   - Zmodyfikuj metodę `open()` w `minicase.domain.Case`. [03]
   - Logika losowania (1-100):
     - ```<= 80: Szukaj Rarity.COMMON```
     - ```> 80 i <= 99: Szukaj Rarity.RARE```
     - ```> 99: Szukaj Rarity.LEGENDARY ```
   - Implementacja:
     1. Wylosuj liczbę.
     2. Przefiltruj listę `drops`, znajdując przedmioty o wylosowanej rzadkości.
     3. Wylosuj przedmiot z przefiltrowanej listy.
     4. Zabezpieczenie: Jeśli lista pusta, zwróć domyślny item.

4. Serwis Sklepowy (ShopService) [03]
   - Utwórz klasę `minicase.shop.ShopService`.
   - Metoda `buyAndOpen(Profile user, Case box)`. [03]
   - Algorytm:
     1. Sprawdź cenę (`box.getCost()`).
     2. Sprawdź fundusze gracza (`user.isBroke/hasFunds`).
     3. Jeśli stać:
        - `user.delMoney()`
        - `CaseItem item = box.open()`
        - `user.addItem(item)`
        - Wypisz co wypadło.
     4. Jeśli nie stać: Wypisz komunikat błędu.

5. Integracja i Testy (Main) [03][06]
   - W `CaseData` upewnij się, że skrzynki mają itemy różnych rzadkości. [06]
   - W `Main`:
     - Stwórz obiekt `Profile`.
     - Załaduj skrzynki (`CaseData.loadCase()`).
     - Użyj `ShopService` do zakupu kilku skrzynek.
     - Wyświetl wynik końcowy (`user.showProfile()`).
