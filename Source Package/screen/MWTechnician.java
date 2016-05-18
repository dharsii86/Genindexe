/*
 * Class of the interface of a technician.
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
public class MWTechnician extends MenuWindow {

    // Constructor which allow us to show the name and the status of the user connected
    public MWTechnician(String name, String lastName, String Statut) {
        super(name, lastName, Statut);
    }

    // Declarations
    private JMenu menuCreation;
    private JMenuItem homePage;
    private JMenuItem createMicroPlate;

    //Creation of the Menu
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

        // Create a Microplate menu
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

    // Launch the interface of the creation of a customer
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
