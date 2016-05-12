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
 * @author Quentin Bonenfant
 */
public class OrderData {
    
    private static HashMap<String,SpecieCategory> categoryList;
    
    public OrderData(){
        
        categoryList= new HashMap<String,SpecieCategory>();
    }

    public void addCategory(String name){
        
    }    
    
    /**
     * Creation of the Category hashmap from the database
     * 
     *
     */
    public void create(){
        
        String[] catList = database.OrderDB.getCategory();
        for (String cat: catList){
            SpecieCategory category = new SpecieCategory(cat);
            
            String[] specList = database.OrderDB.getSpecies(cat);
            for(String spec : specList){
                
                category.addSpecie(new Specie(spec));
                
            }
         categoryList.put(category.getName(),category);
        }
        
    }
}


