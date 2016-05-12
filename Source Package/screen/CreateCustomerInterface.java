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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import nf.Customer;

/**
 * Manage the interface for the creation of a customer done by the secretary.
 *
 * @author SCRUM Group 2.
 */
public class CreateCustomerInterface extends JLabel {

    // Panels
    private JPanel centre;

    // Text fields
    private JTextField name;
    private JTextField town;

    // Labels
    private JLabel nameLabel;
    private JLabel townLabel;
    private JLabel titleLabel;
    private JLabel pan;

    // Buttons
    private JButton validateButton;

    private MenuWindow globalScreen;

    public CreateCustomerInterface(MenuWindow screen) {

        // penser a choisir le nom dans le menu
        globalScreen = screen;

        // Initialisation of the panels
        centre = new JPanel();

        // Initialisation of the labels
        titleLabel = new JLabel("CUSTOMER CREATION", SwingConstants.CENTER);
        titleLabel.setFont(titleLabel.getFont().deriveFont(24.0f));
        nameLabel = new JLabel("Name");
        nameLabel.setSize(50, 20);
        townLabel = new JLabel("Place");
        townLabel.setSize(50, 20);

        // Initialisation of the buttons
        validateButton = new JButton("Validate");
        validateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                boolean ok;
                Customer cust;

                if (!(name.getText().equals("") || town.getText().equals(""))) {

                    cust = new Customer(name.getText(), town.getText());

                    CustomerDB custDB = new CustomerDB();
                    ok = custDB.addCustomer(cust);

                    if (ok) {
                        globalScreen.setSouth("The customer: "+name.getText()+" / "+town.getText()+" has been created");
                        close();
                    } else if (!ok) {
                        globalScreen.setSouth("The customer : "+name.getText()+" / "+town.getText()+" already exists.");
                    }

                } else {
                    globalScreen.setSouth("A field is empty.");
                }
                
            }
        });
        
        // Initialisation of the text fields
        name = new JTextField();
        name.setPreferredSize(new Dimension(200, 24));
        name.setToolTipText("Enter the name of the company.");
        town = new JTextField();
        town.setPreferredSize(new Dimension(200, 24));
        town.setToolTipText("Enter the town where the city is based.");

        // Panels modification
        centre.setLayout(new GridBagLayout());

        GridBagConstraints gbNameLab = new GridBagConstraints();
        gbNameLab.gridx = 0;
        gbNameLab.gridy = 2;
        gbNameLab.insets = new Insets(0, 0, 0, 10);

        GridBagConstraints gbName = new GridBagConstraints();
        gbName.gridx = 1;
        gbName.gridy = 2;

        GridBagConstraints gbTownLab = new GridBagConstraints();
        gbTownLab.gridx = 0;
        gbTownLab.gridy = 3;
        gbTownLab.insets = new Insets(0, 0, 0, 10);

        GridBagConstraints gbTown = new GridBagConstraints();
        gbTown.gridx = 1;
        gbTown.gridy = 3;

        GridBagConstraints gbVal = new GridBagConstraints();
        gbVal.gridx = 0;
        gbVal.gridy = 4;
        gbVal.gridwidth = 2;

        GridBagConstraints gbTitle = new GridBagConstraints();
        gbTitle.gridx = 0;
        gbTitle.gridy = 0;
        gbTitle.gridwidth = 2;

        GridBagConstraints gbUnderTitle = new GridBagConstraints();
        gbUnderTitle.gridx = 0;
        gbUnderTitle.gridy = 1;
        gbUnderTitle.gridwidth = 2;
        JLabel underTitle = new JLabel();
        underTitle.setOpaque(true);
        underTitle.setBackground(Color.WHITE);
        underTitle.setPreferredSize(new Dimension(100, 30));
        
        GridBagConstraints gbpan2 = new GridBagConstraints();
        gbpan2.gridx = 0;
        gbpan2.gridy = 4;
        pan = new JLabel();
        pan.setOpaque(true);
        pan.setBackground(Color.WHITE);
        pan.setPreferredSize(new Dimension(100, 50));

        // Insertions
        centre.setOpaque(true);
        centre.setBackground(Color.WHITE);
        centre.add(underTitle, gbUnderTitle);
        centre.add(nameLabel, gbNameLab);
        centre.add(name, gbName);
        centre.add(townLabel, gbTownLab);
        centre.add(town, gbTown);
        centre.add(pan, gbpan2);
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

    public String getCustomerPlace() {
        return town.getName();
    }

    public void setCustomerPlace(String town) {
        this.town.setName(town);
    }

    private void close() {
        try {
            globalScreen.delMiddle();
        } catch (NullPointerException ex) {
            System.out.println("Ligne 145");
        }
    }

}
