/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;

/**
 *
 * @author DharSii
 */
public class InterfaceNico extends JLabel {



    private final MenuWindow globalScreen;

    public InterfaceNico(MenuWindow screen) {

        this.setBackground(Color.WHITE);
        this.setLayout(new GridBagLayout());
        globalScreen = screen;

        // Initialisation of the panels
        
        
        // Creation GridBagConstraints

        GridBagConstraints gbNameLab = new GridBagConstraints();
        gbNameLab.gridx = 0;
        gbNameLab.gridy = 2;
        gbNameLab.insets = new Insets(0, 0, 0, 10);
        gbNameLab.anchor = GridBagConstraints.LAST_LINE_END;
        gbNameLab.weightx = 1;
        

       
        // Insertions
        
        this.add(component, constraints);
        
    }



    private void close() {
        try {
            globalScreen.delMiddle();
        } catch (NullPointerException ex) {
            System.out.println("Ligne 145");
        }
    }

}


