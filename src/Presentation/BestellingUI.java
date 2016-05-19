package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;         // voor Locale

public class BestellingUI extends JFrame {

    public static void main(String args[]) {
        JFrame frame = new BestellingUI();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Bestelling");
        frame.setContentPane(new Paneel());
        frame.setVisible(true);
    }
}

// Het paneel 
class Paneel extends JPanel {

    private JTextArea BestellingInfo;
    private JButton Gerecht1, Gerecht2, Bestellen;
    private JTextField Gerechtnaam1, Gerechtnaam2;


    public Paneel() {
        // Schakel lay-outmanager uit
        setLayout(null);

        // Maak de tekstvakken
        BestellingInfo = new JTextArea();
        BestellingInfo.setText("");
        BestellingInfo.setEditable(false);

        // Maak de knop
        Gerecht1 = new JButton("Gerecht1");
        Gerecht1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int membershipNr = Integer.parseInt(Gerechtnaam1.getText());
                doFindGerechten(gerechtNummer);
            }
        });
            
        
        Gerecht2 = new JButton("Gerecht2");
        Gerecht2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int membershipNr = Integer.parseInt(Gerechtnaam2.getText());
                doFindGerechten(gerechtNummer);
            }
        });
            
        

        Bestellen = new JButton("Bestellen");
        Bestellen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doFindBestellen();
            
        
        
        
        // Bepaal van alle componenten de plaats en afmeting
        Gerecht1.setBounds(10, 10, 100, 20);
        Gerecht2.setBounds(150, 10, 100, 20);
        Bestellen.setBounds(10, 230, 100, 20);

        BestellingInfo.setBounds(10, 40, 365, 180);
        

        // Voeg de componenten toe aan het paneel
        add(BestellingInfo);
        add(Gerecht1);
        add(Gerecht2);
        add(Bestellen);

    }

    class KnopHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String invoer = BestellingInfo.getText();
            double bevolking = Double.parseDouble(invoer);

            double bevolkingNaEenJaar = bevolking * 1.02;
            // Zorg dat er een decimale punt in de uitvoer komt ipv een komma: gebruik Locale.US
            BestellingInfo.setText(String.format(Locale.US, "%.1f", bevolkingNaEenJaar));

            
        }
    }
}
