/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import database.CustomerDB;
import database.connexionUser;
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
import nf.Customer;

/**
 *
 * @author willa
 */
public class connexionInterface extends JFrame {
    
   private JFrame myFrame; 
   
   private JLabel labelLogin;
   private JLabel labelMdp;
   private JLabel titre;
   private JLabel result;
   
   private JTextField login;
   private JTextField mdp;
   
   private JButton Validate;
   
   private JPanel pan1;
   private JPanel pan2;
   private JPanel pan3;
   private JPanel pan4;
   private JPanel pan5;
    
    public connexionInterface(){
        
        //Initialisations
        myFrame = new JFrame("Genindexe");
        titre = new JLabel("CONNEXION", SwingConstants.CENTER);
        labelLogin = new JLabel("Login : ",SwingConstants.RIGHT);
        labelLogin.setPreferredSize(new Dimension(70, 20));
        labelMdp = new JLabel("Password : ",SwingConstants.RIGHT);
        labelMdp.setPreferredSize(new Dimension(70, 20));
        result = new JLabel();
        result.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        login = new JTextField();
        login.setPreferredSize(new Dimension(200, 24));
        mdp = new JTextField();
        mdp.setPreferredSize(new Dimension(200, 24));
        Validate = new JButton("Validate");
        Validate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                boolean ok;
                connexionUser con = new connexionUser();
                ok = con.checkMDP(login.getText(), mdp.getText());

               if(ok){
                   MenuWindow m = new MenuWindow();
                   myFrame.dispose();
               }else{
                   
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
        pan5.setLayout(new GridLayout(1,1));     
        
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
        myFrame.setLayout(new GridLayout(5,1));
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
    }
    
}
