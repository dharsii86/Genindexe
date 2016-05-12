/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author DharSii
 */
public class CreateSpecieInterface extends JPanel{
    
    private MenuWindow globalScreen;
    
    private String[] category = {"Category", "Category2"};
    
    private JPanel chooseInfo , chooseCategory;
    
    private JLabel title, nameSpe, labCategory;
    
    private JTextField speciesName;
    
    private JComboBox boxCategory;
   
    private JButton validate;

    public CreateSpecieInterface(MenuWindow globalScreen) {
        super();
        this.globalScreen = globalScreen;
        System.out.println("esa");
        
        /*Initialisation*/
        //  title
        title = new JLabel("Species creation",SwingConstants.CENTER);
        this.setBackground(Color.white);
        title.setFont(title.getFont().deriveFont(24.0f));
        
        //  Champ input and name
        nameSpe = new JLabel("Name of the species");
        speciesName = new JTextField();
        chooseInfo = new JPanel();
        chooseInfo.setLayout(new FlowLayout());
        chooseInfo.add(nameSpe);
        chooseInfo.add(speciesName);
        
        //  box Category
        boxCategory = new JComboBox(category);
        
        //  button validation
        validate = new JButton("Create");
        
        //////////////////////////////////
        // Grid Bag Constraints
        GridBagConstraints gbTitle = new GridBagConstraints();
        GridBagConstraints gbInfoSpecie = new GridBagConstraints();
        GridBagConstraints gbBox = new GridBagConstraints();
        GridBagConstraints gbValidate = new GridBagConstraints();
        
        gbTitle.gridx = 0;
        gbTitle.gridy = 0;
        
        gbInfoSpecie.gridx = 0;
        gbInfoSpecie.gridy = 0;
        
        gbBox.gridx = 0;
        gbBox.gridy = 0;
        
        gbValidate.gridx = 0;
        gbValidate.gridy = 0;
        
        
        
        
        
        
        
    }
    
    
    
    
}
