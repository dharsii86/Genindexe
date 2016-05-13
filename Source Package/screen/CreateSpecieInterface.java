/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import data.CategoryList;
import data.SpeciesList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import nf.Specie;
import nf.SpecieCategory;

/**
 *
 * @author DharSii
 */
public class CreateSpecieInterface extends JPanel{
    
    private MenuWindow globalScreen;
    
    private String[] category = {"Category", "Category2"};
    
    private JLabel title, nameSpe, labCategory;
    
    private JTextField speciesName;
    
    private JComboBox boxCategory;
   
    private JButton validate;

    public CreateSpecieInterface(MenuWindow globalScreen) {
        super();
        this.globalScreen = globalScreen;
        this.setLayout(new GridBagLayout());
        
        /*Initialisation*/
        //  title
        title = new JLabel("Species creation",SwingConstants.CENTER);
        this.setBackground(Color.white);
        title.setFont(title.getFont().deriveFont(24.0f));
        
        //  Champ input and name
        nameSpe = new JLabel("Name of the species");
        speciesName = new JTextField();
        speciesName.setPreferredSize(new Dimension(100,20));
        
        //  box Category
        labCategory = new JLabel("The category of the species");
        Set<String> cat = CategoryList.getCategory().keySet();
        String[] nameCategory = cat.toArray(new String[cat.size()]);
        boxCategory = new JComboBox(nameCategory);
        
        
        //  button validation
        validate = new JButton("Create");
        
        validate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) boxCategory.getSelectedItem();
                SpecieCategory cat = CategoryList.getCategory(selected);
                //maintenant on récupère l'espèce et on la créé
                String sSpe = speciesName.getText();
                if(!sSpe.equals("")){
                    Specie spe = new Specie(sSpe);
                    if(SpeciesList.add(spe,cat)){
                        cat.addSpecie(spe);
                        globalScreen.setSouth("The specie : "+spe.getName()+" in the category "+cat.getName()+" has been created.");
                        close();
                    }else{
                        globalScreen.setSouth("The specie : "+spe.getName()+" in the category "+cat.getName()+" Already exist.");
                    }
                }else{
                    globalScreen.setSouth("Enter the name of the species.");
                }
                
            }
        });
        
        
        //////////////////////////////////
        // Grid Bag Constraints
        GridBagConstraints gbTitle = new GridBagConstraints();
        GridBagConstraints gblabSpe = new GridBagConstraints();
        GridBagConstraints gbSpe = new GridBagConstraints();
        GridBagConstraints gblabBox = new GridBagConstraints();
        GridBagConstraints gbBox = new GridBagConstraints();
        GridBagConstraints gbValidate = new GridBagConstraints();
        
        gbTitle.gridx = 0;
        gbTitle.gridy = 0;
        gbTitle.gridwidth = 3;
        
        gblabSpe.gridx = 0;
        gblabSpe.gridy = 4;
        gblabSpe.anchor = GridBagConstraints.LINE_END;
        
        gbSpe.gridx = 2;
        gbSpe.gridy = 4;
        gbSpe.anchor = GridBagConstraints.LINE_START;
        
        gblabBox.gridx = 0;
        gblabBox.gridy = 2;
        gblabBox.anchor = GridBagConstraints.LINE_END;
        
        gbBox.gridx = 2;
        gbBox.gridy = 2;
        gbBox.anchor = GridBagConstraints.LINE_START;
        
        gbValidate.gridx = 0;
        gbValidate.gridy = 6;
        gbValidate.gridwidth = 3;
        
        this.add(title,gbTitle);
        this.add(nameSpe,gblabSpe);
        this.add(speciesName,gbSpe);
        this.add(labCategory,gblabBox);
        this.add(boxCategory,gbBox);
        this.add(validate,gbValidate);
        
        
        //panneau orga
        GridBagConstraints gbpan1 = new GridBagConstraints();
        
        gbpan1.gridx = 1;
        gbpan1.gridy = 1;
        JPanel pos1 = new JPanel();
        pos1.setPreferredSize(new Dimension(50,10));
        pos1.setBackground(Color.white);
        
        GridBagConstraints gbpan2 = new GridBagConstraints();
        
        gbpan2.gridx = 1;
        gbpan2.gridy = 2;
        JPanel pos2 = new JPanel();
        pos2.setPreferredSize(new Dimension(30,10));
        pos2.setBackground(Color.white);
                
        GridBagConstraints gbpan3 = new GridBagConstraints();
        
        gbpan3.gridx = 1;
        gbpan3.gridy = 3;
        JPanel pos3 = new JPanel();
        pos3.setPreferredSize(new Dimension(30,10));
        pos3.setBackground(Color.white);
        
        GridBagConstraints gbpan4 = new GridBagConstraints();
        
        gbpan4.gridx = 1;
        gbpan4.gridy = 5;
        JPanel pos4 = new JPanel();
        pos4.setPreferredSize(new Dimension(50,10));
        pos4.setBackground(Color.white);
        
        this.add(pos1,gbpan1);
        this.add(pos2,gbpan2);
        this.add(pos3,gbpan3);
        this.add(pos4,gbpan4);
        
        
        
        
    }
    
    private void close() {
        try {
            globalScreen.delMiddle();
        } catch (NullPointerException ex) {
            System.out.println("Ligne 145");
        }
    }
    
    
    
}
