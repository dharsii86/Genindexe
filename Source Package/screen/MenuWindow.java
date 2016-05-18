/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author willa
 */
public abstract class MenuWindow extends JFrame{
    
    // Declarations 
    protected JLabel middle;
    private JLabel south;
    private JLabel north;

    protected JMenuBar menuBar;
    private JMenu Log;

    private ImageIcon logoGenindexe;
    private ImageIcon logo1;
    
    private JMenuItem Deco;

    
    public MenuWindow(String name, String lastName, String Statut){
        
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
        
        
        north = new JLabel("The user "+name+" "+lastName+" is connected has a "+Statut+".");
        north.setOpaque(true);
        north.setBackground(Color.WHITE);
        
        south.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        middle.setLayout(new BorderLayout());
        this.add(middle, BorderLayout.CENTER);
        this.add(south, BorderLayout.SOUTH);
        this.add(north, BorderLayout.NORTH);

        //Ajout logos
        logoGenindexe = new ImageIcon(this.getClass().getResource("../images/logoGenindexe.png"));
        logo1 = new ImageIcon(logoGenindexe.getImage().getScaledInstance(472, 295, Image.SCALE_DEFAULT));
        middle.setIcon(logo1);

        Image logoTeam = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("../images/logoScrum.png"));
        this.setIconImage(logoTeam);
        
        Log = new JMenu("Log");
        Deco = new JMenuItem("Disconnect");
        Deco.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to Diconnect ?","Warning",dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
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
    
    public abstract void setMenu();
    
    protected void refreshMid() {
        middle.setVisible(false);
        middle.setVisible(true);
    }
    
    private void refresh() {
        this.setVisible(false);
        this.setVisible(true);
    }

    protected void delMiddle() {
        System.out.println("Debug close in del Middle");
        try {
            middle.remove(0);
        } catch (ArrayIndexOutOfBoundsException exc) {
        }
        refreshMid();

    }
    
    public void setSouth(String action) {
        this.south.setText(action);
    }

    public void close(){
        this.dispose();
    }
        
}
