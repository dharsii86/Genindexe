/**
 * Class containing the creation of the global interface.
 */
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
import javax.swing.JOptionPane;

/**
 *
 * @author SCRUM Group 2.
 */
public abstract class MenuWindow extends JFrame {

    // Declarations 
    protected JLabel middle;
    private final JLabel south;
    private final JLabel north;

    protected JMenuBar menuBar;

    private final JMenu Log;

    private final ImageIcon logoGenindexe;
    private final ImageIcon logo1;

    private final JMenuItem Deco;

    public MenuWindow(String name, String lastName, String Statut) {

        // Management of the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Genindexe");
        this.setSize(600, 600);
        this.setMinimumSize(new Dimension(300, 200));
        this.setMaximumSize(new Dimension(1600, 900));
        this.setResizable(true);
        this.requestFocus();
        setLayout(new BorderLayout());

        // Initialisations
        middle = new JLabel("", JLabel.CENTER);
        middle.setOpaque(true);
        middle.setBackground(Color.WHITE);
        south = new JLabel();
        south.setOpaque(true);
        south.setBackground(Color.WHITE);
        north = new JLabel("The user " + name + " " + lastName + " is connected has a " + Statut + ".");
        north.setOpaque(true);
        north.setBackground(Color.WHITE);
        south.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        middle.setLayout(new BorderLayout());

        // Addition of the panels
        this.add(middle, BorderLayout.CENTER);
        this.add(south, BorderLayout.SOUTH);
        this.add(north, BorderLayout.NORTH);

        // Addition of the logos
        logoGenindexe = new ImageIcon(this.getClass().getResource("../images/logoGenindexe.png"));
        logo1 = new ImageIcon(logoGenindexe.getImage().getScaledInstance(472, 295, Image.SCALE_DEFAULT));
        middle.setIcon(logo1);

        //Management of the logo
        Image logoTeam = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("../images/logoScrum.png"));
        this.setIconImage(logoTeam);

        // Disconnection
        Log = new JMenu("Log");
        Deco = new JMenuItem("Disconnect");
        Deco.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to Diconnect ?", "Warning", dialogButton);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    close();
                    connexionInterface cm = new connexionInterface();
                }
            }
        });

        setMenu();
        Log.add(Deco);
        menuBar.add(Log);
        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    /**
     * Launch the creation of the menu (depending of the user status)
     */
    public abstract void setMenu();

    /**
     * Refresh the mid panel
     */
    protected void refreshMid() {
        middle.setVisible(false);
        middle.setVisible(true);
    }

    /**
     * Refresh the frame
     */
    private void refresh() {
        this.setVisible(false);
        this.setVisible(true);
    }

    /**
     * Cleaning the mid panel
     */
    protected void delMiddle() {
        System.out.println("Debug close in del Middle");
        try {
            middle.remove(0);
        } catch (ArrayIndexOutOfBoundsException exc) {
        }
        refreshMid();

    }

    /**
     * Modification of the information panel
     * @param action The String you want to add in the information panel
     */
    public void setSouth(String action) {
        this.south.setText(action);
    }

    /**
     * Close the frame
     */
    public void close() {
        this.dispose();
    }
}
