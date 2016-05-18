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
public class MWValidator extends MenuWindow {

    
    public MWValidator(String name, String lastName, String Statut) {
        super(name, lastName, Statut);
    }
    
    private JMenu menuCreation;
    private JMenuItem homePage;
    private JMenuItem createScrapieTest;
    private JMenuItem researchOrder;
    
    @Override
    public void setMenu() {
        
        // Create the menu bar.
        menuBar = new JMenuBar();
        
        //Build the Customer's menu.
        menuCreation = new JMenu("Research");
        
        // Build the Home page Menu
        homePage = new JMenuItem("Home Page");
        homePage.setToolTipText("Return to the Homepage.");
        homePage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                delMiddle();
            }
        });
        menuBar.add(homePage);
        
        createScrapieTest = new JMenuItem("Scrapie Test");
        createScrapieTest.setToolTipText("Create a Scrapie Test.");
        createScrapieTest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                launchScrapieTest();
            }
        });
        menuCreation.add(createScrapieTest);
        
        researchOrder = new JMenuItem("Research Order");
        researchOrder.setToolTipText("Research an order.");
        researchOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                launchResearchOrder();
            }
        });
        menuCreation.add(researchOrder);
        
        menuBar.add(menuCreation);
    }
    
    private void launchResearchOrder() {
        try {
            middle.remove(0);
        } catch (ArrayIndexOutOfBoundsException exc) {
        }
        OrderResearch aux = new OrderResearch(this);
        aux.setBackground(Color.white);
        middle.add(aux, BorderLayout.CENTER);
        refreshMid();
    }
    
    private void launchScrapieTest() {
        try {
            middle.remove(0);
        } catch (ArrayIndexOutOfBoundsException exc) {
        }
        ScrapieTestInterface aux = new ScrapieTestInterface(this);
        aux.setBackground(Color.white);
        middle.add(aux, BorderLayout.CENTER);
        refreshMid();
    }
    
    
}
