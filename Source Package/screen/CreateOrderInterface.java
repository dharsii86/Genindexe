/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;
import data.CategoryList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

// Test
import data.CustomerList;
import database.AnalysisDB;
import database.ConnectionDB;
import database.CustomerDB;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.DefaultComboBoxModel;
import nf.Customer;

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
    private MenuWindow globalScreen;
    
    
    private JTextField nbSpl;
   
    private JLabel labelNbSamples,title;
    
    private JPanel posSpl;
    
    private JComboBox analyse,category,espece,custName,custTown;
    
    private JButton validate,cancel;
    
    String[] nameCategory = {""};
    String[] nameAnalysis = {""};
    String[] nameSpecies = {""};
    String[] tabCustTown = {""};
    String[] tabCustName = {""};
    

    public CreateOrderInterface(MenuWindow jf) {
        globalScreen = jf;
        /*Initialisation*/
        title = new JLabel("Order Creation",SwingConstants.CENTER);
        this.setBackground(Color.white);
        title.setFont(title.getFont().deriveFont(24.0f));
        labelNbSamples = new JLabel("Number of Samples");
        //labelNbSamples.setPreferredSize(new Dimension(60,10));
        

        // Creation of the category combo box
        Set<String> cat = CategoryList.getCategory().keySet();
        nameCategory = cat.toArray(new String[cat.size()]);
        category = new JComboBox(nameCategory);
        
        // Creation of species combo box
        String selected = (String) category.getSelectedItem();
        nameSpecies = CategoryList.getListSpecieFromCat(selected);
        espece = new JComboBox(nameSpecies);
        
        // Creation of analysis combobox
        selected= (String) espece.getSelectedItem();
        nameAnalysis= AnalysisDB.getAnalysis(selected);
        analyse = new JComboBox(nameAnalysis);  
        
        // Creation of the customer town combo box
        tabCustTown = CustomerDB.getCustomerTown();
        custTown = new JComboBox(tabCustTown);
        custTown.setSelectedIndex(0);
        
        // Creation of the customer name combo box
        selected= (String) custTown.getSelectedItem();     
        tabCustName = CustomerDB.getCustomerName(selected);
        custName = new JComboBox(tabCustName);
        
        
        /*
            Adding the action listeners for the combo boxes
        */
        
        // Listener for category selection
        category.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) category.getSelectedItem();
                nameSpecies = CategoryList.getListSpecieFromCat(selected);
                DefaultComboBoxModel catModel = new DefaultComboBoxModel(nameSpecies);
                espece.setModel( catModel );

                // If a specie exist for this cat, display the list of possible analysis
                if(nameSpecies.length > 0){
                    selected= (String) espece.getSelectedItem();
                    nameAnalysis= AnalysisDB.getAnalysis(selected);
                }            
                else{ nameAnalysis = new String[0]; } 

                DefaultComboBoxModel anaModel = new DefaultComboBoxModel(nameAnalysis);
                analyse.setModel( anaModel ); 
            }
        });
       
       
        // Listener for Analysis selection    
        espece.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Specie selected");
                String selected= (String) espece.getSelectedItem();
                nameAnalysis= AnalysisDB.getAnalysis(selected);

                DefaultComboBoxModel anaModel = new DefaultComboBoxModel(nameAnalysis);
                analyse.setModel( anaModel );
            }
        });
       
       // Listener for Town selection    
       custTown.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e) {

            String selected = (String) custTown.getSelectedItem();
            tabCustName = CustomerDB.getCustomerName(selected);
            
            DefaultComboBoxModel custModel = new DefaultComboBoxModel(tabCustName);
            custName.setModel( custModel );

             }
        });
 
        validate = new JButton("Validate");
        validate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nb = nbSpl.getText();
                
                String name = (String) custName.getSelectedItem();
                String town = (String) custTown.getSelectedItem();
                String ana = (String) analyse.getSelectedItem();
                String spec = (String) espece.getSelectedItem();
                System.out.println("name : "+name);
                System.out.println("town : "+town);
                System.out.println("ana : "+ana);
                System.out.println("spec : "+spec);
                
                if(!nb.equals("")){
                    int nbS = Integer.parseInt(nb);
                    if(name.equals("")){
                        globalScreen.setSouth("You need to choose a customer");
                    }else if(ana.equals("")){
                        globalScreen.setSouth("You need to choose an analysis");
                    }else{
                        // d'abord Créer l'order
                        Customer cust = CustomerList.getCustomer(name,(String)  custTown.getSelectedItem());
                        ArrayList res = (ArrayList)ConnectionDB.requestStatic("show table status like 'order'").get(0);
                        int IDorder = Integer.parseInt((String) res.get(10));
                        ConnectionDB.requestUpdateCaseSensitive("INSERT INTO `order`(`Order_Status`, `Analysis_Name`, `Customer_Login`) VALUES ('Standby','"+ana+"','"+name+town+"');");
                        //création des samples
                        for(int i = 1; i <= nbS; i++){
                            ConnectionDB.requestUpdateCaseSensitive("INSERT INTO `sample`( `Specie_Name`, `Order_Id`, `state`) VALUES ('"+spec+"','"+IDorder+"','1');");
                        } 
                    }
                }else{
                    globalScreen.setSouth("You need to enter the number of samples");
                }
                
            }
        });
        cancel = new JButton("Cancel");
        nbSpl = new JTextField();
        nbSpl.setColumns(5);
        
        /*Modification Panels*/
        this.setLayout(new GridBagLayout());
       
        int gbX = 2;
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
        gbTitle.gridx = gbX + -1;
        gbTitle.gridy = gbY + 0;
        gbTitle.gridwidth = 6;
        
        JPanel panSStitle = new JPanel();
        panSStitle.setPreferredSize(new Dimension(60,100));
        panSStitle.setBackground(Color.white);
        GridBagConstraints gbpan1 = new GridBagConstraints();
        gbpan1.gridx = gbX + 2;
        gbpan1.gridy = gbY + 3;
        gbpan1.weightx = 1;
        
        JPanel panleft = new JPanel();
        panleft.setPreferredSize(new Dimension(60,100));
        panleft.setBackground(Color.white);
        GridBagConstraints gbpanleft = new GridBagConstraints();
        gbpanleft.gridx = gbX + -2;
        gbpanleft.gridy = gbY ;
        gbpanleft.weightx = 1;
        
        JPanel panright = new JPanel();
        panright.setPreferredSize(new Dimension(60,100));
        panright.setBackground(Color.white);
        GridBagConstraints gbpanright = new GridBagConstraints();
        gbpanright.gridx = gbX + 6;
        gbpanright.gridy = gbY;
        gbpanright.weightx = 1;
        
        
        
        JPanel panSSBox = new JPanel();
        panSSBox.setPreferredSize(new Dimension(0,80));
        panSSBox.setBackground(Color.white);
        GridBagConstraints gbpan2 = new GridBagConstraints();
        gbpan2.gridx = gbX + 1;
        gbpan2.gridy = gbY + 5;
        gbpan2.gridwidth = 1;
        
        
        //-------//ici ajouter un panel vide pour avoir une meilleur taille
        posSpl = new JPanel();
        posSpl.setLayout(new FlowLayout());
        posSpl.setBackground(Color.white);
        
        //-------
        gbNbSpl.gridx = gbX + -1;
        gbNbSpl.gridy = gbY + 5;
        gbNbSpl.gridwidth = 6;
        
        posSpl.add(labelNbSamples);
        posSpl.add(nbSpl);
        //-------
        gbCat.gridx = gbX + -1;
        gbCat.gridy = gbY + 3;
        gbCat.anchor = GridBagConstraints.LINE_START;
        GridBagConstraints gbCatLab = (GridBagConstraints)gbCat.clone();
        gbCatLab.anchor = GridBagConstraints.LINE_END;
        gbCatLab.gridx = gbCat.gridx -1;
        gbCatLab.insets = new Insets(0, 0, 0, 10);
        //-------
        gbSpe.gridx = gbX + -1;
        gbSpe.gridy = gbY + 4;
        gbSpe.anchor = GridBagConstraints.LINE_START;
        GridBagConstraints gbSpeLab = (GridBagConstraints)gbSpe.clone();
        gbSpeLab.anchor = GridBagConstraints.LINE_END;
        gbSpeLab.gridx = gbSpe.gridx -1;
        gbSpeLab.insets = new Insets(0, 0, 0, 10);
        //-------
        gbAna.gridx = gbX + -1;
        gbAna.gridy = gbY + 5;
        gbAna.anchor = GridBagConstraints.LINE_START;
        GridBagConstraints gbAnaLab = (GridBagConstraints)gbAna.clone();
        gbAnaLab.anchor = GridBagConstraints.LINE_END;
        gbAnaLab.gridx = gbAna.gridx -1;
        gbAnaLab.insets = new Insets(0, 0, 0, 10);
        //-------
        gbCusTown.gridx = gbX + 3;
        gbCusTown.gridy = gbY + 3;
        gbCusTown.anchor = GridBagConstraints.LINE_START;
        GridBagConstraints gbCusTownLab = (GridBagConstraints)gbCusTown.clone();
        gbCusTownLab.anchor = GridBagConstraints.LINE_END;
        gbCusTownLab.gridx = gbCusTown.gridx -1;
        gbCusTownLab.insets = new Insets(0, 0, 0, 10);
        //-------
        gbCusName.gridx = gbCusTown.gridx;
        gbCusName.gridy = gbCusTown.gridy+1;
        gbCusName.anchor = GridBagConstraints.LINE_START;
        GridBagConstraints gbCusNameLab = (GridBagConstraints)gbCusName.clone();
        gbCusNameLab.anchor = GridBagConstraints.LINE_END;
        gbCusNameLab.gridx = gbCusName.gridx -1;
        gbCusNameLab.insets = new Insets(0, 0, 0, 10);
        //-------
        gbValid.gridx = gbX +2;
        gbValid.gridy = gbY + 7;
        gbValid.anchor = GridBagConstraints.CENTER;
        //-------
        
       
        /*Ajout dans les Panels*/
        this.add(title,gbTitle);
        this.add(posSpl,gbNbSpl);
        this.add(category,gbCat);
        this.add(espece,gbSpe);
        this.add(analyse,gbAna);
        this.add(new JLabel("Species category : "),gbCatLab);
        this.add(new JLabel("Species : "),gbSpeLab);
        this.add(new JLabel("Type of analysis : "),gbAnaLab);
        
        this.add(custTown,gbCusTown);
        this.add(custName,gbCusName);
        this.add(new JLabel("Town of the company : "),gbCusTownLab);
        this.add(new JLabel("Company name : "),gbCusNameLab);
        
        this.add(panSStitle,gbpan1);
        this.add(panSSBox,gbpan2);
        this.add(panright,gbpanright);
        this.add(panleft,gbpanleft);
        this.add(validate,gbValid);
        //this.add(title,gbCancel);
        
         
        
        /*Gestion de la page*/
        this.setBackground(Color.GRAY);
        
        this.setPreferredSize(new Dimension(200, 100));
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
            //tab = S;
            this.setVisible(false);
            this.setVisible(true);
    }
    
    public void setAbleSpecies( String[] S){
            //nameSpecies = S;
            this.setVisible(false);
            this.setVisible(true);
    }

    }

