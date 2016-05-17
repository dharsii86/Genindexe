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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;


/**
 *
 * @author willa
 */
public abstract class MenuWindow extends JFrame{
    
    // Declarations 
    protected JLabel middle;
    private JLabel south;

    protected JMenuBar menuBar;

    private ImageIcon logoGenindexe;
    private ImageIcon logo1;

    
    public MenuWindow(){
        
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

        setMenu();
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

        
}
