package screen;

import database.CustomerDB;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import nf.Customer;

/**
 * Manage the interface for the creation of a customer done by the secretary.
 *
 * @author SCRUM Group 2.
 */
public class CreateCategoryInterface extends JLabel {

    // Panels
    private JPanel centre;

    // Text fields
    private JTextField name;
    
    // Text Area
    private JTextArea older;

    // Labels
    private JLabel nameLabel;
    private JLabel titleLabel;
    private JLabel pan1;
    private JLabel pan2;

    // Buttons
    private JButton validateButton;

    private MenuWindow globalScreen;

    public CreateCategoryInterface(MenuWindow screen) {

        // penser a choisir le nom dans le menu
        globalScreen = screen;

        // Initialisation of the panels
        centre = new JPanel();

        // Initialisation of the labels
        titleLabel = new JLabel("ADD A CATEGORY", SwingConstants.CENTER);
        titleLabel.setFont(titleLabel.getFont().deriveFont(24.0f));
        nameLabel = new JLabel("Name of the category");
        nameLabel.setSize(50, 20);

        // Initialisation of the buttons
        validateButton = new JButton("Validate");
        
        // Initialisation of the text fields
        name = new JTextField();
        name.setPreferredSize(new Dimension(200, 24));
        name.setToolTipText("Enter the name of the category.");
        
        // Initialisation des Text area
        older = new JTextArea("Pour le moment il y a rien mais il y aura la liste des catégories déjà existantes");
        older.setLineWrap(true);
        older.setPreferredSize(new Dimension(200, 70));
        older.setToolTipText("Name of the categories already existing.");
        older.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK, (int) 2 ));

        // Panels modification
        centre.setLayout(new GridBagLayout());

        GridBagConstraints gbNameLab = new GridBagConstraints();
        gbNameLab.gridx = 0;
        gbNameLab.gridy = 2;
        gbNameLab.insets = new Insets(0, 0, 0, 10);

        GridBagConstraints gbName = new GridBagConstraints();
        gbName.gridx = 1;
        gbName.gridy = 2;

        GridBagConstraints gbVal = new GridBagConstraints();
        gbVal.gridx = 0;
        gbVal.gridy = 4;
        gbVal.gridwidth = 2;

        GridBagConstraints gbTitle = new GridBagConstraints();
        gbTitle.gridx = 0;
        gbTitle.gridy = 0;
        gbTitle.gridwidth = 2;

        GridBagConstraints gbolder = new GridBagConstraints();
        gbolder.gridx = 1;
        gbolder.gridy = 1;
        
        GridBagConstraints gbpan1 = new GridBagConstraints();
        gbpan1.gridx = 0;
        gbpan1.gridy = 1;
        pan1 = new JLabel();
        pan1.setOpaque(true);
        pan1.setBackground(Color.WHITE);
        pan1.setPreferredSize(new Dimension(100, 100));
        
        GridBagConstraints gbpan2 = new GridBagConstraints();
        gbpan2.gridx = 0;
        gbpan2.gridy = 4;
        pan2 = new JLabel();
        pan2.setOpaque(true);
        pan2.setBackground(Color.WHITE);
        pan2.setPreferredSize(new Dimension(100, 50));

        // Insertions
        centre.setOpaque(true);
        centre.setBackground(Color.WHITE);
        centre.add(pan1, gbpan1);
        centre.add(older, gbolder);
        centre.add(nameLabel, gbNameLab);
        centre.add(name, gbName);
        centre.add(pan2, gbpan2);
        centre.add(validateButton, gbVal);
        centre.add(titleLabel, gbTitle);
        
        // Frame management
        this.setLayout(new BorderLayout());

        this.add(centre, BorderLayout.CENTER);
        this.setBackground(Color.WHITE);
        this.setVisible(true);
    }

    public String getCustomerName() {
        return name.getName();
    }

    public void setCustomerName(String name) {
        this.name.setText(name);
    }

    private void close() {
        try {
            globalScreen.delMiddle();
        } catch (NullPointerException ex) {
            System.out.println("Ligne 145");
        }
    }

}
