package minicase.app;

import minicase.data.CaseData;
import minicase.domain.*;
import minicase.shop.*;

import javax.swing.*;
import java.util.List;
import java.awt.Component;
import java.awt.Color;


public class Main {

    public static void main(String[] args) {

        // dane
        List<Case> sklep = CaseData.loadCase();
        //Case pierwszaSkrzynka = sklep.get(0);
        Profile gracz = new Profile("Skibidi", 67.00);
        Shop shop = new ShopService();

        // okno
        JFrame frame = new JFrame("MiniCase");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // panel
        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // label
        JLabel info = new JLabel("Witaj, " + gracz.getUsername());
        panel.add(info);

        // stan konta
        JLabel balanceLabel = new JLabel("Stan konta: " + String.format("%.2f", gracz.getBalance()));
        balanceLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // opcjonalne wyrównanie
        panel.add(balanceLabel);
        // UNLIMITED GEMS!!!
        JButton addMoneyBtn = new JButton("Doładuj +50.00");
        addMoneyBtn.addActionListener(e -> {
            gracz.addMoney(50.00);
            balanceLabel.setText("Stan konta: " + String.format("%.2f", gracz.getBalance()));
        });
        panel.add(addMoneyBtn);

        // wybór skrzynek
        String[] nazwySkrzynek = new String[sklep.size()];
        for (int i = 0; i < sklep.size(); i++) {
            Case c = sklep.get(i);
            nazwySkrzynek[i] = c.getName() + " (Koszt: " + c.getCost() + ")";
        }
        JComboBox<String> caseSelector = new JComboBox<>(nazwySkrzynek);
        caseSelector.setMaximumSize(new java.awt.Dimension(300, 30)); // żeby nie był za szeroki
        panel.add(caseSelector);

        // przycisk: otwórz skrzynkę
        JButton openCaseBtn = new JButton("Otwórz skrzynkę");
        panel.add(openCaseBtn);

        // przycisk: pokaż profil
        JButton profileBtn = new JButton("Pokaż profil");
        panel.add(profileBtn);

        //// obsługa kliknięcia
        //openCaseBtn.addActionListener(e -> {
        //    shop.buyAndOpen(gracz, pierwszaSkrzynka);
        //});

        profileBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    frame,
                    "Saldo: " + gracz.getBalance() +
                            "\nItemy: " + gracz.getInventory().size()
            );
        });

        DefaultListModel<CaseItem> inventoryModel = new DefaultListModel<>();
        JList<CaseItem> inventoryList = new JList<>(inventoryModel);

        JLabel invTitle = new JLabel("EKWIPUNEK");
        invTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(invTitle);


        panel.add(new JScrollPane(inventoryList));

        openCaseBtn.addActionListener(e -> {
            // Pobieramy indeks wybranej skrzynki z listy rozwijanej
            int selectedIndex = caseSelector.getSelectedIndex();
            Case wybranaSkrzynka = sklep.get(selectedIndex);

            // GAMBLINGGGG
            CaseItem item = shop.buyAndOpen(gracz, wybranaSkrzynka);

            if (item != null) {
                inventoryModel.addElement(item);
                balanceLabel.setText("Stan konta: " + String.format("%.2f", gracz.getBalance()));
            } else {
                // Błąd: brak kasy
                JOptionPane.showMessageDialog(

                        frame,
                        "Brak środków ARGGGG!!!!",
                        "Błąd",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        inventoryList.setCellRenderer(new DefaultListCellRenderer() {

            @Override
            public Component getListCellRendererComponent(
                    JList<?> list,
                    Object value,
                    int index,
                    boolean isSelected,
                    boolean cellHasFocus
            ) {
                JLabel label = (JLabel) super.getListCellRendererComponent(
                        list, value, index, isSelected, cellHasFocus
                );

                CaseItem item = (CaseItem) value;
                label.setText(item.check());

                switch (item.getRarity()) {
                    case LEGENDARY -> label.setForeground(Color.ORANGE);
                    case RARE -> label.setForeground(Color.BLUE);
                    case COMMON -> label.setForeground(Color.GRAY);
                }

                return label;
            }
        });



        frame.setVisible(true);
    }
}