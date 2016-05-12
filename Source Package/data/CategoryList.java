/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import database.OrderDB;
import java.util.HashMap;
import nf.Specie;
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
        CategoryList.categoryList = new HashMap<String, SpecieCategory>();
        String[] catList = OrderDB.getCategory();
        System.out.println("category Creation");
        
        for (String cat: catList){
            // creation of the new category
            SpecieCategory category = new SpecieCategory(cat);
            
            String[] specList = OrderDB.getSpecies(cat);
            for(String spec : specList){
                category.addSpecie(new Specie(spec));
            }
            categoryList.put(category.getName(),category);
         
        }
        System.out.println(categoryList);
    }
    
    
    
}
