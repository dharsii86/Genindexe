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
 * @author willa
 */
public class ScrapieTestInterface extends JPanel {

    private final MenuWindow globalScreen;
    
    private String[] specie;
    
    private JLabel labValue, nameSpe, labPosition,title;
    
    private JTextField position, value;
    
    private JComboBox boxCategory;
   
    private final JButton validate;

    public ScrapieTestInterface(final MenuWindow globalScreen) {
        super();
        this.globalScreen = globalScreen;
        this.setLayout(new GridBagLayout());
        
        /*Initialisation*/
        //  title
        title = new JLabel("Scrapie Test creation",SwingConstants.CENTER);
        this.setBackground(Color.white);
        title.setFont(title.getFont().deriveFont(24.0f));
        
        //  box Category
        nameSpe = new JLabel("Name of the species");
        boxCategory = new JComboBox();
        
        // Labels
        labPosition = new JLabel("Position : ");
        position = new JTextField();
        position.setToolTipText("Enter the position of the scrapie test.");
        position.setPreferredSize(new Dimension(200, 24));
        labValue = new JLabel("Value : ");
        value = new JTextField();
        value.setToolTipText("Enter the value of the scrapie test.");
        value.setPreferredSize(new Dimension(200, 24));
        
        //  button validation
        validate = new JButton("Create");
        
        
        
        
        //////////////////////////////////
        // Grid Bag Constraints
        GridBagConstraints gbTitle = new GridBagConstraints();
        GridBagConstraints gblabBox = new GridBagConstraints();
        GridBagConstraints gbBox = new GridBagConstraints();
        GridBagConstraints gblabPos = new GridBagConstraints();
        GridBagConstraints gbpos = new GridBagConstraints();
        GridBagConstraints gblabVal = new GridBagConstraints();
        GridBagConstraints gbval = new GridBagConstraints();
        GridBagConstraints gbValidate = new GridBagConstraints();
        
        gbTitle.gridx = 0;
        gbTitle.gridy = 0;
        gbTitle.gridwidth = 3;
        
        gblabBox.gridx = 0;
        gblabBox.gridy = 4;
        gblabBox.anchor = GridBagConstraints.LINE_END;
        
        gbBox.gridx = 2;
        gbBox.gridy = 4;
        gbBox.anchor = GridBagConstraints.LINE_START;
        
        gblabPos.gridx = 0;
        gblabPos.gridy = 2;
        gblabPos.anchor = GridBagConstraints.LINE_END;
        
        gbpos.gridx = 2;
        gbpos.gridy = 2;
        gbpos.anchor = GridBagConstraints.LINE_START;
        
        gblabVal.gridx = 0;
        gblabVal.gridy = 6;
        gblabVal.anchor = GridBagConstraints.LINE_END;
        
        gbval.gridx = 2;
        gbval.gridy = 6;
        gbval.anchor = GridBagConstraints.LINE_START;
        
        gbValidate.gridx = 0;
        gbValidate.gridy = 8;
        gbValidate.gridwidth = 3;
        
        this.add(title,gbTitle);
        this.add(nameSpe,gblabBox);
        this.add(boxCategory,gbBox);
        this.add(labPosition,gblabPos);
        this.add(position,gbpos);
        this.add(labValue,gblabVal);
        this.add(value,gbval);
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
