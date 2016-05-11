package screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Manage the interface of the menu.
 *
 * @author SCRUM Group 2.
 */
public class MenuWindow extends JFrame {

    // Declarations 
    private JLabel middle;
    private JMenuBar menuBar;
    private JMenu menuCust;
    private JMenu menuOrd;
    private JMenuItem itemAddCust;
    private JMenuItem createOrder;

    /**
     * MenuWindow class constructor. Allow to create a window that show a menu.
     */
    public MenuWindow() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Genindexe");
        this.setSize(600, 600);
        this.setMinimumSize(new Dimension(300, 200));
        this.setMaximumSize(new Dimension(1600, 900));
        this.setResizable(true);
        this.requestFocus();
        setLayout(new BorderLayout());
        middle = new JLabel();
        middle.setLayout(new BorderLayout());
        this.add(middle, BorderLayout.CENTER);

        // Create the menu bar.
        menuBar = new JMenuBar();

        // Build the Customer's menu.
        menuCust = new JMenu("Customer");
        menuBar.add(menuCust);
        itemAddCust = new JMenuItem("Create");
        itemAddCust.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                launchCreateCustomer();
            }
        });
        menuCust.add(itemAddCust);

        // Build the Order's menu.
        menuOrd = new JMenu("Order");
        menuBar.add(menuOrd);
        createOrder = new JMenuItem("Create");
        createOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                launchCreateCustomer();
            }
        });
        menuOrd.add(createOrder);
        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    private void refresh() {
        this.setVisible(false);
        this.setVisible(true);
    }

    public void delMiddle() {
        System.out.println("Debug close in del Middle");
        middle.remove(0);
        refresh();

    }

    private void launchCreateCustomer() {
        try {
            middle.remove(0);
        } catch (ArrayIndexOutOfBoundsException exc) {
        }
        CreateCustomerInterface aux = new CreateCustomerInterface(this);
        aux.setBackground(Color.white);
        middle.add(aux, BorderLayout.CENTER);
        refresh();
    }

}
