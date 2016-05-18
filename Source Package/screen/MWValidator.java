/*
 * Class of the interface of a Validator.
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
 * @author SCRUM Group 2.
 */
public class MWValidator extends MenuWindow {

    // Constructor which allow us to show the name and the status of the user connected
    public MWValidator(String name, String lastName, String Statut) {
        super(name, lastName, Statut);
    }

    // Declarations
    private JMenu menuCreation;
    private JMenu menuResearch;
    private JMenuItem homePage;
    private JMenuItem createScrapieTest;
    private JMenuItem researchOrder;

    // Cretaion of the menu
    @Override
    public void setMenu() {

        // Create the menu bar.
        menuBar = new JMenuBar();

        //Build the Customer's menu.
        menuCreation = new JMenu("Creation");
        menuResearch = new JMenu("Research");

        // Build the Home page Menu
        homePage = new JMenuItem("Home Page");
        homePage.setToolTipText("Return to the Homepage.");
        homePage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                delMiddle();
            }
        });
        menuBar.add(homePage);

        // Build teh menu of the creation of a scrapie test
        createScrapieTest = new JMenuItem("Scrapie Test");
        createScrapieTest.setToolTipText("Create a Scrapie Test.");
        createScrapieTest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                launchScrapieTest();
            }
        });
        menuCreation.add(createScrapieTest);

        // Build the menu of the research of an order
        researchOrder = new JMenuItem("Research Order");
        researchOrder.setToolTipText("Research an order.");
        researchOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                launchResearchOrder();
            }
        });
        menuResearch.add(researchOrder);

        menuBar.add(menuCreation);
        menuBar.add(menuResearch);
    }

    // Launch the research of an order
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

    // Launch the creation of a scrapie test
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
