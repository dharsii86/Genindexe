/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import database.AnalysisDB;
import database.ConnectionDB;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author DharSii
 */
public class CreateMicroplateInterface extends JPanel{
    
    private final MenuWindow globalScreen;
    
    private HashMap<String, ArrayList> TabSample;
    
    private JComboBox boxAnalysis;

    public CreateMicroplateInterface(MenuWindow globalScreen) {
        this.TabSample = new HashMap<>();
        this.globalScreen = globalScreen;
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.white);
        this.setOpaque(true);
        
        showCreationInterface();
        
        this.setVisible(true);
    }
    
    
    private void showCreationInterface(){
        boxAnalysis = new JComboBox(AnalysisDB.getAnalysis());
        JButton boutCreation = new JButton("Creation of the microplate");
        boutCreation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            launchRecordInfoSample((String) boxAnalysis.getSelectedItem());
            
            }
        });
        
        GridBagConstraints gbBox = new GridBagConstraints();
        gbBox.gridx = 1;
        gbBox.gridy = 2;
        gbBox.anchor = GridBagConstraints.LINE_START;
        
        GridBagConstraints gbLabBox = new GridBagConstraints();
        gbLabBox.gridx = 0;
        gbLabBox.gridy = 2;
        gbLabBox.anchor = GridBagConstraints.LINE_END;
        gbLabBox.insets = new Insets(0,0,0,10);
        
        GridBagConstraints gbTitle = new GridBagConstraints();
        gbTitle.gridx = 0;
        gbTitle.gridy = 0;
        gbTitle.gridwidth = 2;
        gbTitle.anchor = GridBagConstraints.CENTER;
        
        GridBagConstraints gbssTitle = new GridBagConstraints();
        gbssTitle.gridx = 0;
        gbssTitle.gridy = 1;
        JLabel pan1 = new JLabel();
        pan1.setPreferredSize(new Dimension(50,50));
        pan1.setBackground(Color.red);
        
        GridBagConstraints gbValide = new GridBagConstraints();
        gbValide.gridx = 0;
        gbValide.gridy = 3;
        gbValide.gridwidth = 2;
        gbValide.anchor = GridBagConstraints.CENTER;
        gbValide.insets = new Insets(50,0,0,0);
        
        JLabel title = new JLabel("Microplate creation");
        title.setFont(title.getFont().deriveFont(24.0f));
        JLabel labBox = new JLabel("Type of analysis :");
        
        this.add(title,gbTitle);
        this.add(pan1,gbssTitle);
        this.add(boxAnalysis,gbBox);
        this.add(labBox,gbLabBox);
        this.add(boutCreation,gbValide);
    }
    
    private void launchRecordInfoSample(String ana){
        ArrayList<Integer> listID = new ArrayList();
        System.out.println("Analysis : "+ana);
        int nb3 = Integer.parseInt(ConnectionDB.requestOneResult("Select count(*) from sample where state=3"));
        if (nb3 < 8){//dans le cas ou on a pas assez de valeur en 3
            ArrayList res3 = ConnectionDB.requestStatic("Select sample_id from sample where state=3");
            for(int i = 0; i <= nb3; i++){
                listID.add((int)((ArrayList)res3.get(0)).get(0));
            }
            int nb2 = Integer.parseInt(ConnectionDB.requestOneResult("Select count(*) from sample where state=2"));
            if(nb2+nb3 < 8){
                ArrayList res2 = ConnectionDB.requestStatic("Select sample_id from sample where state=2 ");
                for(int i = 0; i <= nb3; i++){
                    listID.add((int)((ArrayList)res2.get(0)).get(0));
                } 
                int nb1 = Integer.parseInt(ConnectionDB.requestOneResult("Select count(*) from sample where state=1"));
                ArrayList res1 = ConnectionDB.requestStatic("Select sample_id from sample where state=1 limit "+(8-(nb3+nb2)));
                for(int i = 0; i <= nb3; i++){
                    listID.add((int)((ArrayList)res1.get(0)).get(0));
                }
            }else{
               ArrayList res2 = ConnectionDB.requestStatic("Select sample_id from sample where state=2 limit "+(8-nb3));
                for(int i = 0; i <= nb3; i++){
                    listID.add((int)((ArrayList)res2.get(0)).get(0));
                } 
            }
        }else{//finit le remplissage de la liste
            ArrayList res3 = ConnectionDB.requestStatic("Select sample_id from sample where state=3 limit 8");
            for(int i = 0; i <= nb3; i++){
                listID.add((int)((ArrayList)res3.get(0)).get(0));
            }
            
        }

        //System.out.println(nb1);
   
    }   
}