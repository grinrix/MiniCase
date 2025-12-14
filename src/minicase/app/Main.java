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
        Case pierwszaSkrzynka = sklep.get(0);
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

        // przycisk: otwórz skrzynkę
        JButton openCaseBtn = new JButton("Otwórz skrzynkę");
        panel.add(openCaseBtn);

        // przycisk: pokaż profil
        JButton profileBtn = new JButton("Pokaż profil");
        panel.add(profileBtn);

        // obsługa kliknięcia
        openCaseBtn.addActionListener(e -> {
            shop.buyAndOpen(gracz, pierwszaSkrzynka);
        });

        profileBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    frame,
                    "Saldo: " + gracz.getBalance() +
                            "\nItemy: " + gracz.getInventory().size()
            );
        });

        DefaultListModel<CaseItem> inventoryModel = new DefaultListModel<>();
        JList<CaseItem> inventoryList = new JList<>(inventoryModel);


        panel.add(new JScrollPane(inventoryList));

        openCaseBtn.addActionListener(e -> {

            CaseItem item = shop.buyAndOpen(gracz, pierwszaSkrzynka);

            if (item != null) {
                inventoryModel.addElement(item);
            } else {
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