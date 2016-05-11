/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Genindex;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Angscrum
 */
public class CreateOrder extends JFrame{
    /**
 * Interface for the addition of a customer done by the secretary
 *
 * @author Angscrum
 */
    private JFrame myFrame;
    
    private JPanel haut,centre,bas,header;
    
    private JTextField name;
   
    private JLabel labelName,titre;
    
    private JComboBox analyse,animal,espece,demandeur;
    
    private JButton validate,cancel;
    
    String[] nameAnimal = {"Animal"};
    String[] nameAnalysis = {"Analysis"};
    String[] nameSpecies = {"Species"};
    String[] nameClient = {"Client"};
    

    public CreateOrder() {
        
        /*Initialisation*/
        myFrame = new JFrame("New order");
        header = new JPanel();
        haut = new JPanel();
        centre = new JPanel();
        bas = new JPanel();
        titre = new JLabel("Order Creation",SwingConstants.CENTER);
        labelName = new JLabel("Number of Samples");
        labelName.setSize(10, 10);
        analyse = new JComboBox(nameAnalysis);
        animal = new JComboBox(nameAnimal);
        espece = new JComboBox(nameSpecies);
        demandeur = new JComboBox(nameClient);
        demandeur.setEditable(true);
        validate = new JButton("Validate");
        cancel = new JButton("Cancel");
        name = new JTextField();
        name.setColumns(5);
        
        /*Modification Panels*/
        header.setLayout(new GridLayout(2,1));
        haut.setLayout(new FlowLayout());
        centre.setLayout(new FlowLayout());
        bas.setLayout(new GridLayout(2,1));
        
        /*Ajout dans les Panels*/
        haut.add(labelName);
        haut.add(name);
        centre.add(animal);
        centre.add(espece);
        centre.add(analyse);
        centre.add(demandeur);
        bas.add(validate);
        bas.add(cancel);
        header.add(titre);
        header.add(haut);
        
        /*Gestion de la page*/
        myFrame.setLayout(new BorderLayout());
        myFrame.add(header,BorderLayout.NORTH);
        myFrame.add(centre,BorderLayout.CENTER);
        myFrame.add(bas,BorderLayout.SOUTH);
        myFrame.getContentPane().setBackground(Color.GRAY);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setPreferredSize(new Dimension(300, 220));
        myFrame.setResizable(false);
        myFrame.setVisible(true);
        myFrame.pack();
    }
    
    public void setAbleEspece(String[] S){
            nameSpecies = S;
            myFrame.setVisible(false);
            myFrame.setVisible(true);
    }
    
    public void setAbleAnalysis( String[] S){
            nameAnalysis = S;
            myFrame.setVisible(false);
            myFrame.setVisible(true);
    }
    
    public void setAbleDemandeur( String[] S){
            nameClient = S;
            myFrame.setVisible(false);
            myFrame.setVisible(true);
    }
    
    public void setAbleSpecies( String[] S){
            nameSpecies = S;
            myFrame.setVisible(false);
            myFrame.setVisible(true);
    }

    }

