/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import screen.*;

/**
 *
 * @author willa
 */
public class MWTechnician extends MenuWindow {
    
    
    public MWTechnician(String name, String lastName, String Statut) {
        super(name, lastName, Statut);
    }
    
    private JMenu menuCreation;
    private JMenuItem homePage;
    private JMenuItem createMicroPlate;
    
    @Override
    public void setMenu() {
        // Create the menu bar.
        menuBar = new JMenuBar();
        
        //Build the Customer's menu.
        menuCreation = new JMenu("Creation");
        
        // Build the Home page Menu
        homePage = new JMenuItem("Home Page");
        homePage.setToolTipText("Return to the Homepage.");
        homePage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                delMiddle();
            }
        });
        menuBar.add(homePage);
        
        createMicroPlate = new JMenuItem("MicroPlate");
        createMicroPlate.setToolTipText("Create a new microplate.");
        createMicroPlate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                launchCreateMicroPlate();
            }
        });
        menuCreation.add(createMicroPlate);
        
        menuBar.add(menuCreation);
    }
    
    private void launchCreateMicroPlate() {
        try {
            middle.remove(0);
        } catch (ArrayIndexOutOfBoundsException exc) {
        }
        CreateMicroplateInterface aux = new CreateMicroplateInterface(this);
        aux.setBackground(Color.white);
        middle.add(aux, BorderLayout.CENTER);
        refreshMid();
    }
}
