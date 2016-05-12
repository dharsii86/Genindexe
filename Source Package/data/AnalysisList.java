/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import database.AnalysisDB;
import java.util.HashMap;
import nf.Analysis;

/**
 *
 * @author DharSii
 */
public class AnalysisList {
    private static HashMap<String,Analysis> categoryList;

    
    
    // Allow the creation of all the analysis
    public static void create(){
       /* String[] anaList = AnalysisDB.getAnalysis();
        
        for (String ana: anaList){
            // creation of the new analysis
            Analysis analys = new Analysis(ana);
            
            String[] specList = getSpecies(ana);
            for(String spec : specList){
                
                category.addSpecie(new Specie(spec));
                
            }
         categoryList.put(category.getName(),category);
        }
    */
        
    }
}
