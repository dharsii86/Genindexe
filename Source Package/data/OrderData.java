/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
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

    /**
     * Creation of the Category hashmap from the database
     * 
     */
    public void create(){
        
        String[] catList = database.OrderDB.getCategory();
        for (String cat: catList){
            // creation of the new category
            SpecieCategory category = new SpecieCategory(cat);
            
            String[] specList = database.OrderDB.getSpecies(cat);
            for(String spec : specList){
                
                category.addSpecie(new Specie(spec));
                
            }
         categoryList.put(category.getName(),category);
        }
    }
    
    public HashMap getCategories(){
        return(categoryList);
    }
    
    public String[] getListSpecieFromCat(String cat){
	ArrayList<String> res = new ArrayList<>();
	SpecieCategory sCat = categoryList.get(cat);
        Set<Specie> setSpe = sCat.getSpecies();
        List<Specie> list = new ArrayList<>(setSpe);
        for(int i=0; i<list.size();i++){
            res.add(list.get(i).getName());
        }
        String[] result = new String[ res.size() ];
        return res.toArray( result );
    }
}


