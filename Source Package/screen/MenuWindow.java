package screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

/**
 * Manage the interface of the menu. nononnonon
 *
 * @author SCRUM Group 2.
 */
public class MenuWindow extends JFrame {

    // Declarations 
    private JLabel middle;
    private JLabel south;

    private JMenuBar menuBar;

    private JMenu menuCust;
    private JMenu menuOrd;
    private JMenu menuCat;
    private JMenu menuCreation;

    private JMenuItem itemAddCust;
    private JMenuItem createOrder;
    private JMenuItem createCat;
    private JMenuItem homePage;
    private JMenuItem createSpecie;

    private ImageIcon logoGenindexe;
    private ImageIcon logo1;

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
        middle = new JLabel("", JLabel.CENTER);
        middle.setOpaque(true);
        middle.setBackground(Color.WHITE);
        south = new JLabel();
        south.setOpaque(true);
        south.setBackground(Color.WHITE);
        south.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        middle.setLayout(new BorderLayout());
        this.add(middle, BorderLayout.CENTER);
        this.add(south, BorderLayout.SOUTH);

        //Ajout logos
        logoGenindexe = new ImageIcon(this.getClass().getResource("../images/logoGenindexe.png"));
        logo1 = new ImageIcon(logoGenindexe.getImage().getScaledInstance(472, 295, Image.SCALE_DEFAULT));
        middle.setIcon(logo1);

        Image logoTeam = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("../images/logoScrum.png"));
        this.setIconImage(logoTeam);

        // Create the menu bar.
        menuBar = new JMenuBar();

        // Build the Home page Menu
        homePage = new JMenuItem("Home Page");
        homePage.setToolTipText("Return to the Homepage.");
        homePage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                delMiddle();
            }
        });
        menuBar.add(homePage);

        //Build the Customer's menu.
        menuCust = new JMenu("Customer");
        menuBar.add(menuCust);
        itemAddCust = new JMenuItem("Create");
        itemAddCust.setToolTipText("Create a new Customer.");
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
        createOrder.setToolTipText("Create a new Order.");
        createOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                launchCreateOrder();
            }
        });
        menuOrd.add(createOrder);

        // Build the Category's menu.
        menuCat = new JMenu("Category");
        menuBar.add(menuCat);
        createCat = new JMenuItem("Create");
        createCat.setToolTipText("Create a new Category.");
        createCat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("test menu");
            }
        });
        menuCat.add(createCat);
        
        // Build the Creation menu.
        menuCreation = new JMenu("Creation");
        menuBar.add(menuCreation);
        createSpecie = new JMenuItem("Specie");
        createSpecie.setToolTipText("Create a new Specie.");
        createSpecie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                launchCreateSpecie();
            }
        });
        menuCreation.add(createSpecie);

        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    private void refresh() {
        this.setVisible(false);
        this.setVisible(true);
    }

    public void delMiddle() {
        System.out.println("Debug close in del Middle");
        try {
            middle.remove(0);
        } catch (ArrayIndexOutOfBoundsException exc) {
        }
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

    private void launchCreateOrder() {
        try {
            middle.remove(0);
        } catch (ArrayIndexOutOfBoundsException exc) {
        }
        CreateOrderInterface aux = new CreateOrderInterface(this);
        aux.setBackground(Color.white);
        middle.add(aux, BorderLayout.CENTER);
        refresh();
    }
    
    private void launchCreateSpecie() {
        try {
            middle.remove(0);
        } catch (ArrayIndexOutOfBoundsException exc) {
        }
        CreateSpecieInterface aux = new CreateSpecieInterface(this);
        aux.setBackground(Color.white);
        middle.add(aux, BorderLayout.CENTER);
        refresh();
    }

    public void setSouth(String action) {
        this.south.setText(action);
    }

}
