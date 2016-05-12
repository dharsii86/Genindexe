/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.HashMap;
import nf.*;

/**
 *
 * @author DharSii
 */
public class AnalysisList {
    private static HashMap<String,Analysis> categoryList;

    
    
    // Allow the creation of all the analysis
    public static void create(){
        String[] catList = OrderDB.getCategory();
        for (String cat: catList){
            // creation of the new category
            SpecieCategory category = new SpecieCategory(cat);
            
            String[] specList = OrderDB.getSpecies(cat);
            for(String spec : specList){
                
                category.addSpecie(new Specie(spec));
                
            }
         categoryList.put(category.getName(),category);
        }
        
    }
}
