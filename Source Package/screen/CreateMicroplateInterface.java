/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import data.AnalysisList;
import database.AnalysisDB;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 *
 * @author DharSii
 */
public class CreateMicroplateInterface extends JPanel{
    
    private final MenuWindow globalScreen;
    
    private JComboBox boxAnalysis;

    public CreateMicroplateInterface(MenuWindow globalScreen) {
        this.globalScreen = globalScreen;
        
        
        showCreationInterface();
        
    }
    
    
    private void showCreationInterface(){
        boxAnalysis = new JComboBox(AnalysisDB.getAnalysis());
        
        
        
        
        
        
        
        this.setVisible(true);
    }
    
    
}
