/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import data.CustomerList;
import data.ExploreOrder;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

/**
 *
 * @author DharSii
 */
public class OrderResearch extends JLabel {
    
    private String[] tabCustName = {""};
    private String TownSelected = "";

    //JLabels
    private JLabel Titre = new JLabel("Order research", JLabel.CENTER);
    private JLabel CustomerTown = new JLabel("Customer Town :", JLabel.CENTER);
    private JLabel CustomerName = new JLabel("Customer Name :", JLabel.CENTER);
    private JLabel AnalysisName = new JLabel("Analysis Name", JLabel.CENTER);
    private JLabel OrderStatus = new JLabel("Order Status", JLabel.CENTER);
    private JLabel SamplesAnalysed = new JLabel("Analysed Samples", JLabel.CENTER);
    private JLabel Nothing1 = new JLabel();
    private JLabel Nothing2 = new JLabel();
    private JLabel Extenser1 = new JLabel();
    private JLabel Extenser2 = new JLabel();
    
    //JComboBox
    private JComboBox CustoNameCombo;
    private JComboBox CustoTownCombo;
    
    //TextArea
    private JTextArea AnalNameText = new JTextArea("None");
    private JTextArea OrderStatusText = new JTextArea("None");
    private JTextArea SamplesAnalText = new JTextArea("None");
    
    private final MenuWindow globalScreen;

    public OrderResearch (MenuWindow screen) {

        this.setBackground(Color.WHITE);
        this.setOpaque(true);
        this.setLayout(new GridBagLayout());
        globalScreen = screen;
        // Creation GridBagConstraints
        
        GridBagConstraints gbTitre = new GridBagConstraints();
        gbTitre.gridx = 0;
        gbTitre.gridy = 0;
        gbTitre.gridwidth = 6;
        gbTitre.weightx = 0;
        
        GridBagConstraints gbCustoTown = new GridBagConstraints();
        gbCustoTown.gridx = 1;
        gbCustoTown.gridy = 2;
        gbCustoTown.insets = new Insets(10, 10, 10, 10);
        CustomerTown.setPreferredSize(new Dimension(100, 20));
        
        GridBagConstraints gbCustoName = new GridBagConstraints();
        gbCustoName.gridx = 1;
        gbCustoName.gridy = 3;
        
        CustomerName.setPreferredSize(new Dimension(100, 20));
        
        GridBagConstraints gbAnalName = new GridBagConstraints();
        gbAnalName.gridx = 2;
        gbAnalName.gridy = 5;
        AnalysisName.setBorder(BorderFactory.createLineBorder(Color.black));
        AnalysisName.setPreferredSize(new Dimension(140, 20));
        
        GridBagConstraints gbOrderStat = new GridBagConstraints();
        gbOrderStat.gridx = 3;
        gbOrderStat.gridy = 5;
        OrderStatus.setBorder(BorderFactory.createLineBorder(Color.black));
        OrderStatus.setPreferredSize(new Dimension(140, 20));
        
        GridBagConstraints gbSampAnal = new GridBagConstraints();
        gbSampAnal.gridx = 4;
        gbSampAnal.gridy = 5;
        SamplesAnalysed.setBorder(BorderFactory.createLineBorder(Color.black));
        SamplesAnalysed.setPreferredSize(new Dimension(140, 20));
        
        GridBagConstraints gbCusNameCombo = new GridBagConstraints();
        gbCusNameCombo.gridx = 2;
        gbCusNameCombo.gridy = 3;
        CustoNameCombo = new JComboBox();
        CustoNameCombo.setPreferredSize(new Dimension(100, 20));
        
        GridBagConstraints gbCusTownCombo = new GridBagConstraints();
        gbCusTownCombo.gridx = 2;
        gbCusTownCombo.gridy = 2;
        gbCusTownCombo.insets = new Insets(10, 10, 10, 10);
        CustoTownCombo = new JComboBox(CustomerList.getCustomerTowns());
        CustoTownCombo.setPreferredSize(new Dimension(100, 20));
        
        GridBagConstraints gbAnalNameText = new GridBagConstraints();
        gbAnalNameText.gridx = 2;
        gbAnalNameText.gridy = 6;
        AnalNameText.setBorder(BorderFactory.createLineBorder(Color.black));
        AnalNameText.setPreferredSize(new Dimension(140, 200));
        
        GridBagConstraints gbOrderStatText = new GridBagConstraints();
        gbOrderStatText.gridx = 3;
        gbOrderStatText.gridy = 6;
        OrderStatusText.setBorder(BorderFactory.createLineBorder(Color.black));
        OrderStatusText.setPreferredSize(new Dimension(140, 200));
        
        GridBagConstraints gbSamplesAnalText = new GridBagConstraints();
        gbSamplesAnalText.gridx = 4;
        gbSamplesAnalText.gridy = 6;
        SamplesAnalText.setBorder(BorderFactory.createLineBorder(Color.black));
        SamplesAnalText.setPreferredSize(new Dimension(140, 200));
        
        GridBagConstraints gbNothing1 = new GridBagConstraints();
        gbNothing1.gridx = 3;
        gbNothing1.gridy = 1;
        Nothing1.setPreferredSize(new Dimension(140, 50));
        
        GridBagConstraints gbNothing2 = new GridBagConstraints();
        gbNothing2.gridx = 3;
        gbNothing2.gridy = 4;
        Nothing2.setPreferredSize(new Dimension(140, 50));
        
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
        this.add(Nothing1, gbNothing1);
        this.add(Nothing2, gbNothing2);
        this.add(Extenser1, gbExtenser1);
        this.add(Extenser2, gbExtenser2);
        //this.add(component, constraints);
        this.setVisible(true);
        CustoTownCombo.addActionListener (new ActionListener()
	{
		public void actionPerformed (ActionEvent e){
                    //JComboBox cb = (JComboBox)e.getSource();
                    TownSelected = (String)CustoTownCombo.getSelectedItem();
                    //CustoNameCombo = new JComboBox(CustomerList.getCustomerNameByTown(town));
                    tabCustName = CustomerList.getCustomerNameByTown(TownSelected);
            
                    DefaultComboBoxModel custModel = new DefaultComboBoxModel(tabCustName);
                    CustoNameCombo.setModel( custModel );
		}
	});
        
        CustoNameCombo.addActionListener (new ActionListener()
	{
		public void actionPerformed (ActionEvent e){
                    String name = (String)CustoNameCombo.getSelectedItem();
                    
                    //Create the current login with the location and the customer name
                    String login = name + TownSelected;
                    
                    //Attributes allowing to create the results for each JTextArea fields
                    String AnalName = "";
                    String OrderStat = "";
                    String Statistic = "";
                    
                    //List of orders for the current login
                    ArrayList<ArrayList> OrderList = ExploreOrder.getOrderList(login);
                    
                    for (Integer i = 0; i < OrderList.size(); i++){
                        ArrayList ListAux = OrderList.get(i);
                        
                        int id = Integer.parseInt(ListAux.get(0).toString());
                        
                        AnalName += ExploreOrder.getAnalysisName(id) + "\n";
                        OrderStat += ExploreOrder.getOrderStatus(id) + "\n";
                        Statistic += ExploreOrder.getAnalysisDone(id)+ " / " + ExploreOrder.getTotalAnalysis(id)+ "\n";
                    }
                    
                    //Insertion of the results in the right JTextArea
                    AnalNameText.setText(AnalName);
                    OrderStatusText.setText(OrderStat);
                    SamplesAnalText.setText(Statistic);
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


