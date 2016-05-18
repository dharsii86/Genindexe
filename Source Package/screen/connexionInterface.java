/*
 * Allow the user to connect to the software.
 */
package screen;

import database.ConnectionUser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author SCRUM Group 2.
 */
public class connexionInterface extends JFrame {

    // Declarations
    private JFrame myFrame;

    private final JLabel labelLogin;
    private final JLabel labelMdp;
    private final JLabel titre;
    private JLabel result;

    private JTextField login;
    private JTextField mdp;

    private final JButton Validate;

    private final JPanel pan1;
    private final JPanel pan2;
    private final JPanel pan3;
    private final JPanel pan4;
    private final JPanel pan5;

    public connexionInterface() {

        //Initialisations
        myFrame = new JFrame("Genindexe");
        titre = new JLabel("CONNEXION", SwingConstants.CENTER);
        labelLogin = new JLabel("Login : ", SwingConstants.RIGHT);
        labelLogin.setPreferredSize(new Dimension(70, 20));
        labelMdp = new JLabel("Password : ", SwingConstants.RIGHT);
        labelMdp.setPreferredSize(new Dimension(70, 20));
        result = new JLabel();
        result.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        login = new JTextField();
        login.setPreferredSize(new Dimension(200, 24));
        mdp = new JTextField();
        mdp.setPreferredSize(new Dimension(200, 24));
        Validate = new JButton("Validate");
        Validate.addActionListener(new ActionListener() {
            @SuppressWarnings("ConvertToStringSwitch")
            public void actionPerformed(ActionEvent event) {

                boolean ok;
                ConnectionUser con = new ConnectionUser();
                ok = ConnectionUser.checkMDP(login.getText(), mdp.getText());

                if (ok) {
                    String statut = con.getStatus(login.getText(), mdp.getText());
                    String name = con.getName(login.getText(), mdp.getText());
                    String lastName = con.getLastName(login.getText(), mdp.getText());

                    if (statut.equals("Validator")) {
                        MWValidator mv = new MWValidator(name,lastName,statut);
                    } else if (statut.equals("Technician")) {
                        MWTechnician mt = new MWTechnician(name,lastName,statut);
                    } else if (statut.equals("Secretary")) {
                        MWSecretary ms = new MWSecretary(name,lastName,statut);
                    }
                    myFrame.dispose();
                } else {

                    result.setText("<html><font color = 'Red' >Wrong Login or password</font></html>");
                }

            }
        });
        pan1 = new JPanel();
        pan2 = new JPanel();
        pan3 = new JPanel();
        pan4 = new JPanel();
        pan5 = new JPanel();

        //Mise en place de layout
        pan1.setLayout(new FlowLayout());
        pan2.setLayout(new FlowLayout());
        pan3.setLayout(new FlowLayout());
        pan4.setLayout(new FlowLayout());
        pan5.setLayout(new GridLayout(1, 1));

        //Ajout dans les panels
        pan1.add(titre);
        pan1.setAlignmentX(Component.CENTER_ALIGNMENT);
        pan2.add(labelLogin);
        pan2.add(login);
        pan3.add(labelMdp);
        pan3.add(mdp);
        pan4.add(Validate);
        pan4.setAlignmentX(Component.CENTER_ALIGNMENT);
        pan5.add(result);

        //Ajouts Frame
        myFrame.setLayout(new GridLayout(5, 1));
        myFrame.add(pan1);
        myFrame.add(pan2);
        myFrame.add(pan3);
        myFrame.add(pan4);
        myFrame.add(pan5);

        // Gestion de la JFrame
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.requestFocus();
        Image logoTeam = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("../images/logoScrum.png"));
        myFrame.setIconImage(logoTeam);
        myFrame.pack();
        myFrame.setVisible(true);
        myFrame.setLocationRelativeTo(null);
    }

}
