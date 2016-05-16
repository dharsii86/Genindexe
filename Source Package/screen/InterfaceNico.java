/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

/**
 *
 * @author DharSii
 */
public class InterfaceNico extends JLabel {

    //JLabels
    private JLabel Titre = new JLabel("Order research", JLabel.CENTER);
    private JLabel CustomerTown = new JLabel("Customer Town", JLabel.CENTER);
    private JLabel CustomerName = new JLabel("Customer Name", JLabel.CENTER);
    private JLabel AnalysisName = new JLabel("Analysis Name", JLabel.CENTER);
    private JLabel OrderStatus = new JLabel("Order Status", JLabel.CENTER);
    private JLabel SamplesAnalysed = new JLabel("Analysed Samples", JLabel.CENTER);
    private JLabel Nothing1;
    private JLabel Nothing2;
    private JLabel Extenser1;
    private JLabel Extenser2;
    
    //JComboBox
    private JComboBox CustoNameCombo;
    private JComboBox CustoTownCombo;
    
    //TextArea
    private JTextArea AnalNameText;
    private JTextArea OrderStatusText;
    private JTextArea SamplesAnalText;
    
    private final MenuWindow globalScreen;

    public InterfaceNico (MenuWindow screen) {

        this.setBackground(Color.WHITE);
        this.setLayout(new GridBagLayout());
        globalScreen = screen;

        // Initialisation of the panels

        
        // Creation GridBagConstraints
        
        GridBagConstraints gbTitre = new GridBagConstraints();
        gbTitre.gridx = 0;
        gbTitre.gridy = 0;
        gbTitre.gridwidth = 6;
        //gbTitre.insets = new Insets(0, 0, 0, 10);
        //gbTitre.anchor = GridBagConstraints.LAST_LINE_END;
        gbTitre.weightx = 0;
        
        GridBagConstraints gbCustoTown = new GridBagConstraints();
        gbCustoTown.gridx = 1;
        gbCustoTown.gridy = 2;
        CustomerTown.setPreferredSize(new Dimension(50, 20));
        
        GridBagConstraints gbCustoName = new GridBagConstraints();
        gbCustoName.gridx = 1;
        gbCustoName.gridy = 3;
        CustomerName.setPreferredSize(new Dimension(50, 20));
        
        GridBagConstraints gbAnalName = new GridBagConstraints();
        gbAnalName.gridx = 2;
        gbAnalName.gridy = 5;
        AnalysisName.setPreferredSize(new Dimension(70, 20));
        
        GridBagConstraints gbOrderStat = new GridBagConstraints();
        gbOrderStat.gridx = 3;
        gbOrderStat.gridy = 5;
        OrderStatus.setPreferredSize(new Dimension(70, 20));
        
        GridBagConstraints gbSampAnal = new GridBagConstraints();
        gbSampAnal.gridx = 4;
        gbSampAnal.gridy = 5;
        SamplesAnalysed.setPreferredSize(new Dimension(70, 20));
        
        GridBagConstraints gbCusNameCombo = new GridBagConstraints();
        gbCusNameCombo.gridx = 2;
        gbCusNameCombo.gridy = 3;
        CustoNameCombo = new JComboBox();
        CustoNameCombo.setPreferredSize(new Dimension(50, 20));
        
        GridBagConstraints gbCusTownCombo = new GridBagConstraints();
        gbCusTownCombo.gridx = 2;
        gbCusTownCombo.gridy = 2;
        CustoTownCombo = new JComboBox();
        CustoTownCombo.setPreferredSize(new Dimension(50, 20));
        
        GridBagConstraints gbAnalNameText = new GridBagConstraints();
        gbAnalNameText.gridx = 2;
        gbAnalNameText.gridy = 6;
        AnalNameText.setPreferredSize(new Dimension(70, 200));
        
        GridBagConstraints gbOrderStatText = new GridBagConstraints();
        gbOrderStatText.gridx = 3;
        gbOrderStatText.gridy = 6;
        OrderStatusText.setPreferredSize(new Dimension(70, 200));
        
        GridBagConstraints gbSamplesAnalText = new GridBagConstraints();
        gbSamplesAnalText.gridx = 4;
        gbSamplesAnalText.gridy = 6;
        SamplesAnalText.setPreferredSize(new Dimension(70, 200));
        
        GridBagConstraints gbNothing1 = new GridBagConstraints();
        gbNothing1.gridx = 3;
        gbNothing1.gridy = 1;
        Nothing1.setPreferredSize(new Dimension(50, 70));
        
        GridBagConstraints gbNothing2 = new GridBagConstraints();
        gbNothing2.gridx = 3;
        gbNothing2.gridy = 4;
        Nothing2.setPreferredSize(new Dimension(50, 60));
        
        GridBagConstraints gbExtenser1 = new GridBagConstraints();
        gbExtenser1.gridx = 0;
        gbExtenser1.gridy = 6;
        gbExtenser1.gridheight = 6;
        gbExtenser1.weightx = 1;
        
        GridBagConstraints gbExtenser2 = new GridBagConstraints();
        gbExtenser2.gridx = 5;
        gbExtenser2.gridy = 6;
        gbExtenser2.gridheight = 6;
        gbExtenser2.weightx = 1;
        
        // Insertions
        this.add(Titre, gbTitre);
        this.add(CustomerTown, gbCustoTown);
        this.add(CustomerName, gbCustoName);
        this.add(AnalysisName, gbAnalName);
        this.add(OrderStatus, gbOrderStat);
        this.add(SamplesAnalysed, gbSampAnal);
        this.add(CustoNameCombo, gbCusNameCombo);
        this.add(CustoTownCombo, gbCusTownCombo);
        this.add(AnalNameText, gbAnalNameText);
        this.add(OrderStatusText, gbOrderStatText);
        this.add(SamplesAnalText, gbSamplesAnalText);
        Nothing1 = new JLabel();
        this.add(Nothing1, gbNothing1);
        Nothing2 = new JLabel();
        this.add(Nothing2, gbNothing2);
        Extenser1 = new JLabel();
        this.add(Extenser1, gbExtenser1);
        Extenser2 = new JLabel();
        this.add(Extenser2, gbExtenser2);
        //this.add(component, constraints);
        
        CustoTownCombo.addActionListener (new ActionListener()
	{
		public void actionPerformed (ActionEvent e){
		
		}
	});
        
        CustoNameCombo.addActionListener (new ActionListener()
	{
		public void actionPerformed (ActionEvent e){
		
		}
	});
        
    }



    private void close() {
        try {
            globalScreen.delMiddle();
        } catch (NullPointerException ex) {
            System.out.println("Ligne 145");
        }
    }

}


