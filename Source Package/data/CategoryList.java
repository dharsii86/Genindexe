/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import database.OrderDB;
import java.util.HashMap;
import nf.SpecieCategory;

/**
 *
 * @author DharSii
 */
public class CategoryList {
    
    private static HashMap<String,SpecieCategory> categoryList;

    public CategoryList() {
    }
    
    // Allow the creation of the 
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
    
    
<<<<<<< HEAD
    public static String[] getListSpecieFromCat(String cat){
	ArrayList<String> res = new ArrayList<>();
	SpecieCategory sCat = categoryList.get(cat);
        Set<Specie> setSpe = sCat.getSpecies();
        List<Specie> list = new ArrayList<>(setSpe);
        for (Specie list1 : list) {
            res.add(list1.getName());
        }
        String[] result = new String[ res.size() ];
        return res.toArray( result );
    }
=======
>>>>>>> 6798d3c3b4c5a1456ec70890fa1e4252d3126181
    
}
