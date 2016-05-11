package Screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 * Manage the frame which display the impossibility to create a customer.
 *
 * @author SCRUM Group 2.
 */
public class ValidationNotOK {

    // Frames
    private JDialog myFrame;
    private JFrame test;

    // Panels
    private JPanel haut;
    private JPanel centre;
    private JPanel bas;

    // Labels
    private JLabel nameText;
    private JLabel townText;
    private JLabel nameLabel;
    private JLabel townLabel;
    private JLabel error;

    /**
     * ValidationNotOK class constructor.
     */
    public ValidationNotOK(String name, String town, String sError) {

        // Initialisation
        test = new JFrame();
        myFrame = new JDialog(test, "Error", true);

        haut = new JPanel();
        centre = new JPanel();
        bas = new JPanel();

        nameLabel = new JLabel("Name : ");
        nameLabel.setSize(50, 20);
        townLabel = new JLabel("Place : ");
        townLabel.setSize(50, 20);

        String Newligne = System.getProperty("line.separator");
        error = new JLabel(sError);

        nameText = new JLabel();
        nameText.setText(name);
        townText = new JLabel();
        townText.setText(town);

        // Panels modification
        haut.setLayout(new FlowLayout());
        centre.setLayout(new FlowLayout());
        bas.setLayout(new FlowLayout());

        // Labels insertion
        haut.add(nameLabel);
        haut.add(nameText);
        centre.add(townLabel);
        centre.add(townText);
        bas.add(error);

        // Frame management
        myFrame.setLayout(new BorderLayout());
        myFrame.add(haut, BorderLayout.NORTH);
        myFrame.add(centre, BorderLayout.CENTER);
        myFrame.add(bas, BorderLayout.SOUTH);
        myFrame.getContentPane().setBackground(Color.GRAY);
        myFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);
        myFrame.setPreferredSize(new Dimension(600, 120));
        myFrame.setResizable(false);
        myFrame.pack();
        myFrame.setVisible(true);
    }

}
