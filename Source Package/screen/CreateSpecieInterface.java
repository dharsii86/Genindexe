/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import java.awt.Color;
import java.awt.FlowLayout;
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
    
    private JPanel chooseInfo ;
    
    private JLabel title, nameSpe;
    
    private JTextField speciesName;
    
    private JComboBox boxCategory;
   
    private JButton validate;

    public CreateSpecieInterface(MenuWindow globalScreen) {
        super();
        this.globalScreen = globalScreen;
        
        
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
        
        System.out.print("Reueri");
        
        
    }
    
    
    
    
}
