/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Angscrum
 */
public class CreateOrderInterface extends JPanel{
    
    /**
    * Interface for the addition of a customer done by the secretary
    *
    * @author Angscrum
    */
    private JFrame globalScreen;
    
    
    private JTextField nbSpl;
   
    private JLabel labelNbSamples,title;
    
    private JComboBox analyse,category,espece,custName,custTown;
    
    private JButton validate,cancel;
    
    String[] nameCategory = {"Animal", "Animal2"};
    String[] nameAnalysis = {"Analysis"};
    String[] nameSpecies = {"Species"};
    String[] nameClient = {"Client"};
    

    public CreateOrderInterface(JFrame jf) {
        globalScreen = jf;
        /*Initialisation*/
        title = new JLabel("Order Creation",SwingConstants.CENTER);
        this.setBackground(Color.white);
        title.setFont(title.getFont().deriveFont(24.0f));
        labelNbSamples = new JLabel("Number of Samples");
        labelNbSamples.setPreferredSize(new Dimension(300,10));
        
        analyse = new JComboBox(nameAnalysis);
        category = new JComboBox(nameCategory);
        espece = new JComboBox(nameSpecies);
        custName = new JComboBox(nameClient);
        custTown = new JComboBox(nameClient);
        
        custName.setEditable(true);
        custTown.setEditable(true);
        
        
        
        validate = new JButton("Validate");
        cancel = new JButton("Cancel");
        nbSpl = new JTextField();
        nbSpl.setColumns(5);
        
        /*Modification Panels*/
        this.setLayout(new GridBagLayout());
       
        int gbX = 1;
        int gbY = 0;
        
        //Création des contraintes pour le grid bag Layout
        GridBagConstraints gbTitle = new GridBagConstraints();
        GridBagConstraints gbLabelNbSpl = new GridBagConstraints();
        GridBagConstraints gbNbSpl = new GridBagConstraints();
        GridBagConstraints gbCat = new GridBagConstraints();
        GridBagConstraints gbSpe = new GridBagConstraints();
        GridBagConstraints gbAna = new GridBagConstraints();
        GridBagConstraints gbCusTown = new GridBagConstraints();
        GridBagConstraints gbCusName = new GridBagConstraints();
        GridBagConstraints gbValid = new GridBagConstraints();
        GridBagConstraints gbCancel = new GridBagConstraints();
        
        //-------
        gbTitle.gridx = gbX + 1;
        gbTitle.gridy = gbY + 0;
        gbTitle.gridwidth = 2;
        gbTitle.anchor = GridBagConstraints.CENTER;
        
        JPanel panSStitle = new JPanel();
        panSStitle.setPreferredSize(new Dimension(100,150));
        GridBagConstraints gbpan1 = new GridBagConstraints();
        gbpan1.gridx = gbX + 2;
        gbpan1.gridy = gbY + 1;
        
        //-------//ici ajouter un panel vide pour avoir une meilleur taille
        gbLabelNbSpl.gridx = gbX + 0;
        gbLabelNbSpl.gridy = gbY + 2;
        //-------
        gbNbSpl.gridx = gbX + 1;
        gbNbSpl.gridy = gbY + 2;
        //-------
        gbCat.gridx = gbX + -1;
        gbCat.gridy = gbY + 3;
        //-------
        gbSpe.gridx = gbX + 0;
        gbSpe.gridy = gbY + 3;
        //-------
        gbAna.gridx = gbX + 1;
        gbAna.gridy = gbY + 3;
        //-------
        gbCusTown.gridx = gbX + 3;
        gbCusTown.gridy = gbY + 3;
        //-------
        gbCusName.gridx = gbX + 4;
        gbCusName.gridy = gbY + 3;
        //-------
        gbValid.gridx = gbX + 3;
        gbValid.gridy = gbY + 5;
        //-------
        gbCancel.gridx = gbX + 2;
        gbCancel.gridy = gbY + 5;
        
       
        /*Ajout dans les Panels*/
        this.add(title,gbTitle);
        //this.add(labelNbSamples,gbLabelNbSpl);
        //this.add(nbSpl,gbNbSpl);
        this.add(category,gbCat);
        this.add(espece,gbSpe);
        this.add(analyse,gbAna);
        this.add(custTown,gbCusTown);
        this.add(custName,gbCusName);
        this.add(panSStitle,gbpan1);
        //this.add(title,gbValid);
        //this.add(title,gbCancel);
        
        
        
        
        
        /*Gestion de la page*/
        this.setBackground(Color.GRAY);
        
        this.setPreferredSize(new Dimension(300, 220));
        this.setVisible(true);
    }
    
    public void setAbleEspece(String[] S){
            nameSpecies = S;
            this.setVisible(false);
            this.setVisible(true);
    }
    
    public void setAbleAnalysis( String[] S){
            nameAnalysis = S;
            this.setVisible(false);
            this.setVisible(true);
    }
    
    public void setAbleDemandeur( String[] S){
            nameClient = S;
            this.setVisible(false);
            this.setVisible(true);
    }
    
    public void setAbleSpecies( String[] S){
            nameSpecies = S;
            this.setVisible(false);
            this.setVisible(true);
    }

    }

